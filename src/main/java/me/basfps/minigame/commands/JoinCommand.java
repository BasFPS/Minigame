package me.basfps.minigame.commands;

import me.basfps.minigame.GameManager;
import me.basfps.minigame.Minigame;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand implements CommandExecutor {

    private Minigame plugin;
    private GameManager manager;

    public JoinCommand(Minigame plugin, GameManager manager) {
        this.plugin = plugin;
        this.manager = manager;
    }




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if ((sender instanceof Player)) {
            Player p = (Player) sender;


            switch(manager.getGameState()) {

                case LOBBY:
                    if(!(manager.gamePlayers.contains(p.getUniqueId()))) {
                        manager.gamePlayers.add(p.getUniqueId());
                        sender.sendMessage(ChatColor.GREEN + "You have joined the game");
                        manager.sendGameMessage(ChatColor.GREEN + p.getName() + " has joined the game!");

                    } else {
                        sender.sendMessage(ChatColor.RED + "You are already in a game! ");
                    }
                    break;
                case IN_GAME:
                    sender.sendMessage(ChatColor.RED + "There is already a game playing");
                    break;
                case STARTING:
                    sender.sendMessage(ChatColor.RED + "There is a game already starting");
                    break;



            }










        } else {
            sender.sendMessage("You are not a player");
        }



        return true;
    }
}
