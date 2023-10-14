package fr.mathis_bruel.endorah.speedbuild.speedbuild.game;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.scoreboard.FastBoard;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class Runnable extends BukkitRunnable {
    int restartBuild = 5;
    int viewTime = Main.getGame().getViewTime();
    @Override
    public void run() {
        Game game = Main.getGame();

        /*
                        Manage the game
         */

        if(game.getState() == States.RUNNING){
            if(restartBuild == 0){
                game.setState(States.VIEWBUILD);
                // choise a random build
                Build build = game.getBuilds().get(new Random().nextInt(game.getBuilds().size()));
                game.setCurrentBuild(build);
                game.setBlocksToRemove(build.spawn(game));
                restartBuild = 5;
            }else{
                game.sendPlayers("§7The build spawn in §f" + restartBuild + "§7 seconds");
                restartBuild--;
            }

        }
        if(game.getState() == States.VIEWBUILD){
            if(viewTime == 0){
                game.setState(States.BUILDING);
                game.clearBlocksToRemove();
                game.sendPlayers("§7You have §f" + game.getCurrentBuild().getBuildTime() + "§7 seconds to build the build");
                game.giveItems();
                viewTime = Main.getGame().getViewTime();

            }else{
                game.sendPlayers("§7You only have §f" + viewTime + "§7 seconds left to watch the build");
                viewTime--;
            }
        }







        /*
                          Scoreboard
         */


        if (game.getState() == States.WAITING) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                FastBoard board = Main.getBoard(player.getUniqueId());
                board.updateTitle("§6§lSpeedBuild");
                if (game.getPlayers().contains(player)) {
                    board.updateLines(new ArrayList<>() {
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
                game.setGamemode(GameMode.CREATIVE);
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
            game.incrementTimer();
            Bukkit.getOnlinePlayers().forEach(player -> {
                FastBoard board = Main.getBoard(player.getUniqueId());
                board.updateTitle("§6§lSpeedBuild");
                if (game.getPlayers().contains(player)) {
                    board.updateLines(new ArrayList<String>() {
                        {
                            add("§7§m-----------§6§m-----------");
                            add("§6§l Endorah §7- §r§eSpeedBuild");
                            add("§6§l " + game.getName());
                            add("§6-------- §7| §5" + game.getTimer() + "s§7 | §6--------");
                            add("§r");
                            add("§6" + game.getPlayers().size() + "§7 players remaining");
                            add("§7§lRound: §f" + game.getRound());
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
                            add("§6You can not join the game because it is starting");
                            add("§7§m-----------§6§m-----------");
                        }
                    });
                }
            });

        } else if (game.getState() == States.BUILDING) {

        } else if (game.getState() == States.ENDING) {

        } else if (game.getState() == States.ENDED) {

        }
    }
}
