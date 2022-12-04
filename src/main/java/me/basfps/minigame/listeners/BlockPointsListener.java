package me.basfps.minigame.listeners;

import me.basfps.minigame.Game;
import me.basfps.minigame.GameManager;
import me.basfps.minigame.GameState;
import me.basfps.minigame.Minigame;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;

public class BlockPointsListener implements Listener {

    private Minigame plugin;
    private GameManager manager;
    private Game game;

    public BlockPointsListener(Minigame plugin, GameManager manager, Game game) {
        this.plugin = plugin;
        this.manager = manager;
        this.game = game;
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (manager.getGameState() == GameState.IN_GAME) {
            if (manager.gamePlayers.contains(p.getUniqueId())) {

                UUID pUUID = p.getUniqueId();
                game.playerPoints.replace(pUUID, game.playerPoints.get(pUUID), game.playerPoints.get(pUUID) + 1);
                p.sendMessage(ChatColor.GREEN + "+1 Points");
                p.sendMessage("points: " + game.playerPoints.get(pUUID));
                if (game.playerPoints.get(pUUID) == 10) {
                    game.gameEnd(pUUID);
                }


            }
        }
    }

}



