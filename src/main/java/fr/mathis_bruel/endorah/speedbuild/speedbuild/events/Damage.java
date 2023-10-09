package fr.mathis_bruel.endorah.speedbuild.speedbuild.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements org.bukkit.event.Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChange(org.bukkit.event.entity.FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

}
