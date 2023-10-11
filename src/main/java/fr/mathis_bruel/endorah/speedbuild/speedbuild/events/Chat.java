package fr.mathis_bruel.endorah.speedbuild.speedbuild.events;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements org.bukkit.event.Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Team team = Main.getGame().getTeamByPlayer(event.getPlayer());
        if(team != null) event.setFormat(team.getPrefix() + event.getPlayer().getName() + "§f: " + event.getMessage());
    }

}
