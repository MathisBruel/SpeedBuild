package fr.mathis_bruel.endorah.speedbuild.speedbuild.events;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Game;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.States;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Team;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements org.bukkit.event.Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onMove(PlayerMoveEvent event){
        Game game = Main.getGame();
        if(!game.getPlayers().contains(event.getPlayer())) return;
        if(game.getState() != States.WAITING && game.getState() != States.STARTING){
            Team team = game.getTeamByPlayer(event.getPlayer());
            if(team != null){
                if(team.getCenter().distance(event.getTo()) > game.getBaseRadius()){
                    Location loc = event.getFrom();
                    // modifier loc pour qu'elle soit a 1 block plus proche du centre
                    loc.setX(loc.getX() + (event.getTo().getX() > team.getCenter().getX() ? -1 : 1));
                    loc.setZ(loc.getZ() + (event.getTo().getZ() > team.getCenter().getZ() ? -1 : 1));

                    event.getPlayer().teleport(loc);
                    event.setCancelled(true);
                }
            }
        }
    }

}
