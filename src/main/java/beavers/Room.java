package beavers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Room {
    ArrayList <NPC> npcs;
    ArrayList <Item> items;
    private String description="blargh";    
    private String name;
    private Clock clock;
    private String optional;

    public Room(String name) {
        this.name = name;
        npcs = new ArrayList <>();
        items = new ArrayList <>();
        clock = new Clock();
        createItemFile(name, description,this.optional);
        
    }
    public NPC getNPC(String name) {
            for (NPC npc : npcs) {
                if (npc.getName().equalsIgnoreCase(name)) {
                    return npc;
                }
            }
            return null;
        }

public void addNPC(NPC npc) {
    npcs.add(npc);
    System.out.println("NPC added to room.");
}

public void removeNPC(NPC npc) {
    npcs.remove(npc);
}

public String getName() {
        return name;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void listItems() {
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setNpcs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
    }

    public void describeRoom() {
        readFile(this.getName() + clock.getTimeOfDay() + ".txt");
                System.out.println("Items in the room:");
        listItems();
        System.out.println("NPCs in the room:");
        listNPCs();
    }



    public Item getItemByName(String input) {
        for (Item item : items) {
            if (item.getName().equals(input)) {
                return item;
            }
        }
        return null;
    }

    public String getInventory() {
        return this.items.toString();
    }
     
    public ArrayList<NPC> listNpcs() {
        return npcs;
    }
public void listNPCs() {
    for (NPC npc : this.npcs) {
        System.out.println(npc.getName());
    }
}
public String getDescription() {
    return description;
}

    public Item getItem(String input) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(input)) {
                return item;
            }
        }
        return null;
    }

    public void setDescription(String description) {

        this.description = description;

    }

    public String getTod() {
        return clock.getTimeOfDay();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clock getClock() {
        return clock;
    }

    public boolean hasNPC(String input) {
        for (NPC npc : npcs) {
            if (npc.getName().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    private void createItemFile(String name, String desc,String optional) {
        String tod = clock.getTimeOfDay();
        String fileName = name + tod +".txt";
        File file = new File(fileName);
        if(!file.exists()) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Room Name: " + name + "\n");
            fileWriter.write("Description: " + desc + "\n");
            fileWriter.write("Time of Day: " + tod +"\n");
        } catch (IOException e) {
            System.out.println("Something done sploded :( " + fileName);
        }
        }
    }

    private String readFile(String fileName) {
     StringBuilder sb = new StringBuilder();
     try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
         String line = br.readLine();
         while (line != null) {
             sb.append(line);
             sb.append(System.lineSeparator());
             line = br.readLine();
         }
        }   catch (IOException ex) {
            System.out.println("Error reading file.");
            }
            return sb.toString();
        }
    
}