package fr.mathis_bruel.endorah.speedbuild.speedbuild.game;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.scoreboard.FastBoard;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.Utils;
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
                            add("§7Team: " + Utils.getColorString(game.getTeamByPlayer(player).getColor()) + game.getTeamByPlayer(player).getName());
                            add("§7§m-----------§6§m-----------");
                        }
                    });
                } else {
                    board.updateLines(new ArrayList<String>() {
                        {
                            add("§7§m-----------§6§m-----------");
                            add("§6§l Endorah §7- §r§eSpeedBuild");
                            add("§6§l " + game.getName());
                            add("§r");
                            add("§7Players: §f" + game.getPlayers().size() + "§7/§f" + game.getMaxPlayers());
                            add("§r");
                            add("§6You are not in the game");
                            add("§6Send §l/sb join §r§6to join this game");
                            add("§7§m-----------§6§m-----------");
                        }
                    });
                }
            });
        } else if (game.getState() == States.STARTING) {
            if (Main.getGame().getCount() == 0) {
                game.setState(States.RUNNING);
                game.start();

            }else {
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
                                add("§7Starting in: §f" + Main.getGame().getCount() + "§7s");
                                add("§r");
                                add("§7Players: §f" + game.getPlayers().size() + "§7/§f" + game.getMaxPlayers());
                                add("§r");
                                add("§7Team: " + Utils.getColorString(game.getTeamByPlayer(player).getColor()) + game.getTeamByPlayer(player).getName());
                                add("§7§m-----------§6§m-----------");
                            }
                        });
                        switch (Main.getGame().getCount()) {
                            case 10:
                                player.sendMessage("§6The game will start in §f10s");
                                player.sendTitle("§6❿", "", 5, 40, 5);
                                break;
                            case 5:
                                player.sendMessage("§6The game will start in §f5s");
                                player.sendTitle("§6❺", "", 5, 20, 0);
                                break;
                            case 4:
                                player.sendMessage("§6The game will start in §f4s");
                                player.sendTitle("§6❹", "", 0, 20, 0);
                                break;
                            case 3:
                                player.sendMessage("§6The game will start in §f3s");
                                player.sendTitle("§6❸", "", 0, 20, 0);
                                break;
                            case 2:
                                player.sendMessage("§6The game will start in §f2s");
                                player.sendTitle("§6❷", "", 0, 20, 0);
                                break;
                            case 1:
                                player.sendMessage("§6The game will start in §f1s");
                                player.sendTitle("§6❶", "", 0, 20, 0);
                                break;

                        }
                    } else {
                        board.updateLines(new ArrayList<String>() {
                            {
                                add("§7§m-----------§6§m-----------");
                                add("§6§l Endorah §7- §r§eSpeedBuild");
                                add("§6§l " + game.getName());
                                add("§r");
                                add("§7Players: §f" + game.getPlayers().size() + "§7/§f" + game.getMaxPlayers());
                                add("§r");
                                add("§6You are not in the game");
                                add("§6You can not join the game because it is starting");
                                add("§7§m-----------§6§m-----------");
                            }
                        });
                    }
                });
                Main.getGame().setCount(Main.getGame().getCount() - 1);
            }

        } else if (game.getState() == States.RUNNING) {

        } else if (game.getState() == States.BUILDING) {

        } else if (game.getState() == States.ENDING) {

        } else if (game.getState() == States.ENDED) {

        }
    }
}
