package fr.mathis_bruel.endorah.speedbuild.speedbuild.events;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.game.Build;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.CustomNBT;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class Click implements org.bukkit.event.Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getItem().getItemMeta() == null) return;
        if (event.getItem().getItemMeta().getDisplayName() == null) return;
        ItemStack item = event.getItem();
        if(!CustomNBT.contains(item)) return;
        if(CustomNBT.contains(item, "asb")){
            event.setCancelled(true);
            if(Main.getLocations().get(event.getPlayer()) == null) Main.getLocations().put(event.getPlayer(), new java.util.ArrayList<Location>(Arrays.asList(null, null)));
            // left click
            if(event.getAction() == Action.LEFT_CLICK_BLOCK){
                Main.getLocations().get(event.getPlayer()).set(0, event.getClickedBlock().getLocation());
                event.getPlayer().sendMessage(Main.getPrefix()+"§aFirst position selected.");
            }else{
                if(Main.getLocations().get(event.getPlayer()).get(0) == null) {
                    event.getPlayer().sendMessage(Main.getPrefix()+"§cYou must select the first position first.");
                    return;
                }
                // right click
                if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if(event.getPlayer().isSneaking()){
                        Build build = new Build(CustomNBT.getString(item, "name"), Main.getLocations().get(event.getPlayer()).get(0), Main.getLocations().get(event.getPlayer()).get(1),CustomNBT.getInt(item, "time"),  Main.getGame());
                        build.save();
                        Main.getGame().addBuild(build);
                        Main.getGame().save();
                        event.getPlayer().sendMessage(Main.getPrefix()+"§aBuild saved.");
                        event.getPlayer().getInventory().setItemInMainHand(null);
                        return;
                    }
                    Main.getLocations().get(event.getPlayer()).set(1, event.getClickedBlock().getLocation());
                    event.getPlayer().sendMessage(Main.getPrefix()+"§aSecond position selected.");

                }
            }
        }
    }
}
