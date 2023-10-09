package fr.mathis_bruel.endorah.speedbuild.speedbuild.commands;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Game;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedBuild implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*
        /sb -> open menu to manage the game
        /sb join -> join the game
        /sb leave -> leave the game
        /sb start -> start the game
        /sb stop -> stop the game
        /sb forcestart -> force start the game
        /sb leaderboard -> return leaderboard
         */
        String msgHelp = "§lSpeedBuild - Help command\n"
                + "§7/sb §8-> §7open menu to manage the game\n"
                + "§7/sb join §8-> §7join the game\n"
                + "§7/sb leave §8-> §7leave the game\n"
                + "§7/sb start §8-> §7start the game\n"
                + "§7/sb stop §8-> §7stop the game\n"
                + "§7/sb forcestart §8-> §7force start the game\n"
                + "§7/sb leaderboard §8-> §7return leaderboard\n";
        if (args.length == 0) {
            sender.sendMessage(msgHelp);
            return true;
        }
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cYou must be a player to use this command");
            return true;
        }
        Player player = (Player) sender;
        switch (args[0]) {
            case "join": {
                Game game = Main.getGame();
                if(game.getPlayers().size() >= game.getMaxPlayers()){
                    sender.sendMessage(Main.getPrefix() + "§cThe game is full");
                    return true;
                }
                if(game.getPlayers().contains(sender)){
                    sender.sendMessage(Main.getPrefix() + "§cYou are already in the game");
                    return true;
                }
                game.joinPlayer(player);
                sender.sendMessage(Main.getPrefix() + "§aYou joined the game");


                break;
            }
            case "leave":
                break;
            case "start":
                break;
            case "stop":
                break;
            case "forcestart":
                break;
            case "leaderboard":
                break;
            default:
                sender.sendMessage(msgHelp);
                break;
        }
        return true;
    }
}
