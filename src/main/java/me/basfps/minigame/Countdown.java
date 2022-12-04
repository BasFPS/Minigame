package me.basfps.minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown {

    Minigame plugin;
    GameManager manager;


    public Countdown(Minigame plugin, GameManager manager) {
        this.plugin = plugin;
        this.manager = manager;
    }




    public void startCount() {

        new BukkitRunnable() {

            int counter = 5;

            @Override
            public void run() {
                if (counter > 0) {
                    if (manager.getGameState() == GameState.STARTING) {
                        manager.sendTitleMessage(ChatColor.GREEN + "Game starting in " + counter + " seconds", 5, 20, 5);
                        manager.sendGameSound(Sound.UI_BUTTON_CLICK);

                    } else {
                        cancel();
                        manager.setGameState(GameState.LOBBY);

                    }
                    counter--;

                } else {
                    if (manager.getGameState() == GameState.LOBBY) {
                        cancel();
                        manager.setGameState(GameState.LOBBY);

                    } else {

                        manager.setRandomSpawns();
                        manager.teleportGamePlayersRandomly();

                        manager.sendTitleMessage(ChatColor.GREEN + "BEGIN", 15, 55, 15);
                        manager.sendGameSound(Sound.ENTITY_ENDER_DRAGON_GROWL);
                        manager.setGameState(GameState.IN_GAME);

                        cancel();
                    }



                }


            }


        }.runTaskTimer(plugin, 0L, 20L);


    }

}
