package fr.mathis_bruel.endorah.speedbuild.speedbuild.commands;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminSpeedBuild implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*
        /asb -> return help
        /asb addAdminGame <player> -> add player to admin list for give access to manage the game
        /asb removeAdminGame <player> -> remove player from admin list
        /asb setLobby [<x> <y> <z>] -> set lobby position
        /asb setMinPlayers <number> -> set min players for start game
        /asb setMaxPlayers <number> -> set max players for start game
        /asb setBuildTime <number> -> set build time
        /asb setViewTime <number> -> set view time
        /asb setRoundTime <number> -> set round time
        /asb addBuild <name> -> give a stick to player for select a build
        - pos1 -> select pos1
        - pos2 -> select pos2
        /asb removeBuild <id> -> remove build
        /asb builds [id] -> return list of builds or details of build (if id is set: spawn build)
        /asb setCenter [<x> <y> <z>] -> set center position
        /asb setBaseRadius <number> -> set base radius (player can't build and move in this radius)
        /asb setBuildRadius <number> -> set build radius (player can build in this radius)
        /asb teams -> return list of teams
        - create  <name> <color> -> create a team
        - remove <name> -> remove a team
        - setSpawn <name> [<x> <y> <z>] -> set spawn of team
        - setCenter <name> [<x> <y> <z>] -> set center of team
        - info <name> -> return info of team
        /asb enable -> enable game (allow players to join)
        /asb disable -> disable game (disallow players to join)
         */
        if(!(sender instanceof Player)){
            sender.sendMessage(Main.getPrefix()+"§cYou must be a player to use this command.");
            return true;
        }
        Player player = (Player) sender;
        if(!player.hasPermission("speedbuild.admin")){
            player.sendMessage(Main.getPrefix()+"§cYou don't have permission to use this command.");
            return true;
        }
        String helpMessage = "§6§lAdmin SpeedBuild Help\n" +
                "§e/asb -> return help\n" +
                "§e/asb addAdminGame <player> -> add player to admin list for give access to manage the game\n" +
                "§e/asb removeAdminGame <player> -> remove player from admin list\n" +
                "§e/asb setLobby [<x> <y> <z>] -> set lobby position\n" +
                "§e/asb setMinPlayers <number> -> set min players for start game\n" +
                "§e/asb setMaxPlayers <number> -> set max players for start game\n" +
                "§e/asb setBuildTime <number> -> set build time\n" +
                "§e/asb setViewTime <number> -> set view time\n" +
                "§e/asb setRoundTime <number> -> set round time\n" +
                "§e/asb addBuild <name> -> give a stick to player for select a build\n" +
                "§e- pos1 -> select pos1\n" +
                "§e- pos2 -> select pos2\n" +
                "§e/asb removeBuild <id> -> remove build\n" +
                "§e/asb builds [id] -> return list of builds or details of build (if id is set: spawn build)\n" +
                "§e/asb setCenter [<x> <y> <z>] -> set center position\n" +
                "§e/asb setBaseRadius <number> -> set base radius (player can't build and move in this radius)\n" +
                "§e/asb setBuildRadius <number> -> set build radius (player can build in this radius)\n" +
                "§e/asb teams -> return list of teams\n" +
                "§e- create  <name> <color> -> create a team\n" +
                "§e- remove <name> -> remove a team\n" +
                "§e- setSpawn <name> [<x> <y> <z>] -> set spawn of team\n" +
                "§e- setCenter <name> [<x> <y> <z>] -> set center of team\n" +
                "§e- info <name> -> return info of team\n " +
                "§e/asb enable -> enable game (allow players to join)\n" +
                "§e/asb disable -> disable game (disallow players to join)";
        switch (args.length) {

            default:
                player.sendMessage(helpMessage);
                break;
        }
        return true;
    }
}
