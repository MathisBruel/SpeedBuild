package fr.mathis_bruel.endorah.speedbuild.speedbuild.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        return false;
    }
}
