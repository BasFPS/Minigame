package me.basfps.minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class LobbyPhase {

    private Minigame plugin;
    private GameManager manager;


    public LobbyPhase(Minigame plugin, GameManager manager) {
        this.plugin = plugin;
        this.manager = manager;
    }

    public void startLobby() {
        manager.teleportGamePlayers(new Location(Bukkit.getWorld("world"), 25, 100, 25));
        manager.sendGameMessage(ChatColor.GREEN + "Teleporting to LOBBY");
    }






}
