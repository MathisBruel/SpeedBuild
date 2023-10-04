package fr.mathis_bruel.endorah.speedbuild.speedbuild.manager;

import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * The Game class represents a game with various properties such as name, minimum and maximum number of players, build
 * time, view time, round time, base radius, build radius, teams, players, and state.
 */
public class Game {

    private String name;
    private int minPlayers;
    private int maxPlayers;
    private int buildTime;
    private int viewTime;
    private int roundTime;
    private int baseRadius;
    private int buildRadius;
    private ArrayList<Team> teams;
    private ArrayList<Player> players;
    private States state;

    public Game(String name, int minPlayers, int maxPlayers, int buildTime, int viewTime, int roundTime, int baseRadius, int buildRadius) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.buildTime = buildTime;
        this.viewTime = viewTime;
        this.roundTime = roundTime;
        this.baseRadius = baseRadius;
        this.buildRadius = buildRadius;
        this.teams = new ArrayList<>();
        this.players = new ArrayList<>();
        this.state = States.WAITING;
    }

    public Game(String name) {
        this.name = name;
        this.minPlayers = 2;
        this.maxPlayers = 8;
        this.buildTime = 300;
        this.viewTime = 30;
        this.roundTime = 3;
        this.baseRadius = 10;
        this.buildRadius = 5;
        this.teams = new ArrayList<>();
        this.players = new ArrayList<>();
        this.state = States.WAITING;
    }

    /**
     * The addTeam function adds a team to a list of teams.
     *
     * @param team The "team" parameter is an object of the Team class.
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /**
     * The function removes a team from a list of teams.
     *
     * @param team The "team" parameter is an object of the Team class that represents the team to be removed.
     */
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    /**
     * The addPlayer function adds a player to a list of players.
     *
     * @param player The parameter "player" is of type Player, which means it expects an object of the Player class to be
     * passed as an argument when calling the addPlayer method.
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * The function removes a player from a list of players.
     *
     * @param player The parameter "player" is of type Player, which represents a player object.
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * The function sets the state of an object to a specified value.
     *
     * @param state The "state" parameter is of type "States".
     */
    public void setState(States state) {
        this.state = state;
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
     * The function returns the minimum number of players required.
     *
     * @return The method is returning the value of the variable "minPlayers".
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * The getMaxPlayers() function returns the maximum number of players.
     *
     * @return The method is returning the value of the variable "maxPlayers".
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * The function returns the build time.
     *
     * @return The method is returning the value of the variable "buildTime".
     */
    public int getBuildTime() {
        return buildTime;
    }

    /**
     * The getViewTime() function returns the value of the viewTime variable.
     *
     * @return The method is returning the value of the variable "viewTime".
     */
    public int getViewTime() {
        return viewTime;
    }

    /**
     * The function returns the value of the roundTime variable.
     *
     * @return The method is returning the value of the variable roundTime.
     */
    public int getRoundTime() {
        return roundTime;
    }

    /**
     * The function returns the value of the base radius.
     *
     * @return The method is returning the value of the variable "baseRadius".
     */
    public int getBaseRadius() {
        return baseRadius;
    }

    /**
     * The function returns the build radius.
     *
     * @return The method is returning the value of the variable "buildRadius".
     */
    public int getBuildRadius() {
        return buildRadius;
    }

    /**
     * The function returns an ArrayList of Team objects.
     *
     * @return An ArrayList of Team objects.
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * The function returns an ArrayList of Player objects.
     *
     * @return An ArrayList of Player objects.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * The function returns the state object.
     *
     * @return The method is returning an object of type States.
     */
    public States getState() {
        return state;
    }




}
