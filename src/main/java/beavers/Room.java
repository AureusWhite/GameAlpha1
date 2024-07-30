package jackal.face;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private HashMap<String, Room> exits;
    private String name;
    private ArrayList<Item> inventory;
    private ArrayList<NPC> npcs;
    private NPC npc;
    private String optional;
    private String description;

    public Room(String name, ArrayList<Item> inventory) {
        createItemFile();
        this.npcs = new ArrayList<NPC>();
        npc = new NPC("Default NPC", "Default NPC description");
        npcs.add(npc);
        this.name = name;
        exits = new HashMap<String, Room>();

    }
    private void createItemFile() {
        String fileName = this.name.replace(" ", "_") + ".txt"; // Sanitize the file name
        File file = new File(fileName);
        if (!file.exists()) {
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write("Item Name: " + this.name + "\n");
                fileWriter.write("Description: " + this.description + "\n");
                fileWriter.write("Optional: " + this.optional + "\n");
            } catch (IOException e) {
                System.out.println("Something done sploded :( " + fileName);
                e.printStackTrace();
            }
        }
    }
    public Room getExit(String roomName) {
        return exits.get(roomName);
    }

    String getName() {
        return this.name;
    }

    public Room(String name) {
        this.name = name;
        this.npcs = new ArrayList<NPC>();
        exits = new HashMap<String, Room>();
        npc = new NPC("Default NPC", "Default NPC description");
        npcs.add(npc);
    }

    public void addExit(String string, Room room) {
        exits.put(string, room);
    }

    public void removeExit(String string) {
        exits.remove(string);
    }

    public String[] getExits() {
        StringBuilder exitsString = new StringBuilder();
        for (String exit : exits.keySet()) {
            exitsString.append(exit).append(" ");
        }
        return exitsString.toString().split(" ");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExits(HashMap<String, Room> exits) {
        this.exits = exits;
    }

    public void addExits(HashMap<String, Room> exits) {
        this.exits.putAll(exits);
    }

    public void removeExits(String exitName) {
        this.exits.remove(exitName);
    }
    public void setExit(String exitName, Room room) {
        this.exits.put(exitName, room);
    }

    public String getDescription() {
        Game.readFile("Hallway.txt");   
        return "\n";

    }

    public ArrayList<Item> getInventory() {
if(this.inventory!=null) {
            return this.inventory;
        }
        ArrayList<Item> newInventory = new ArrayList<Item>();
        this.inventory = newInventory;
        return this.inventory;
    }

    public Room getExitByName(String string) {
        for (String exit : exits.keySet()) {
            if (exit.equals(string)) {
                return exits.get(exit);
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        this.getInventory().remove(item);
    }

    public void addItem(Item item) {
        this.getInventory().add(item);
    }

    public NPC getNPCByName(String npcName) {
        for (NPC npc : this.npcs) {
            if (npc.getName().equals(npcName)) {
                return npc;
            }
        }
        return npc;
    }
}