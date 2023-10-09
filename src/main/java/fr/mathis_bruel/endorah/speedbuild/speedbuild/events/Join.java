package fr.mathis_bruel.endorah.speedbuild.speedbuild.events;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.manager.scoreboard.FastBoard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements org.bukkit.event.Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        FastBoard board = new FastBoard(event.getPlayer());
        Main.addBoard(event.getPlayer().getUniqueId(), board);

    }

}
