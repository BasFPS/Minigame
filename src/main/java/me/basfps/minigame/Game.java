package me.basfps.minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Minigame plugin;
    private GameManager manager;

    public HashMap<UUID, Integer> playerPoints = new HashMap<>();


    public Game(Minigame plugin, GameManager manager) {
        this.plugin = plugin;
        this.manager = manager;
    }

    public void start() {
        for (UUID u : manager.gamePlayers) {
            playerPoints.put(u, 0);
        }


    }

    public void gameEnd(UUID u) {

        manager.sendGameMessage(ChatColor.GREEN + "" + Bukkit.getPlayer(u).getName() + " HAS WON THE GAME!");
        manager.setGameState(GameState.LOBBY);


    }



}
