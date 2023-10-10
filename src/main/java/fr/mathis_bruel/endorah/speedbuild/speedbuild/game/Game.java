package fr.mathis_bruel.endorah.speedbuild.speedbuild.game;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.Main;
import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The Game class represents a game with various properties such as name, minimum and maximum number of players, build
 * time, view time, round time, base radius, build radius, teams, players, and state.
 */
public class Game {

    private final String name;
    private int minPlayers;
    private int maxPlayers;
    private int buildTime;
    private int viewTime;
    private int roundTime;
    private int baseRadius;
    private int buildRadius;
    private final ArrayList<Team> teams;
    private final ArrayList<Player> players;
    private States state;
    private final ArrayList<Player> owners;
    private Location lobby;
    private Location center;
    private boolean enable;
    private final ArrayList<Build> builds;
    private Runnable runnable;
    private int count;


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
        enable = false;
        builds = new ArrayList<>();
        owners = new ArrayList<>();
        count = 10;
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
        enable = false;
        builds = new ArrayList<>();
        owners = new ArrayList<>();
        count = 10;
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
     *               passed as an argument when calling the addPlayer method.
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

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * The getMaxPlayers() function returns the maximum number of players.
     *
     * @return The method is returning the value of the variable "maxPlayers".
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * The function returns the build time.
     *
     * @return The method is returning the value of the variable "buildTime".
     */
    public int getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * The getViewTime() function returns the value of the viewTime variable.
     *
     * @return The method is returning the value of the variable "viewTime".
     */
    public int getViewTime() {
        return viewTime;
    }

    public void setViewTime(int viewTime) {
        this.viewTime = viewTime;
    }

    /**
     * The function returns the value of the roundTime variable.
     *
     * @return The method is returning the value of the variable roundTime.
     */
    public int getRoundTime() {
        return roundTime;
    }

    public void setRoundTime(int roundTime) {
        this.roundTime = roundTime;
    }

    /**
     * The function returns the value of the base radius.
     *
     * @return The method is returning the value of the variable "baseRadius".
     */
    public int getBaseRadius() {
        return baseRadius;
    }

    public void setBaseRadius(int baseRadius) {
        this.baseRadius = baseRadius;
    }

    /**
     * The function returns the build radius.
     *
     * @return The method is returning the value of the variable "buildRadius".
     */
    public int getBuildRadius() {
        return buildRadius;
    }

