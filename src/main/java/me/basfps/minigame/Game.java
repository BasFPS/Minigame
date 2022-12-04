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
        for (UUID uuid : manager.gamePlayers) {
            if (uuid != u) {
                Bukkit.getPlayer(uuid).sendTitle(ChatColor.RED + "YOU LOST!", "", 10, 55, 10);
            }
        }
        Bukkit.getPlayer(u).sendTitle(ChatColor.GOLD + "YOU WON THE GAME!", "", 5, 55, 5);
        manager.setGameState(GameState.LOBBY);
        Bukkit.getPlayer(u).playSound(Bukkit.getPlayer(u).getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 2.0f, 1.0f);


    }



}
