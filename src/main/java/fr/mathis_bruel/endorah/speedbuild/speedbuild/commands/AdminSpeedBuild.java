package fr.mathis_bruel.endorah.speedbuild.speedbuild.commands;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.Build;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.Game;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.Team;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.CustomNBT;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdminSpeedBuild implements CommandExecutor, TabCompleter {
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
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.getPrefix() + "§cYou must be a player to use this command.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("speedbuild.admin")) {
            player.sendMessage(Main.getPrefix() + "§cYou don't have permission to use this command.");
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
                "§e/asb removeBuild <name> -> remove build\n" +
                "§e/asb builds [name] -> return list of builds or details of build (if id is set: spawn build)\n" +
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
            case 1: {
                switch (args[0].toLowerCase()) {
                    case "enable": {
                        if (Main.getGame().isEnable()) {
                            player.sendMessage(Main.getPrefix() + "§cGame is already enabled.");
                            return true;
                        }
                        Main.getGame().setEnable();
                        player.sendMessage(Main.getPrefix() + "§aGame enabled.");
                        break;
                    }
                    case "disable": {
                        if (!Main.getGame().isEnable()) {
                            player.sendMessage(Main.getPrefix() + "§cGame is already disabled.");
                            return true;
                        }
                        Main.getGame().setDisable();
                        player.sendMessage(Main.getPrefix() + "§aGame disabled.");
                        break;
                    }
                    case "setlobby": {
                        Main.getGame().setLobby(player.getLocation());
                        player.sendMessage(Main.getPrefix() + "§aLobby set.");
                        break;
                    }
                    case "setcenter": {
                        Main.getGame().setCenter(player.getLocation());
                        break;
                    }
                    case "teams": {
                        player.sendMessage("§6§lTeams");
                        player.sendMessage("§e- create  <name> <color> -> create a team");
                        player.sendMessage("§e- remove <name> -> remove a team");
                        player.sendMessage("§e- setSpawn <name> [<x> <y> <z>] -> set spawn of team");
                        player.sendMessage("§e- setCenter <name> [<x> <y> <z>] -> set center of team");
                        player.sendMessage("§e- info <name> -> return info of team");
                        break;
                    }
                    case "builds": {
                        player.sendMessage("§6§lBuilds");
                        player.sendMessage("§e/asb builds [id] -> return list of builds or details of build (if id is set: spawn build)");
                        break;
                    }
                    case "addbuild": {
                        player.sendMessage("§6§lAdd Build");
                        player.sendMessage("§e/asb addBuild <name> -> give a stick to player for select a build");
                        player.sendMessage("§e- pos1 -> select pos1");
                        player.sendMessage("§e- pos2 -> select pos2");
                        break;
                    }
                    case "removebuild": {
                        player.sendMessage("§6§lRemove Build");
                        player.sendMessage("§e/asb removeBuild <name> -> remove build");
                        break;
                    }
                    case "setminplayers": {
                        player.sendMessage("§6§lSet Min Players");
                        player.sendMessage("§e/asb setMinPlayers <number> -> set min players for start game");
                        break;
                    }
                    case "setmaxplayers": {
                        player.sendMessage("§6§lSet Max Players");
                        player.sendMessage("§e/asb setMaxPlayers <number> -> set max players for start game");
                        break;
                    }
                    case "setbuildtime": {
                        player.sendMessage("§6§lSet Build Time");
                        player.sendMessage("§e/asb setBuildTime <number> -> set build time");
                        break;
                    }
                    case "setviewtime": {
                        player.sendMessage("§6§lSet View Time");
                        player.sendMessage("§e/asb setViewTime <number> -> set view time");
                        break;
                    }
                    case "setroundtime": {
                        player.sendMessage("§6§lSet Round Time");
                        player.sendMessage("§e/asb setRoundTime <number> -> set round time");
                        break;
                    }
                    case "setbaseradius": {
                        player.sendMessage("§6§lSet Base Radius");
                        player.sendMessage("§e/asb setBaseRadius <number> -> set base radius (player can't build and move in this radius)");
                        break;
                    }
                    case "setbuildradius": {
                        player.sendMessage("§6§lSet Build Radius");
                        player.sendMessage("§e/asb setBuildRadius <number> -> set build radius (player can build in this radius)");
                        break;
                    }
                    case "addadmingame": {
                        player.sendMessage("§6§lAdd Admin Game");
                        player.sendMessage("§e/asb addAdminGame <player> -> add player to admin list");
                        break;
                    }
                    case "removeadmingame": {
                        player.sendMessage("§6§lRemove Admin Game");
                        player.sendMessage("§e/asb removeAdminGame <player> -> remove player from admin list");
                        break;
                    }
                    default: {
                        player.sendMessage(helpMessage);
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (args[0].toLowerCase()) {
                    case "addadmingame": {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target == null) {
                            player.sendMessage(Main.getPrefix() + "§cPlayer not found.");
                            return true;
                        }
                        if (Main.getGame().getOwners().contains(target)) {
                            player.sendMessage(Main.getPrefix() + "§cPlayer is already admin.");
                            return true;
                        }
                        Main.getGame().addOwner(target);
                        player.sendMessage(Main.getPrefix() + "§aPlayer added to admin list.");
                        break;
                    }
                    case "removeadmingame": {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target == null) {
                            player.sendMessage(Main.getPrefix() + "§cPlayer not found.");
                            return true;
                        }
                        if (!Main.getGame().getOwners().contains(target)) {
                            player.sendMessage(Main.getPrefix() + "§cPlayer is not admin.");
                            return true;
                        }
                        Main.getGame().removeOwner(target);
                        player.sendMessage(Main.getPrefix() + "§aPlayer removed from admin list.");
                        break;
                    }
                    case "removebuild": {
                        if (!Main.getGame().getBuilds().contains(args[1])) {
                            player.sendMessage(Main.getPrefix() + "§cBuild not found.");
                            return true;
                        }
                        Main.getGame().removeBuild(args[1]);
                        player.sendMessage(Main.getPrefix() + "§aBuild removed.");
                        break;
                    }
                    case "builds": {
                        Main.getGame().getBuilds().forEach(build -> {
                            player.sendMessage("§6§l" + build.getName());
                            player.sendMessage("§e- pos1: " + build.getPos1());
                            player.sendMessage("§e- pos2: " + build.getPos2());
                        });
                        break;
                    }
                    case "addbuild": {
                        ItemStack item = new ItemStack(Material.STICK);
                        item = CustomNBT.set(item, "addbuild", true);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§6§lAdd Build");
                        meta.setLore(Arrays.asList("§eThis item is used to select a build.", "", "§7--------------------", "", "§eLeft click to select pos1", "§eRight click to select pos2"));
                        item.setItemMeta(meta);
                        player.getInventory().setItemInMainHand(item);
                        player.sendMessage(Main.getPrefix() + "§aItem given. Left click to select pos1, right click to select pos2.");
                    }
                    case "teams": {
                        Game game = Main.getGame();
                        game.getTeams().forEach(team -> {
                            player.sendMessage("§6§l" + team.getName());
                            player.sendMessage("§e- color: " + team.getColor());
                            player.sendMessage("§e- spawn: " + team.getSpawn());
                            player.sendMessage("§e- center: " + team.getCenter());
                        });
                        break;
                    }
                    case "setminplayers": {
                        if (!Utils.isNumber(args[1])) {
                            player.sendMessage(Main.getPrefix() + "§cThe argument must be a number.");
                            return true;
                        }
                        int minPlayers = Integer.parseInt(args[1]);
                        Main.getGame().setMinPlayers(minPlayers);
                        player.sendMessage(Main.getPrefix() + "§aMin players set to " + minPlayers + ".");
                        break;
                    }
                    case "setmaxplayers": {
                        if (!Utils.isNumber(args[1])) {
                            player.sendMessage(Main.getPrefix() + "§cThe argument must be a number.");
                            return true;
                        }
                        int maxPlayers = Integer.parseInt(args[1]);
                        Main.getGame().setMaxPlayers(maxPlayers);
                        player.sendMessage(Main.getPrefix() + "§aMax players set to " + maxPlayers + ".");
                        break;
                    }
                    case "setbuildtime": {
                        if (!Utils.isNumber(args[1])) {
                            player.sendMessage(Main.getPrefix() + "§cThe argument must be a number.");
                            return true;
                        }
                        int buildTime = Integer.parseInt(args[1]);
                        Main.getGame().setBuildTime(buildTime);
                        player.sendMessage(Main.getPrefix() + "§aBuild time set to " + buildTime + ".");
                        break;
                    }
                    case "setviewtime": {
                        if (!Utils.isNumber(args[1])) {
                            player.sendMessage(Main.getPrefix() + "§cThe argument must be a number.");
                            return true;
                        }
                        int viewTime = Integer.parseInt(args[1]);
                        Main.getGame().setViewTime(viewTime);
                        player.sendMessage(Main.getPrefix() + "§aView time set to " + viewTime + ".");
                        break;
                    }
                    case "setroundtime": {
                        if (!Utils.isNumber(args[1])) {
                            player.sendMessage(Main.getPrefix() + "§cThe argument must be a number.");
                            return true;
                        }
                        int roundTime = Integer.parseInt(args[1]);
                        Main.getGame().setRoundTime(roundTime);
                        player.sendMessage(Main.getPrefix() + "§aRound time set to " + roundTime + ".");
                        break;
                    }
                    case "setbaseradius": {
                        if (!Utils.isNumber(args[1])) {
                            player.sendMessage(Main.getPrefix() + "§cThe argument must be a number.");
                            return true;
                        }
                        int baseRadius = Integer.parseInt(args[1]);
                        Main.getGame().setBaseRadius(baseRadius);
                        player.sendMessage(Main.getPrefix() + "§aBase radius set to " + baseRadius + ".");
                        break;
                    }
                    case "setlobby": {
                        player.sendMessage("§6§lSet Build Time");
                        player.sendMessage("§e/asb setLobby [<x> <y> <z>]");
                        break;

                    }
                }
                break;

            }
            case 3: {
                switch (args[0].toLowerCase()) {
                    case "teams": {
                        switch (args[1].toLowerCase()) {
                            case "create": {
                                player.sendMessage("§6§lCreate Team");
                                player.sendMessage("§e/asb teams create <name> <color>");
                                break;
                            }
                            case "remove": {
                                player.sendMessage("§6§lRemove Team");
                                player.sendMessage("§e/asb teams remove <name>");
                                break;
                            }
                            case "setspawn": {
                                if (Main.getGame().getTeamByName(args[2].toLowerCase()) == null) {
                                    player.sendMessage(Main.getPrefix() + "§cTeam not found.");
                                    return true;
                                }
                                Main.getGame().getTeamByName(args[2].toLowerCase()).setSpawn(player.getLocation());
                                Main.getGame().getTeamByName(args[2].toLowerCase()).save();
                                player.sendMessage(Main.getPrefix() + "§aSpawn set.");
                                break;
                            }
                            case "setcenter": {
                                if (Main.getGame().getTeamByName(args[2].toLowerCase()) == null) {
                                    player.sendMessage(Main.getPrefix() + "§cTeam not found.");
                                    return true;
                                }
                                Main.getGame().getTeamByName(args[2].toLowerCase()).setCenter(player.getLocation());
                                Main.getGame().getTeamByName(args[2].toLowerCase()).save();
                                player.sendMessage(Main.getPrefix() + "§aCenter set.");
                                break;
                            }
                            case "setcolor": {
                                player.sendMessage("§6§lSet Color");
                                player.sendMessage("§e/asb teams setColor <name> <color>");
                                break;
                            }

                            default: {
                                player.sendMessage(helpMessage);
                                break;
                            }
                        }
                        break;
                    }
                    case "setlobby": {
                        player.sendMessage("§6§lSet Lobby");
                        player.sendMessage("§e/asb setLobby [<x> <y> <z>]");
                        break;
                    }
                    default: {
                        player.sendMessage(helpMessage);
                        break;
                    }

                }
                break;
            }
            case 4: {
                switch (args[0].toLowerCase()) {
                    case "teams": {
                        switch (args[1].toLowerCase()) {
                            case "create": {
                                if (Main.getGame().getTeamByName(args[2].toLowerCase()) != null) {
                                    player.sendMessage(Main.getPrefix() + "§cTeam already exists.");
                                    return true;
                                }
                                if (Utils.getColor(args[3]) == null) {
                                    player.sendMessage(Main.getPrefix() + "§cInvalid color.");
                                    player.sendMessage(Main.getPrefix() + "§cValid colors: " + Utils.getAllColor());
                                    return true;
                                }
                                Team team = new Team(args[2].toLowerCase(), Main.getGame());
                                team.setColor(Utils.getColor(args[3]));
                                team.save();
                                Main.getGame().addTeam(team);

                                player.sendMessage(Main.getPrefix() + "§aTeam created.");
                                break;
                            }

                            case "remove": {
                                if (Main.getGame().getTeamByName(args[2].toLowerCase()) == null) {
                                    player.sendMessage(Main.getPrefix() + "§cTeam not found.");
                                    return true;
                                }
                                Main.getGame().removeTeam(Main.getGame().getTeamByName(args[2].toLowerCase()));
                                Main.getGame().getTeamByName(args[2].toLowerCase()).remove();
                                player.sendMessage(Main.getPrefix() + "§aTeam removed.");
                                break;
                            }
                            case "setcolor": {
                                if (Main.getGame().getTeamByName(args[2].toLowerCase()) == null) {
                                    player.sendMessage(Main.getPrefix() + "§cTeam not found.");
                                    return true;
                                }
                                if (Utils.getColor(args[3]) == null) {
                                    player.sendMessage(Main.getPrefix() + "§cInvalid color.");
                                    player.sendMessage(Main.getPrefix() + "§cValid colors: " + Utils.getAllColor());
                                    return true;
                                }
                                Main.getGame().getTeamByName(args[2].toLowerCase()).setColor(Utils.getColor(args[3]));
                                Main.getGame().getTeamByName(args[2].toLowerCase()).save();
                                player.sendMessage(Main.getPrefix() + "§aColor set to " + args[3] + ".");
                                break;
                            }
                            default: {
                                player.sendMessage(helpMessage);
                                break;
                            }
                        }
                        break;
                    }
                    case "setlobby": {
                        if (!Utils.isNumber(args[1]) || !Utils.isNumber(args[2]) || !Utils.isNumber(args[3])) {
                            player.sendMessage(Main.getPrefix() + "§cThe arguments must be numbers.");
                            break;
                        }
                        Main.getGame().setLobby(new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3])));
                        player.sendMessage(Main.getPrefix() + "§aLobby set.");
                        break;
                    }
                    default: {
                        player.sendMessage(helpMessage);
                        break;
                    }
                }
                break;
            }
            default: {
                // 502 70 -371, 499 73 -368
                player.sendMessage(helpMessage);
                break;
            }

        }
        Main.getGame().save();
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        System.out.println(args.length);
        if (args.length == 1) {
            return Arrays.asList("help", "teams", "setlobby", "setminplayers", "setmaxplayers", "setbuildtime", "setviewtime", "setroundtime", "setbaseradius");
        }
        if (args.length == 2) {
            if(args[0].equalsIgnoreCase("addadmingame")) {
                return Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
            }
            if(args[0].equalsIgnoreCase("removeadmingame")) {
                return Main.getGame().getOwners().stream().map(Player::getName).collect(Collectors.toList());
            }
            if(args[0].equalsIgnoreCase("addbuild")){
                return Arrays.asList("pos1", "pos2");
            }
            if(args[0].equalsIgnoreCase("removebuild")){
                return Main.getGame().getBuilds().stream().map(Build::getName).collect(Collectors.toList());
            }
            if(args[0].equalsIgnoreCase("teams")) {
                return Arrays.asList("create", "remove", "setcolor", "setspawn", "setcenter");
            }
            if(args[0].equalsIgnoreCase("setlobby")) {
                return Arrays.asList("<x> <y> <z>");
            }

        }
        if(args.length == 3){
            if(args[0].equalsIgnoreCase("teams")) {
                if(args[1].equalsIgnoreCase("remove")) {
                    return Main.getGame().getTeams().stream().map(Team::getName).collect(Collectors.toList());
                }
                if(args[1].equalsIgnoreCase("setcolor")) {
                    return Main.getGame().getTeams().stream().map(Team::getName).collect(Collectors.toList());
                }
                if(args[1].equalsIgnoreCase("setspawn")) {
                    return Main.getGame().getTeams().stream().map(Team::getName).collect(Collectors.toList());
                }
                if(args[1].equalsIgnoreCase("setcenter")) {
                    return Main.getGame().getTeams().stream().map(Team::getName).collect(Collectors.toList());
                }
            }
        }
        if(args.length == 4){
            if(args[0].equalsIgnoreCase("teams")) {
                if(args[1].equalsIgnoreCase("setcolor")) {
                    return Arrays.stream(Utils.getAllColor()).toList().stream().map(Enum::name).collect(Collectors.toList());
                }
            }
        }
        return null;
    }
}
