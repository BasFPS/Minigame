package me.basfps.minigame.commands;

import me.basfps.minigame.Game;
import me.basfps.minigame.GameManager;
import me.basfps.minigame.GameState;
import me.basfps.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveCommand implements CommandExecutor {

    private final Minigame plugin;
    private final GameManager manager;

    public LeaveCommand(Minigame plugin, GameManager manager) {
        this.plugin = plugin;
        this.manager = manager;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if ((sender instanceof Player)) {
            Player p = (Player) sender;
            if(manager.gamePlayers.contains(p.getUniqueId())) {
                manager.gamePlayers.remove(p.getUniqueId());
                sender.sendMessage(ChatColor.GREEN + "You have been removed from the game");
                manager.sendGameMessage(ChatColor.RED + p.getName() + " has left the game!");

                if ((manager.gamePlayers.size() < 1) && (manager.getGameState() == GameState.STARTING || manager.getGameState() == GameState.IN_GAME)) {
                    Bukkit.broadcastMessage(ChatColor.RED + "Countdown stopped due to a player leaving!");

                    manager.setGameState(GameState.LOBBY);

                }
            } else {
                sender.sendMessage(ChatColor.RED + "You are not in a game");
            }


        } else {
            sender.sendMessage("You are not a player!");
        }


        return true;
    }
}
