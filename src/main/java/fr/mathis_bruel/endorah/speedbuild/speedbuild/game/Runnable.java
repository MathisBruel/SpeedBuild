package fr.mathis_bruel.endorah.speedbuild.speedbuild.game;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.scoreboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Runnable extends BukkitRunnable {
    @Override
    public void run() {
        Game game = Main.getGame();
        if (game.getState() == States.WAITING) {
            Bukkit.getOnlinePlayers().forEach(player -> {

                FastBoard board = Main.getBoard(player.getUniqueId());
                board.updateTitle("§6§lSpeedBuild");
                if (game.getPlayers().contains(player)) {
                    board.updateLines(new ArrayList<String>() {
                        {
                            add("§7§m-----------§6§m-----------");
                            add("§6§l Endorah §7- §r§eSpeedBuild");
                            add("§6§l " + game.getName());
                            add("§r");
                            add("§7State: §f" + game.getState().toString());
                            add("§r");
                            add("§7Players: §f" + game.getPlayers().size() + "§7/§f" + game.getMaxPlayers());
                            add("§r");
                            add("§7§m-----------§6§m-----------");


                        }
                    });
                }else {
                    board.updateLines(new ArrayList<String>() {
                        {
                            add("§7§m-----------§6§m-----------");
                            add("§6§l Endorah §7- §r§eSpeedBuild");
                            add("§6§l " + game.getName());
                            add("§r");
                            add("§7Players: §f" + game.getPlayers().size() + "§7/§f" + game.getMaxPlayers());
                            add("§r");
                            add("§6You are not in the game");
                            add("§6§lSend /join to join this game");
                            add("§7§m-----------§6§m-----------");
                        }
                    });
                }
            });
        } else if (game.getState() == States.STARTING) {

        } else if (game.getState() == States.BUILDING) {

        } else if (game.getState() == States.ENDING) {

        } else if (game.getState() == States.ENDED) {

        }
    }
}
