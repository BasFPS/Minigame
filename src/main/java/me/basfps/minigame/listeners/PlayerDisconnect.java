package me.basfps.minigame.listeners;

import me.basfps.minigame.GameManager;
import me.basfps.minigame.GameState;
import me.basfps.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconnect implements Listener {

    Minigame plugin;
    GameManager manager;


    public PlayerDisconnect(Minigame plugin, GameManager manager) {
        this.plugin = plugin;
        this.manager = manager;
    }

    @EventHandler
    public void playerDisconnectEvent(PlayerQuitEvent e) {
        if (manager.gamePlayers.contains(e.getPlayer().getUniqueId())) {
            manager.sendGameMessage(ChatColor.RED + e.getPlayer().getName() + " has left the game");
            manager.gamePlayers.remove(e.getPlayer().getUniqueId());
            if (manager.gamePlayers.size() < 1) {
                manager.setGameState(GameState.LOBBY);
                Bukkit.broadcastMessage(ChatColor.BLUE + "Game ended due to no players!");
            }
        }
    }




}
