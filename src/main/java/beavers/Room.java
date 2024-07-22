package beavers;


import java.util.ArrayList;

public class Room {
    ArrayList <NPC> npcs;
    ArrayList <Item> items;
    private String description;
    private String name;
    private Clock clock;
    private String morning, afternoon, evening;

    public Room(String name) {
        this.name = name;
        npcs = new ArrayList <>();
        items = new ArrayList <>();
    }


public NPC getNPC(String name) {
        for (NPC npc : npcs) {
            if (npc.getName().equals(name)) {
                return npc;
            }
        }
        return null;
    }
    public void addNPC(NPC npc) {
        npcs.add(npc);
    }
    public void removeNPC(NPC npc) {
        npcs.remove(npc);
    }
    public void describe() {
        System.out.println(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
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
    public void takeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    public NPC[] getNPCs() {
        for (NPC npc : npcs) {
            System.out.println(npc.getName());
        }
        return null;
    }
    public void setNpcs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
    }
    public String getDescription(String timeOfDay) {
        return switch (timeOfDay) {
            case "morning" -> morning;
            case "afternoon" -> afternoon;
            case "evening" -> evening;
            default -> "No description available";
        };
    }
    public String toString() {
        return name;
    }
    public void describeItems() {
        for (Item item : this.items) {
            System.out.println(item.getName());
        }
    }
    public void describeNPCs() {
        for (NPC npc : npcs) {
            System.out.println(npc.getName());
        }
    }
    public void describeRoom() {
        this.clock.getCurrentHour();
        if (clock.getCurrentHour() < 12) {  
            System.out.println(this.getDescription(morning));
        } else if (clock.getCurrentHour() == 12) {
            System.out.println(this.getDescription(afternoon));
        } else {
            System.out.println(this.getDescription(evening));
        }
        System.out.println(description);

                System.out.println("Items in the room:");
        describeItems();
        System.out.println("NPCs in the room:");
        describeNPCs();
    }


    public NPC getNPCByName(String input) {
        if (input == null) {
            return null;
        }else {
            for (NPC npc : npcs) {
                if (npc.getName().equals(input)) {
                    return npc;
                }
            }
            return null;
        }
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


    public ArrayList<NPC> getNpcs() {
        return npcs;
    }


    public String getDescription() {
        return description;
    }


    public Clock getClock() {
        return clock;
    }


    public void setClock(Clock clock) {
        this.clock = clock;
    }


    public String getMorning() {
        return morning;
    }


    public void setMorning(String morning) {
        this.morning = morning;
    }


    public String getAfternoon() {
        return afternoon;
    }


    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }


    public String getEvening() {
        return evening;
    }


    public void setEvening(String evening) {
        this.evening = evening;
    }


    public Item getItem(String input) {
        for (Item item : items) {
            if (item.getName().equals(input)) {
                return item;
            }
        }
        return null;
    }

}
