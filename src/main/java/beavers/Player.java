package beavers;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private Room room;
    ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<NPC> npcs = new ArrayList<>();
    private String perk;
    private String name;

    public void talk() {
        System.out.println("To whom?");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            this.getRoom().getNPCByName(input).dialogue(this);
        }
        
    }



    Room getRoom() {
        return this.room;
    }



    public void go(Room room) {
this.room = room;
this.room.describe();
    }



    public String getName() {
        return name;
    }

    public String getPerk() {
        return perk;
    }

    public void setPerk(String perk) {
        this.perk = perk;
    }



    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Inventory is empty.";
        }else {
            return "Inventory: " + inventory;
        }
        }

    public ArrayList<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
    }



    public void takeItem(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'takeItem'");
    }

}
