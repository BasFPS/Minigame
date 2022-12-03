package me.basfps.minigame.commands;

import me.basfps.minigame.GameManager;
import me.basfps.minigame.GameState;
import me.basfps.minigame.Minigame;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {

    private Minigame plugin;
    private GameManager manager;

   public StartCommand(Minigame plugin, GameManager manager) {
       this.plugin = plugin;
       this.manager = manager;
   }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (manager.getGameState() == GameState.STARTING || manager.getGameState() == GameState.IN_GAME) {
            sender.sendMessage(ChatColor.RED + "Game already in progress.");
        }


        if (manager.gamePlayers.size() > 0) {

            sender.sendMessage(ChatColor.GREEN + "Game countdown has started");
            manager.setGameState(GameState.STARTING);

        } else {
            sender.sendMessage(ChatColor.RED + "Not enough players!");
        }




        return true;
    }



}
