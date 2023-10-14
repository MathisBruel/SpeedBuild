package fr.mathis_bruel.endorah.speedbuild.speedbuild.game;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.Utils;
import net.minecraft.world.level.block.DoubleBlockFinder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Build {
    private String name;
    private Location pos1;
    private Location pos2;
    private Game game;
    private String build;
    private HashMap<Location, Material> blocks;
    private int buildTime;

    public Build(String name, Location pos1, Location pos2, int buildTime, Game game) {
        this.name = name;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.game = game;
        this.build = "";
        this.blocks = new HashMap<>();
        this.buildTime = buildTime;
    }

    public Build(String name) {
        this.name = name;
        this.pos1 = null;
        this.pos2 = null;
        this.game = null;
        this.build = "";
        this.blocks = new HashMap<>();
        this.buildTime = 5;
    }

    public String getName() {
        return name;
    }

    public Location getPos1() {
        return pos1;
    }

    public Location getPos2() {
        return pos2;
    }

    public Game getGame() {
        return game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPos1(Location pos1) {
        this.pos1 = pos1;
    }

    public void setPos2(Location pos2) {
        this.pos2 = pos2;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getBuild() {
        return build;
    }

    public HashMap<Location, Material> getBlocks() {
        return blocks;
    }

    public void setBlocks(HashMap<Location, Material> blocks) {
        this.blocks = blocks;
    }

    public void addBlock(Block block) {
        blocks.put(block.getLocation(), block.getType());
    }

    public void removeBlock(Block block) {
        blocks.remove(block.getLocation());
    }

    public void removeBlock(Location location) {
        blocks.remove(location);
    }

    public int getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }



    public void save() {
        //get all blocks into pos1 and pos2
        ArrayList<Block> blocks = Utils.getBlocksBetweenPositions(pos1, pos2);
        // parse blocks to string
        build = Utils.parseLocToString(pos1) + ";" + Utils.parseLocToString(pos2) + ";" + buildTime + ";";
        for (Block block : blocks) {
            build += block.getLocation().getBlockX() + "," + block.getLocation().getBlockY() + "," + block.getLocation().getBlockZ() + "," + block.getType().name() + ";";
        }

        // remove the last character ";" of build
        build = build.substring(0, build.length() - 1);

        // create file in builds folder content = build
        Utils.createFile("builds/" + name + ".txt", build);

        String[] buildData = build.split(";");
        pos1 = Utils.parseStringToLoc(buildData[0]);
        pos2 = Utils.parseStringToLoc(buildData[1]);
        buildTime = Integer.parseInt(buildData[2]);
        build = build.replace(buildData[0] + ";", "");
        build = build.replace(buildData[1] + ";", "");
        build = build.replace(buildData[2] + ";", "");
        System.out.println(build);
        parseStringToBlocks();
        System.out.println("Build " + name + " initialized");
    }


    public void init() {
        // get file content
        build = Utils.getFileContent("builds/" + name + ".txt");
        build.split(";");
        // the first argument is the pos1, the second is the pos2, the third is the build time
        // set pos1, pos2 and build time and remove them from the build string
        String[] buildData = build.split(";");
        pos1 = Utils.parseStringToLoc(buildData[0]);
        pos2 = Utils.parseStringToLoc(buildData[1]);
        buildTime = Integer.parseInt(buildData[2]);
        build = build.replace(buildData[0] + ";", "");
        build = build.replace(buildData[1] + ";", "");
        build = build.replace(buildData[2] + ";", "");


        // parse string to blocks
        parseStringToBlocks();
    }

    public ArrayList<Block> spawn(Location location) {
        ArrayList<Block> blocks2 = new ArrayList<>();
        int centerX = (pos1.getBlockX() + pos2.getBlockX()) / 2; // Calcul du centre X
        int centerZ = (pos1.getBlockZ() + pos2.getBlockZ()) / 2; // Calcul du centre Z
        int centerY = (pos1.getBlockY() + pos2.getBlockY()) / 2; // Calcul du centre Y

        blocks.forEach((loc, mat) -> {
            int newX = location.getBlockX() + loc.getBlockX() - centerX;
            int newY = location.getBlockY() + loc.getBlockY() - centerY;
            int newZ = location.getBlockZ() + loc.getBlockZ() - centerZ;

            Location loc2 = new Location(location.getWorld(), newX, newY, newZ);

            Block b = loc2.getBlock();
            b.setType(mat);
            blocks2.add(b);
        });
        return blocks2;
    }

    public ArrayList<ArrayList<Block>> spawn(Game game){
        ArrayList<ArrayList<Block>> blocks2 = new ArrayList<>();
        game.getTeams().forEach(team -> {
            if(team.getStatus() == Status.PARTICIPATING) blocks2.add(spawn(team.getCenter()));
        });
        return blocks2;
    }


    private void parseStringToBlocks() {
        for (String block : build.split(";")) {
            String[] blockData = block.split(",");
            if (Material.getMaterial(blockData[3]) == null) return;
            Location location = new Location(Bukkit.getWorld("world"), Integer.parseInt(blockData[0]), Integer.parseInt(blockData[1]), Integer.parseInt(blockData[2]));

            this.blocks.put(location, Material.getMaterial(blockData[3]));
        }
    }

}
