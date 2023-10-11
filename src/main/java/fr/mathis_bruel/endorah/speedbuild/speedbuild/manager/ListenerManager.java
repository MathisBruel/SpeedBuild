package fr.mathis_bruel.endorah.speedbuild.speedbuild.manager;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.events.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class ListenerManager {

    private List<Listener> listeners = new ArrayList();

    Main main;

    public ListenerManager(Main main) { this.main = main;}

    public void registerListener() {

        // Register all listeners here
        this.listeners.add(new Click());
        this.listeners.add(new Join());
        this.listeners.add(new Damage());
        this.listeners.add(new Leave());
        this.listeners.add(new Block());
        this.listeners.add(new Chat());
        this.listeners.add(new Move());



        this.listeners.forEach(listener -> {
            Bukkit.getPluginManager().registerEvents(listener, main);
        });
    }


}