    public void setBuildRadius(int buildRadius) {
        this.buildRadius = buildRadius;
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

    /**
     * The function returns an ArrayList of Player objects.
     *
     * @return An ArrayList of Player objects.
     */
    public ArrayList<Player> getOwners() {
        return owners;
    }

    /**
     * The function adds a player to a list of owners.
     *
     * @param player The "player" parameter is of type "Player" and represents the player that you want to add to the list
     *               of owners.
     */
    public void addOwner(Player player) {
        owners.add(player);
    }

    /**
     * The function removes a player from a list of owners.
     *
     * @param player The "player" parameter is of type Player and represents the player that you want to remove from the
     *               list of owners.
     */
    public void removeOwner(Player player) {
        owners.remove(player);
    }

    /**
     * The function returns the lobby location.
     *
     * @return The method is returning an object of type Location.
     */
    public Location getLobby() {
        return lobby;
    }

    /**
     * The function sets the lobby location.
     *
     * @param lobby The "lobby" parameter is of type Location and represents the location you want to set as the lobby.
     */
    public void setLobby(Location lobby) {
        this.lobby = lobby;
    }

    /**
     * The function returns the center location.
     *
     * @return The method is returning an object of type Location.
     */
    public Location getCenter() {
        return center;
    }

    /**
     * The function sets the center location.
     *
     * @param center The "center" parameter is of type Location and represents the location you want to set as the center.
     */
    public void setCenter(Location center) {
        this.center = center;
    }

    /**
     * The function returns the value of the enable variable.
     *
     * @return The method is returning the value of the variable "enable".
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * The function sets the "enable" variable to true.
     */
    public void setEnable() {
        this.enable = true;
    }

    /**
     * The function sets the "enable" variable to false.
     */
    public void setDisable() {
        this.enable = false;
    }

    /**
     * The function adds a Build object to a list of builds.
     *
     * @param build The parameter "build" is an object of type "Build".
     */
    public void addBuild(Build build) {
        builds.add(build);
    }

    /**
     * The function removes a specified build from a list.
     *
     * @param build The parameter "build" is a string that represents the build to be removed from the list of builds.
     */
    public void removeBuild(String build) {
        builds.remove(build);
    }

    /**
     * The function returns an ArrayList of Build objects.
     *
     * @return An ArrayList of Build objects.
     */
    public ArrayList<Build> getBuilds() {
        return builds;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    public Team getTeamByPlayer(Player player){
        for(Team team : teams){
            if(team.getPlayer() == player){
                return team;
            }
        }
        return null;
    }

    public Build getBuildByName(String name) {
        for (Build build : builds) {
            if (build.getName().equalsIgnoreCase(name)) {
                return build;
            }
        }
        return null;
    }
    public void joinPlayer(Player player) {
        players.add(player);
        player.teleport(lobby);
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setExp(0);
        player.setLevel(0);
        player.setFireTicks(0);
        player.setFlying(false);
        player.setAllowFlight(false);
        // add in team with less players
        Team team = getTeamWithLessPlayer();
        if (team != null) {
            team.setPlayer(player);
        }
        player.setPlayerListName(team.getPrefix() + player.getName());
        player.setDisplayName(team.getPrefix() + player.getName());
        player.setCustomName(team.getPrefix() + player.getName());
        player.setCustomNameVisible(true);
    }

    public void leavePlayer(Player player) {
        players.remove(player);
        if(player.isOnline()) {
            player.teleport(lobby);
            player.setPlayerListName(player.getName());
            player.setDisplayName(player.getName());
        }
        Team team = getTeamByPlayer(player);
        if (team != null) {
            team.setPlayer(null);
        }

    }

    public Team getTeamWithLessPlayer() {
        // 1 player per team
        for (Team team : teams) {
            if (team.getPlayer() == null) {
                return team;
            }
        }
        return null;
    }

    public void start(){
        for (Team team : teams) {
            team.getPlayer().sendMessage("§aThe game has started!");
            team.getPlayer().sendTitle("§aThe game has started!", "§7Good luck!");
            team.getPlayer().teleport(team.getSpawn());
        }

    }


    /**
     * The function saves game configuration values into a config file.
     */
    public void save() {
        // save into config
        Main.getInstance().getConfig().set("games." + name + ".minPlayers", minPlayers);
        Main.getInstance().getConfig().set("games." + name + ".maxPlayers", maxPlayers);
        Main.getInstance().getConfig().set("games." + name + ".buildTime", buildTime);
        Main.getInstance().getConfig().set("games." + name + ".viewTime", viewTime);
        Main.getInstance().getConfig().set("games." + name + ".roundTime", roundTime);
        Main.getInstance().getConfig().set("games." + name + ".baseRadius", baseRadius);
        Main.getInstance().getConfig().set("games." + name + ".buildRadius", buildRadius);
        if (lobby != null) {
            Main.getInstance().getConfig().set("games." + name + ".lobby", Utils.parseLocToString(lobby));
        }
        if (center != null) {
            Main.getInstance().getConfig().set("games." + name + ".center", Utils.parseLocToString(center));
        }
        Main.getInstance().getConfig().set("games." + name + ".enable", enable);
        /*ArrayList<String> uuids = new ArrayList<>();
        for (Player player : owners) {
            uuids.add(player.getUniqueId().toString());
        }
        Main.getInstance().getConfig().set("games." + name + ".owners", uuids);*/
        this.getTeams().forEach(Team::save);
        ArrayList<String> buildNames = new ArrayList<>();
        for (Build build : builds) {
            buildNames.add(build.getName());
        }
        Main.getInstance().getConfig().set("games." + name + ".builds", buildNames);
        Main.getInstance().saveConfig();

    }

    /**
     * The function loads game configuration values from a config file.
     */
    public void load() {
        // load from config
        if (Main.getInstance().getConfig().contains("games." + name + ".minPlayers")) {
            minPlayers = Main.getInstance().getConfig().getInt("games." + name + ".minPlayers");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".maxPlayers")) {
            maxPlayers = Main.getInstance().getConfig().getInt("games." + name + ".maxPlayers");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".buildTime")) {
            buildTime = Main.getInstance().getConfig().getInt("games." + name + ".buildTime");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".viewTime")) {
            viewTime = Main.getInstance().getConfig().getInt("games." + name + ".viewTime");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".roundTime")) {
            roundTime = Main.getInstance().getConfig().getInt("games." + name + ".roundTime");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".baseRadius")) {
            baseRadius = Main.getInstance().getConfig().getInt("games." + name + ".baseRadius");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".buildRadius")) {
            buildRadius = Main.getInstance().getConfig().getInt("games." + name + ".buildRadius");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".lobby")) {
            lobby = Utils.parseStringToLoc(Main.getInstance().getConfig().getString("games." + name + ".lobby"));
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".center")) {
            center = Utils.parseStringToLoc(Main.getInstance().getConfig().getString("games." + name + ".center"));
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".enable")) {
            enable = Main.getInstance().getConfig().getBoolean("games." + name + ".enable");
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".owners")) {
            ArrayList<String> uuids = (ArrayList<String>) Main.getInstance().getConfig().getStringList("games." + name + ".owners");
            for (String uuid : uuids) {
                owners.add(Bukkit.getPlayer(UUID.fromString(uuid)));
            }
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".teams")) {
            ConfigurationSection teamNames = Main.getInstance().getConfig().getConfigurationSection("games." + name + ".teams");

            for (String teamName : teamNames.getKeys(false)) {
                Team team = new Team(teamName, this);
                team.load();
                teams.add(team);
            }
        }
        if (Main.getInstance().getConfig().contains("games." + name + ".builds")) {
            ArrayList<String> buildNames = (ArrayList<String>) Main.getInstance().getConfig().getStringList("games." + name + ".builds");
            for (String buildName : buildNames) {
                Build build = new Build(buildName);
                build.init();
                this.addBuild(build);
            }
        }

        this.runnable = new Runnable();
        runnable.runTaskTimer(Main.getInstance(), 0, 20);


    }


}
