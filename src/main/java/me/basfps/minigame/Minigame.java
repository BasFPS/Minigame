package me.basfps.minigame;

import me.basfps.minigame.commands.JoinCommand;
import me.basfps.minigame.commands.LeaveCommand;
import me.basfps.minigame.commands.StartCommand;
import me.basfps.minigame.listeners.BlockPointsListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Minigame extends JavaPlugin {

    Logger logger = Logger.getLogger(this.getName());


    public void onEnable() {

        GameManager manager = new GameManager(this);
        getCommand("start").setExecutor(new StartCommand(this, manager));
        getCommand("leave").setExecutor(new LeaveCommand(this, manager));
        getCommand("join").setExecutor(new JoinCommand(this, manager));
        getServer().getPluginManager().registerEvents(new BlockPointsListener(this, manager, manager.game), this);

        logger.log(Level.INFO, "\u001B[32m [MINIGAME] Plugin is enabled! \u001B[0m");


    }

}
