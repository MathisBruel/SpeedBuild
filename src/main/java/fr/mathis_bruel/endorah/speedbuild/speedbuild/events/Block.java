package fr.mathis_bruel.endorah.speedbuild.speedbuild.events;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Game;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.States;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Block implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Game game = Main.getGame();
        if(!game.getPlayers().contains(event.getPlayer())) return;
        if(game.getState() != States.WAITING && game.getState() != States.STARTING){
            Team team = game.getTeamByPlayer(event.getPlayer());
            if(team != null) if(!team.isBlockPlaced(event.getBlock())) event.setCancelled(true);
        }else {
            if (game.getState() == States.VIEWBUILD) {
                Team team = game.getTeamByPlayer(event.getPlayer());
                if (team != null) event.setCancelled(true);

            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Game game = Main.getGame();
        if(!game.getPlayers().contains(event.getPlayer())) return;
        if(game.getState() != States.WAITING && game.getState() != States.STARTING){
            Team team = game.getTeamByPlayer(event.getPlayer());
            if(team != null){
                if(team.getCenter().distance(event.getBlock().getLocation()) > game.getBuildRadius()){
                    event.setCancelled(true);
                }else{
                    team.addBlockPlaced(event.getBlock());
                }
            }
        }else {
            if (game.getState() == States.VIEWBUILD) {
                Team team = game.getTeamByPlayer(event.getPlayer());
                if (team != null) event.setCancelled(true);

            }
        }
    }

}
