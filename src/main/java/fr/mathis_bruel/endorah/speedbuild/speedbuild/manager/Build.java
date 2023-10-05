package fr.mathis_bruel.endorah.speedbuild.speedbuild.manager;

import fr.mathis_bruel.endorah.speedbuild.speedbuild.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;

public class Build {
    private String name;
    private Location pos1;
    private Location pos2;
    private Game game;
    private String build;
    private ArrayList<Block> blocks;

    public Build(String name, Location pos1, Location pos2, Game game) {
        this.name = name;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.game = game;
        this.build = "";
        this.blocks = new ArrayList<>();
    }

    public Build(String name) {
        this.name = name;
        this.pos1 = null;
        this.pos2 = null;
        this.game = null;
        this.build = "";
        this.blocks = new ArrayList<>();
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

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void removeBlock(Block block) {
        blocks.remove(block);
    }

    public void save() {
        //get all blocks into pos1 and pos2
        ArrayList<Block> blocks = Utils.getBlocksBetweenPositions(pos1, pos2);
        // parse blocks to string
        build = "";
        for (Block block : blocks) {
            build += block.getLocation().getBlockX() + "," + block.getLocation().getBlockY() + "," + block.getLocation().getBlockZ() + "," + block.getType().name() + ";";
        }

        // create file in builds folder content = build
        Utils.createFile("builds/" + name + ".txt", build);

        parseStringToBlocks(blocks);
        System.out.println("Build " + name + " initialized");
    }


    public void init() {
        // get file content
        build = Utils.getFileContent("builds/" + name + ".txt");
        build.split(";");
        // parse string to blocks
        parseStringToBlocks(blocks);
    }

    public void spawn(Location location) {
        // set blocks from location (pos1 = location)
        System.out.println(blocks.size());
        for (Block block : blocks) {
            Location loc = new Location(location.getWorld(), location.getBlockX() + block.getLocation().getBlockX() - pos2.getBlockX(), location.getBlockY() + block.getLocation().getBlockY() - pos2.getBlockY(), location.getBlockZ() + block.getLocation().getBlockZ() - pos2.getBlockZ());
            System.out.println(loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ());
            Block b = loc.getBlock();
            b.setType(block.getType());
        }
    }


    private void parseStringToBlocks(ArrayList<Block> blocks) {
        for (String block : build.split(";")) {
            String[] blockData = block.split(",");
            Location location = new Location(Bukkit.getWorld("world"), Integer.parseInt(blockData[0]), Integer.parseInt(blockData[1]), Integer.parseInt(blockData[2]));
            Block b = location.getBlock();
            b.setType(Material.getMaterial(blockData[3]));
            this.blocks.add(b);
        }
    }

}
