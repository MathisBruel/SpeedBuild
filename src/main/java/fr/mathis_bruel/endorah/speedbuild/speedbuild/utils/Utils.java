package fr.mathis_bruel.endorah.speedbuild.speedbuild.utils;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import net.minecraft.network.protocol.game.PacketPlayOutScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeam;
import net.minecraft.world.scores.ScoreboardTeamBase;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.BlockIterator;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Utils {

    public static Location parseStringToLoc(String string) {
        String[] parsedLoc = string.split(",");
        double x = Double.valueOf(parsedLoc[1]);
        double y = Double.valueOf(parsedLoc[2]);
        double z = Double.valueOf(parsedLoc[3]);
        String world = parsedLoc[0];
        float pitch = Float.valueOf(parsedLoc[4]);
        float yaw = Float.valueOf(parsedLoc[5]);

        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

    public static String parseLocToString(Location loc) {
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        World world = loc.getWorld();
        float pitch = loc.getPitch();
        float yaw = loc.getYaw();
        return world.getName() + ", " + x + ", " + y + ", " + z + ", " + pitch + ", " + yaw;
    }

    public static ChatColor getColor(String string) {
        switch (string) {
            case "RED":
                return ChatColor.RED;
            case "BLUE":
                return ChatColor.BLUE;
            case "GREEN":
                return ChatColor.GREEN;
            case "YELLOW":
                return ChatColor.YELLOW;
            case "WHITE":
                return ChatColor.WHITE;
            case "BLACK":
                return ChatColor.BLACK;
            case "DARK_RED":
                return ChatColor.DARK_RED;
            case "DARK_BLUE":
                return ChatColor.DARK_BLUE;
            case "DARK_GREEN":
                return ChatColor.DARK_GREEN;
            case "DARK_AQUA":
                return ChatColor.DARK_AQUA;
            case "DARK_PURPLE":
                return ChatColor.DARK_PURPLE;
            case "DARK_GRAY":
                return ChatColor.DARK_GRAY;
            case "GOLD":
                return ChatColor.GOLD;
            case "AQUA":
                return ChatColor.AQUA;
            case "LIGHT_PURPLE":
                return ChatColor.LIGHT_PURPLE;
            case "GRAY":
                return ChatColor.GRAY;
            default:
                return null;
        }
    }

    public static Color getColor2(String color) {
        switch (color) {
            case "RED":
                return Color.RED;
            case "BLUE":
                return Color.BLUE;
            case "GREEN":
                return Color.GREEN;
            case "YELLOW":
                return Color.YELLOW;
            case "WHITE":
                return Color.WHITE;
            case "BLACK":
                return Color.BLACK;
            case "DARK_RED":
                return Color.MAROON;
            case "DARK_BLUE":
                return Color.NAVY;
            case "DARK_GREEN":
                return Color.GREEN;
            case "DARK_AQUA":
                return Color.TEAL;
            case "DARK_PURPLE":
                return Color.PURPLE;
            case "DARK_GRAY":
                return Color.GRAY;
            case "GOLD":
                return Color.ORANGE;
            case "AQUA":
                return Color.AQUA;
            case "LIGHT_PURPLE":
                return Color.FUCHSIA;
            case "GRAY":
                return Color.SILVER;
            default:
                return null;
        }
    }

    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getColorName(ChatColor color) {
        switch (color) {
            case RED:
                return "Rouge";
            case BLUE:
                return "Bleu";
            case GREEN:
                return "Vert";
            case YELLOW:
                return "Jaune";
            case WHITE:
                return "Blanc";
            case BLACK:
                return "Noir";
            case DARK_RED:
                return "Rouge foncé";
            case DARK_BLUE:
                return "Bleu foncé";
            case DARK_GREEN:
                return "Vert foncé";
            case DARK_AQUA:
                return "Bleu aqua";
            case DARK_PURPLE:
                return "Violet";
            case DARK_GRAY:
                return "Gris foncé";
            case GOLD:
                return "Or";
            case AQUA:
                return "Aqua";
            case LIGHT_PURPLE:
                return "Rose";
            case GRAY:
                return "Gris";
            default:
                return null;

        }
    }

    public static String getColorNameEn(ChatColor color) {
        switch (color) {
            case RED:
                return "RED";
            case BLUE:
                return "BLUE";
            case GREEN:
                return "GREEN";
            case YELLOW:
                return "YELLOW";
            case WHITE:
                return "WHITE";
            case BLACK:
                return "BLACK";
            case DARK_RED:
                return "DARK_RED";
            case DARK_BLUE:
                return "DARK_BLUE";
            case DARK_GREEN:
                return "DARK_GREEN";
            case DARK_AQUA:
                return "DARK_AQUA";
            case DARK_PURPLE:
                return "DARK_PURPLE";
            case DARK_GRAY:
                return "DARK_GRAY";
            case GOLD:
                return "GOLD";
            case AQUA:
                return "AQUA";
            case LIGHT_PURPLE:
                return "LIGHT_PURPLE";
            case GRAY:
                return "GRAY";
            default:
                return null;

        }
    }


    public static String getColorString(ChatColor color) {
        // return § + color.getChar();
        switch (color) {
            case RED:
                return "§c";
            case BLUE:
                return "§9";
            case GREEN:
                return "§a";
            case YELLOW:
                return "§e";
            case WHITE:
                return "§f";
            case BLACK:
                return "§0";
            case DARK_RED:
                return "§4";
            case DARK_BLUE:
                return "§1";
            case DARK_GREEN:
                return "§2";
            case DARK_AQUA:
                return "§3";
            case DARK_PURPLE:
                return "§5";
            case DARK_GRAY:
                return "§8";
            case GOLD:
                return "§6";
            case AQUA:
                return "§b";
            case LIGHT_PURPLE:
                return "§d";
            case GRAY:
                return "§7";
            default:
                return null;

        }
    }

    public static ChatColor[] getAllColor() {
        return new ChatColor[]{ChatColor.RED, ChatColor.BLUE, ChatColor.GREEN, ChatColor.YELLOW, ChatColor.WHITE, ChatColor.BLACK, ChatColor.DARK_RED, ChatColor.DARK_BLUE, ChatColor.DARK_GREEN, ChatColor.DARK_AQUA, ChatColor.DARK_PURPLE, ChatColor.DARK_GRAY, ChatColor.GOLD, ChatColor.AQUA, ChatColor.LIGHT_PURPLE, ChatColor.GRAY};
    }

    public static final Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock;
    }

    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static Short getDataColor(ChatColor color) {
        switch (color.name().toUpperCase()) {
            case "RED":
                return 14;
            case "BLUE":
                return 11;
            case "GREEN":
                return 5;
            case "YELLOW":
                return 4;
            case "WHITE":
                return 0;
            case "BLACK":
                return 15;
            case "DARK_RED":
                return 1;
            case "DARK_BLUE":
                return 11;
            case "DARK_GREEN":
                return 13;
            case "DARK_AQUA":
                return 9;
            case "DARK_PURPLE":
                return 10;
            case "DARK_GRAY":
                return 8;
            case "GOLD":
                return 1;
            case "AQUA":
                return 3;
            case "LIGHT_PURPLE":
                return 2;
            case "GRAY":
                return 7;
            default:
                return null;
        }
    }

    public static DyeColor getDyeColor(ChatColor color) {
        switch (color.name().toUpperCase()) {
            case "RED":
                return DyeColor.RED;
            case "BLUE":
                return DyeColor.BLUE;
            case "GREEN":
                return DyeColor.GREEN;
            case "YELLOW":
                return DyeColor.YELLOW;
            case "WHITE":
                return DyeColor.WHITE;
            case "BLACK":
                return DyeColor.BLACK;
            case "DARK_RED":
                return DyeColor.RED;
            case "DARK_BLUE":
                return DyeColor.BLUE;
            case "DARK_GREEN":
                return DyeColor.GREEN;
            case "DARK_AQUA":
                return DyeColor.CYAN;
            case "DARK_PURPLE":
                return DyeColor.PURPLE;
            case "DARK_GRAY":
                return DyeColor.GRAY;
            case "GOLD":
                return DyeColor.ORANGE;
            case "AQUA":
                return DyeColor.CYAN;
            case "LIGHT_PURPLE":
                return DyeColor.PURPLE;
            case "GRAY":
                return DyeColor.GRAY;
            default:
                return null;
        }
    }

    public static boolean canAddItemInInventory(Player player, ItemStack item) {
        // if player has space in inventory in function of item and quantity
        if (player.getInventory().firstEmpty() != -1) {
            return true;
        }
        // if player has space in inventory in function of item
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack != null && itemStack.getType() == item.getType() && itemStack.getDurability() == item.getDurability() && itemStack.getAmount() < itemStack.getMaxStackSize()) {
                return true;
            }
        }
        return false;

    }


    public static ArrayList<Block> getBlocksBetweenPositions(Location pos1, Location pos2) {
        World world = pos1.getWorld();
        int minX = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int minY = Math.min(pos1.getBlockY(), pos2.getBlockY());
        int minZ = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
        int maxX = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int maxY = Math.max(pos1.getBlockY(), pos2.getBlockY());
        int maxZ = Math.max(pos1.getBlockZ(), pos2.getBlockZ());

        ArrayList<Block> blocksBetween = new ArrayList<>();

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Location location = new Location(world, x, y, z);
                    Block block = location.getBlock();
                    blocksBetween.add(block);
                }
            }
        }

        return blocksBetween;
    }

    public static void createFile(String path, String content) {
        File configFile = new File(Main.getInstance().getDataFolder(), path);

        // Obtenir le répertoire parent du fichier
        File parentDir = configFile.getParentFile();

        // Vérifier si le répertoire parent existe, sinon le créer
        if (!parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                Main.getInstance().getLogger().warning("Impossible de créer les répertoires parent pour " + path);
                return;
            }
        }

        if (!configFile.exists()) {
            try {
                if (configFile.createNewFile()) {
                    Main.getInstance().getLogger().info("Le fichier " + path + " a été créé avec succès.");
                } else {
                    Main.getInstance().getLogger().warning("Impossible de créer le fichier " + path);
                    return;
                }
            } catch (IOException e) {
                Main.getInstance().getLogger().warning("Erreur lors de la création du fichier " + path + ": " + e.getMessage());
                return;
            }
        }

        try (FileWriter writer = new FileWriter(configFile)) {
            writer.write(content);
        } catch (IOException e) {
            Main.getInstance().getLogger().warning("Erreur lors de l'écriture du contenu dans le fichier " + path + ": " + e.getMessage());
        }

    }

    public static String getFileContent(String path) {
        File configFile = new File(Main.getInstance().getDataFolder(), path);

        if (!configFile.exists()) {
            Main.getInstance().getLogger().warning("Le fichier " + path + " n'existe pas.");
            return null;
        }

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            Main.getInstance().getLogger().warning("Erreur lors de la lecture du fichier " + path + ": " + e.getMessage());
            return null;
        }

        return content.toString();
    }

    public static void changePlayerPrefix(Player player, fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Team t) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam(t.getName());

        if (team == null) {
            team = scoreboard.registerNewTeam(t.getName());
        }

        team.setPrefix(t.getPrefix());
        team.addEntry(player.getName());
    }

    public static void resetPlayerPrefix(Player player, fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Team t){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam(t.getName());

        if (team != null) {
            team.removeEntry(player.getName());
        }
    }

}

