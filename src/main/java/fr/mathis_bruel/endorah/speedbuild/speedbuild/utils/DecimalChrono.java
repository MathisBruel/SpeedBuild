package fr.mathis_bruel.endorah.speedbuild.speedbuild.utils;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class DecimalChrono extends BukkitRunnable {
    private int seconds;
    private int milliseconds;
    private boolean running;

    public DecimalChrono() {
        this.seconds = 0;
        this.milliseconds = 0;
        this.running = false;
    }

    public void start() {
        if (!running) {
            this.runTaskTimer(Main.getInstance(), 0, 1); 
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
        seconds = 0;
        milliseconds = 0;
    }

    @Override
    public void run() {
        if (running) {
            milliseconds++;
            if (milliseconds == 1000) {
                seconds++;
                milliseconds = 0;
            }
        }
    }

    public String getTime() {
        // Format the time as "ss.sss"
        return String.format("%02d.%03d", seconds, milliseconds);
    }
}
