package me.basfps.minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class GameManager {

    private Minigame plugin;
    private GameState gameState = GameState.LOBBY;
    public ArrayList<UUID> gamePlayers = new ArrayList<>();


    public GameManager(Minigame plugin) {
        this.plugin = plugin;
    }


    public GameState getGameState() {
        return this.gameState;
    }

    Game game = new Game(plugin, this);


    public void setGameState(GameState state) {
        if (this.gameState == state) return;
        if (this.gameState == GameState.IN_GAME && state == GameState.STARTING) return;
        this.gameState = state;

        switch (gameState) {

            case LOBBY:
                new LobbyPhase(plugin, this).startLobby();
                break;
            case STARTING:
                new Countdown(plugin, this).startCount();
            case IN_GAME:
                game.start();



        }



    }

    //UTIL
    public void teleportGamePlayers(Location loc) {
        for (UUID u : gamePlayers) {
            Bukkit.getPlayer(u).teleport(loc);
        }
    }

    public void sendGameMessage(String message) {
        for (UUID u : gamePlayers) {
            Bukkit.getPlayer(u).sendMessage(message);
        }
    }

    public void sendTitleMessage(String message, int fadeIn, int stay, int fadeOut) {
        for (UUID u : gamePlayers) {
            Bukkit.getPlayer(u).sendTitle(message, "", fadeIn, stay, fadeOut);
        }
    }

    public void sendGameSound(Sound sound) {
        for (UUID u : gamePlayers) {
            Player p = Bukkit.getPlayer(u);
            p.playSound(p.getLocation(), sound , 2.0f, 1.0f );
        }
    }





}
