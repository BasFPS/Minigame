package me.basfps.minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.ArrayList;

public class LobbyPhase {

    private Minigame plugin;
    private GameManager manager;


    public LobbyPhase(Minigame plugin, GameManager manager) {
        this.plugin = plugin;
        this.manager = manager;
        manager.gamePlayers = new ArrayList<>();
        manager.teleportGamePlayers(new Location(Bukkit.getWorld("world"), 25, 100, 25));
        Bukkit.broadcastMessage(ChatColor.GOLD + "Minigame is recruiting for a new game! /join to connect!");
    }








}
