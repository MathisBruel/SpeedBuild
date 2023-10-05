package fr.mathis_bruel.endorah.speedbuild.speedbuild;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.commands.AdminSpeedBuild;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.commands.SpeedBuild;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.Game;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private static String PREFIX = "§7[§bSpeedBuild§7] ";
    private static Game game;

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§6-------------------------------------");
        Bukkit.getServer().getConsoleSender().sendMessage("§b  /$$$$$$                                      /$$ /$$$$$$$            /$$ /$$       /$$§r\n" +
                "§b /$$__  $$                                    | $$| $$__  $$          |__/| $$      | $$§r\n" +
                "§b| $$  \\__/  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$$| $$  \\ $$ /$$   /$$ /$$| $$  /$$$$$$$§r\n" +
                "§b|  $$$$$$  /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$| $$$$$$$ | $$  | $$| $$| $$ /$$__  $$§r\n" +
                "§b \\____  $$| $$  \\ $$| $$$$$$$$| $$$$$$$$| $$  | $$| $$__  $$| $$  | $$| $$| $$| $$  | $$§r\n" +
                "§b /$$  \\ $$| $$  | $$| $$_____/| $$_____/| $$  | $$| $$  \\ $$| $$  | $$| $$| $$| $$  | $$§r\n" +
                "§b|  $$$$$$/| $$$$$$$/|  $$$$$$$|  $$$$$$$|  $$$$$$$| $$$$$$$/|  $$$$$$/| $$| $$|  $$$$$$$§r\n" +
                "§b \\______/ | $$____/  \\_______/ \\_______/ \\_______/|_______/  \\______/ |__/|__/ \\_______/§r\n" +
                "§b          | $$                                                                          §r\n" +
                "§b          | $$                                                                          §r\n" +
                "§b          |__/                                                                          §r");
        Bukkit.getServer().getConsoleSender().sendMessage("§6-------------------------------------");
        Bukkit.getServer().getConsoleSender().sendMessage("§6| §bSpeedBuild §6- §7Plugin enabled");
        Bukkit.getServer().getConsoleSender().sendMessage("§6| §bSpeedBuild §6- §7Plugin by §bMathis Bruel");
        Bukkit.getServer().getConsoleSender().sendMessage("§6| §bSpeedBuild §6- §7For §bEndorah");
        Bukkit.getServer().getConsoleSender().sendMessage("§6-------------------------------------");
        instance = this;
        saveDefaultConfig();
        getCommand("speedbuild").setExecutor(new SpeedBuild());
        getCommand("adminspeedbuild").setExecutor(new AdminSpeedBuild());
        game = new Game("SpeedBuild");
        game.load();


    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§6-------------------------------------");
        Bukkit.getServer().getConsoleSender().sendMessage("§4  /$$$$$$                                      /$$ /$$$$$$$            /$$ /$$       /$$§r\n" +
                "§4 /$$__  $$                                    | $$| $$__  $$          |__/| $$      | $$§r\n" +
                "§4| $$  \\__/  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$$| $$  \\ $$ /$$   /$$ /$$| $$  /$$$$$$$§r\n" +
                "§4|  $$$$$$  /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$| $$$$$$$ | $$  | $$| $$| $$ /$$__  $$§r\n" +
                "§4 \\____  $$| $$  \\ $$| $$$$$$$$| $$$$$$$$| $$  | $$| $$__  $$| $$  | $$| $$| $$| $$  | $$§r\n" +
                "§4 /$$  \\ $$| $$  | $$| $$_____/| $$_____/| $$  | $$| $$  \\ $$| $$  | $$| $$| $$| $$  | $$§r\n" +
                "§4|  $$$$$$/| $$$$$$$/|  $$$$$$$|  $$$$$$$|  $$$$$$$| $$$$$$$/|  $$$$$$/| $$| $$|  $$$$$$$§r\n" +
                "§4 \\______/ | $$____/  \\_______/ \\_______/ \\_______/|_______/  \\______/ |__/|__/ \\_______/§r\n" +
                "§4          | $$                                                                          §r\n" +
                "§4          | $$                                                                          §r\n" +
                "§4          |__/                                                                          §r");
        Bukkit.getServer().getConsoleSender().sendMessage("§6-------------------------------------");
        Bukkit.getServer().getConsoleSender().sendMessage("§6| §bSpeedBuild §6- §7Plugin disabled");
        Bukkit.getServer().getConsoleSender().sendMessage("§6| §bSpeedBuild §6- §7Plugin by §bMathis Bruel");
        Bukkit.getServer().getConsoleSender().sendMessage("§6| §bSpeedBuild §6- §7For §bEndorah");
        Bukkit.getServer().getConsoleSender().sendMessage("§6-------------------------------------");

    }

    public static Main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public static Game getGame() {
        return game;
    }
}
