package fr.mathis_bruel.endorah.speedbuild.speedbuild.events;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements org.bukkit.event.Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Main.getGame().leavePlayer(event.getPlayer());
    }

}
