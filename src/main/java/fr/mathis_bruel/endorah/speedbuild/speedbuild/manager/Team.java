package fr.mathis_bruel.endorah.speedbuild.speedbuild.manager;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * The Team class represents a team in a game, with properties such as name, color, spawn location, center location, and
 * score.
 */
public class Team {

    private String name;
    private ChatColor color;
    private Location spawn;
    private Location center;
    private int score;
    private Player player;
    private Game game;

    public Team(String name, Game game) {
        this.name = name;
        color = ChatColor.WHITE;
        score = 0;
        this.game = game;
    }

    public Team(String name, Game game, ChatColor color, Location spawn, Location center) {
        this.name = name;
        this.color = color;
        this.spawn = spawn;
        this.center = center;
        score = 0;
        this.game = game;
    }

    /**
     * The getName() function returns the name of an object.
     *
     * @return The method is returning the value of the variable "name".
     */
    public String getName() {
        return name;
    }

    /**
     * The function sets the name of an object.
     *
     * @param name The parameter "name" is a String type parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getColor() function returns the color of an object.
     *
     * @return The method is returning a ChatColor object.
     */
    public ChatColor getColor() {
        return color;
    }

    /**
     * The function sets the color of an object.
     *
     * @param color The "color" parameter is of type "ChatColor".
     */
    public void setColor(ChatColor color) {
        this.color = color;
    }

    /**
     * The function returns the spawn location.
     *
     * @return The method is returning a Location object.
     */
    public Location getSpawn() {
        return spawn;
    }

    /**
     * The function sets the spawn location for an object.
     *
     * @param spawn The "spawn" parameter is of type "Location". It is used to set the spawn location for something, such
     * as a player or an entity, in a game or application.
     */
    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    /**
     * The function returns the center location.
     *
     * @return The method is returning a Location object.
     */
    public Location getCenter() {
        return center;
    }

    /**
     * The function sets the center location of an object.
     *
     * @param center The "center" parameter is of type "Location".
     */
    public void setCenter(Location center) {
        this.center = center;
    }

    /**
     * The function returns the value of the score variable.
     *
     * @return The method is returning the value of the variable "score".
     */
    public int getScore() {
        return score;
    }

    /**
     * The function sets the value of the score variable.
     *
     * @param score The "score" parameter is an integer value that represents the score to be set.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * The function returns the player.
     *
     * @return The method is returning a Player object.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * The function sets the player.
     *
     * @param player The "player" parameter is of type "Player".
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * The function returns the game.
     *
     * @return The method is returning a Game object.
     */
    public Game getGame() {
        return game;
    }

    /**
     * The function sets the game.
     *
     * @param game The "game" parameter is of type "Game".
     */
    public void setGame(Game game) {
        this.game = game;
    }

    public void save() {
        //save into config
        if(!Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".color")) {
            Main.getInstance().getConfig().set("games." + game.getName() + ".teams."+name + ".color", Utils.getColorNameEn(color));
        }
        if(!Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".spawn")) {
            Main.getInstance().getConfig().set("games." + game.getName() + ".teams."+name + ".spawn", Utils.parseLocToString(spawn));
        }
        if(!Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".center")) {
            Main.getInstance().getConfig().set("games." + game.getName() + ".teams."+name + ".center", Utils.parseLocToString(center));
        }
        if(!Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".score")) {
            Main.getInstance().getConfig().set("games." + game.getName() + ".teams."+name + ".score", score);
        }
    }

    public void load(){
        //load from config
        if(Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".color")) {
            color = Utils.getColor(Main.getInstance().getConfig().getString("games." + game.getName() + ".teams."+name + ".color"));
        }
        if(Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".spawn")) {
            spawn = Utils.parseStringToLoc(Main.getInstance().getConfig().getString("games." + game.getName() + ".teams."+name + ".spawn"));
        }
        if(Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".center")) {
            center = Utils.parseStringToLoc(Main.getInstance().getConfig().getString("games." + game.getName() + ".teams."+name + ".center"));
        }
        if(Main.getInstance().getConfig().contains("games." + game.getName() + ".teams."+name + ".score")) {
            score = Main.getInstance().getConfig().getInt("games." + game.getName() + ".teams."+name + ".score");
        }
    }

    public void remove(){
        Main.getInstance().getConfig().set("games." + game.getName() + ".teams."+name, null);
    }




}
