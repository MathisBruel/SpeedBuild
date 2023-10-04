package fr.mathis_bruel.endorah.speedbuild.speedbuild.manager;

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
    private Color color;
    private Location spawn;
    private Location center;
    private int score;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        color = Color.WHITE;
        score = 0;
    }

    public Team(String name, Color color, Location spawn, Location center) {
        this.name = name;
        this.color = color;
        this.spawn = spawn;
        this.center = center;
        score = 0;
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
     * @return The method is returning a Color object.
     */
    public Color getColor() {
        return color;
    }

    /**
     * The function sets the color of an object.
     *
     * @param color The "color" parameter is of type "Color".
     */
    public void setColor(Color color) {
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




}
