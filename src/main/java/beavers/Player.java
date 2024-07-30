package jackal.face;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Player {
    private static Player player;
    public Room room;
    private JTextArea jTextArea;
    private ArrayList<Item> inventory;
    private Item item;
    private String name;
    private ArrayList<Perk> perks;
    private String description;
    private int experience;
    private int money;
    private int resilience;
    private String optional;
    private int level;
    public Player(String string, String string2) {

        room = new Room("Default Room");
        inventory = new ArrayList<Item>();
        perks = new ArrayList<Perk>();
    }
    public void takeItem(String itemName) {
        item = getItemByName(itemName);
        inventory.add(item);
        room.removeItem(item);
    }
    private Item getItemByName(String itemName) {
        for (Item item : room.getInventory()) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    public void dropItem(String itemName) {
        item = getItemByName(itemName);
        inventory.remove(item);
        room.addItem(item);
    }
    public void useItem(String itemName) {
        item = getItemByName(itemName);
        item.use();
    }
    public ArrayList<Item> getInventory() {
        return this.inventory;

    }
    public String getName() {
        return this.name;
    }
    public ArrayList<Perk> getPerks() {
        jTextArea.append("Perks: ");
        for (Perk perk : this.perks) {
            jTextArea.append(perk.getName() + " ");
        }
        return this.perks;
    }
    public int getExperience() {
return this.experience;
    }
    public String getDescription() {
        return this.description;
    }
    public void dialog(String npcName) {
        this.getRoom().getNPCByName(npcName).dialog(this);
    }
    Room getRoom() {
        return this.room;
    }
    public void inspect(String selectedItem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inspect'");
    }
    public void inventory(String selectedItem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inventory'");
    }
    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }
            @SuppressWarnings("unused")
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
        @SuppressWarnings("unused") 
        private void createItemFile() {
        String fileName = this.name + ".txt";
        File file = new File(fileName);
        if(!file.exists()) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Item Name: " + this.name + "\n");
            fileWriter.write("Description: " + this.description + "\n");
            fileWriter.write("Optional: " + this.optional+"\n");
        } catch (IOException e) {
            System.out.println("Something done sploded :( " + fileName);
            e.printStackTrace();
        }
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setResilience(int resilience) {
        this.resilience = resilience;
    }
    public void setOptional(String optional) {
        this.optional = optional;
    }
    public void levelup() {
        switch(this.getLevel()){
            case 1:
            getjTextArea().append("You have leveled up to level 2!\n");

        }
    }
    private JTextArea getjTextArea() {
        this.jTextArea = Game.getjTextArea();
        return this.jTextArea;
    }
    private int getLevel() {
return this.level;
    }
    public void setPerks(ArrayList<Perk> perks) {
        this.perks = perks;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public void setPerk(Perk perk) {
        this.perks.add(perk);
    }
    public void removePerk(Perk perk) {
        this.perks.remove(perk);
    }
    public void removeItem(Item item) {
        this.inventory.remove(item);
    }
    public void addItem(Item item) {
        this.inventory.add(item);
    }
    public int getMoney() {
        return this.money;
        }
    public int getResilience() {
        return this.resilience;

    }
    public static Player createPlayer() {
       Player player = new Player("Default Player", "Default Description");
        return player;
        
    }
    public static Player getPlayer() {
        return player;
    }

}