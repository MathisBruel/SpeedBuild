package fr.mathis_bruel.endorah.speedbuild.speedbuild.utils;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DecimalChrono extends BukkitRunnable {
    private int totalMilliseconds;
    private boolean running;

    private Player player;


    public DecimalChrono() {
        this.totalMilliseconds = 0;
        this.running = false;
    }

    public void start() {
        if (!running) {
            this.runTaskTimer(Main.getInstance(), 0, 1); // Remplacez YourPlugin par le nom de votre plugin
            running = true;
        }
    }

    public void stop() {
        if (running) {
            this.cancel();
            running = false;
        }
    }

    public void reset() {
        totalMilliseconds = 0;
    }

    @Override
    public void run() {
        if (running) {
            totalMilliseconds++;
            if (player != null) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Time: §f" + getTime()));
            }
        }
    }

    public String getTime() {
        int seconds = totalMilliseconds / 1000;
        int milliseconds = totalMilliseconds % 1000;
        // Format the time as "ss.mmm"
        return String.format("%02d.%03d", seconds, milliseconds);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
