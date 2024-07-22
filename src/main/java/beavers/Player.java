package beavers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
this.room.getDescription();
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

    public void takeItem(Item item) {
        inventory.add(item);
        room.removeItem(item);
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
