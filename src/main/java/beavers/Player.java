package beavers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private Room room;
    private ArrayList<Item> inventory;
    private ArrayList<NPC> npcs;
    private HashMap<String, Integer> stats;
    private String perk, name, description;
    private int social, fineMotor, grossMotor, imgenation, learning, emotional;
    private int resilience,luck, hunger, thirst, fatigue, stress, money, experience, level;
    private HashMap<String, Perk> perks;
    private Perk TeaParty,Brat,Trouble,Shy,Bookworm,Rebel,Overachiever,TeacherPet,ClassClown,Slacker,Popular,Outcast,Geek,Confederate;
    private Game game;
    private String input;

    public Player(){
        this.room = new Room("Default");
        this.game = new Game(this);
        inventory = new ArrayList<Item>();
        npcs = new ArrayList<NPC>();
        stats = new HashMap<>();
        perks = new HashMap<>();
        initualizePerks();
        createPlayer();
        
    }
    
    public String getPerk() {
    return perk;
} 
    
public void setPerk(String perk) {
        this.perk = perk;
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
}

public void go(Room room) {
this.room = room;
this.getRoom().listItems();
this.game.printToConsole("NPCs in room: ");
this.getRoom().listNPCs();
    }

    public String getName() {
        return name;
    }

    public String getPerks() {
        return perks.keySet().toString();
    }

    public ArrayList<Item> getInventory() {
        if (inventory.isEmpty()) {
            return null;
        }else {
            return inventory;
        }
        }

        public void takeItem(Item item) {
        inventory.add(item);
        room.removeItem(item);
    }

    public void talk() {
        this.game.printToConsole("To whom?");
        String input = this.game.getInput();
        if(this.room.hasNPC(input)) {
            NPC npc = this.room.getNPC(input);
            this.game.printToConsole(npc.getName() + ": " + npc.getDialogue());
        }
    }

    public int getResilience() {
        return resilience;
    }

    public void setResilience(int resilience) {
        this.resilience = resilience;
    }

    public int getFineMotor() {
        return fineMotor;
    }

    public void setFineMotor(int fineMotor) {
        this.fineMotor = fineMotor;
    }

    public int getGrossMotor() {
        return grossMotor;
    }

    public void setGrossMotor(int grossMotor) {
        this.grossMotor = grossMotor;
    }

    public int getLearning() {
        return learning;
    }

    public void setLearning(int learning) {
        this.learning = learning;
    }

    public int getEmotional() {
        return emotional;
    }

    public void setEmotional(int emotional) {
        this.emotional = emotional;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getStress() {
        return stress;
    }

    public void setStress(int stress) {
        this.stress = stress;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getImgenation() {
        return imgenation;
    }

    public void setImgenation(int imgenation) {
        this.imgenation = imgenation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPerk(String perk) {
        if(perks.containsKey(perk)){
            return perk;
        }
        return "Invalid perk. Please choose from the following: \n" + perks.keySet();
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Integer> stats) {
        this.stats = stats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerks(HashMap<String, Perk> perks) {
        this.perks = perks;
    }

    @Override
    public String toString() {
        return "Player[]";
    }
    
    public void listItems() {
        if (!inventory.isEmpty()) {
            for (Item item : inventory) {
                this.game.printToConsole(item.getName());
            }
        }else {
            this.game.printToConsole("Inventory is empty.");
        }
    }
    
    public Item getItem(String input) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(input)) {
                return item;
            }
        }
        return null;
    }
    
    public void dropItem(Item item) {
        inventory.remove(item);
        this.getRoom().addItem(item);
        this.game.printToConsole("You dropped " + item.getName());

    }
    
    Room getRoom() {
        return this.room;
    }
    
    void setPerk(Perk perk2) {
        this.perk = perk2.getName();
    }
    
    private void initualizePerks() {
        perks.put("Tea Party", TeaParty);
        perks.put("Brat", Brat);
        perks.put("Trouble", Trouble);
        perks.put("Shy", Shy);
        perks.put("Bookworm", Bookworm);
        perks.put("Rebel", Rebel);
        perks.put("Overachiever", Overachiever);
        perks.put("Teacher's Pet", TeacherPet);
        perks.put("Class Clown", ClassClown);
        perks.put("Slacker", Slacker);
        perks.put("Popular", Popular);
        perks.put("Outcast", Outcast);
        perks.put("Geek", Geek);
        perks.put("Confederate", Confederate);
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
        this.game.printToConsole("Error reading file.");
        }
        return sb.toString();
    }

    private void createPlayer() {
        stats.put("resilience", 5);
        stats.put("fineMotor", 5);
        stats.put("grossMotor", 5);
        stats.put("learning", 5);
        stats.put("emotional", 5);
        stats.put("social", 5);
        stats.put("luck", 5);
        stats.put("hunger", 0);
        stats.put("thirst", 0);
        stats.put("fatigue", 0);
        stats.put("stress", 0);
        stats.put("money", 0);
        stats.put("experience", 0);
        stats.put("level", 1);
        stats.put("imgenation", 5);
        perks.put("Tea Party", TeaParty);
        perks.put("Brat", Brat);
        perks.put("Trouble", Trouble);
        perks.put("Shy", Shy);
        perks.put("Bookworm", Bookworm);
        perks.put("Rebel",  Rebel);
        perks.put("Overachiever", Overachiever);
        perks.put("Teacher's Pet", TeacherPet);
        perks.put("Class Clown", ClassClown);
        perks.put("Slacker", Slacker);
        perks.put("Popular", Popular);
        perks.put("Outcast", Outcast);
        perks.put("Geek", Geek);
        this.resilience = 5;
        this.fineMotor = 5;
        this.grossMotor = 5;
        this.learning = 5;
        this.emotional = 5;
        this.social = 5;
        this.luck = 5;
        this.hunger = 0;
        this.thirst = 0;
        this.fatigue = 0;
        this.stress = 0;
        this.money = 0;
        this.experience = 0;
        this.level = 1;
        this.imgenation = 5;
        this.perk = "Default";
        textWall("tutorial.txt");
    
        if (game != null) {
            this.game.printToConsole("What is your name? -> ");
            String input = game.getInput();
            this.game.printToConsole("Hello, " + input + "!");
            textWall("intro.txt");
            this.name = input;
            
            this.game.printToConsole("What is your perk? -> ");
            if (perks != null) {
                this.game.printToConsole(perks.keySet());
                input = game.getInput();
                textWall(input + ".txt");
                
                if (perks.containsKey(input)) {
                    this.game.printToConsole("Are you sure you want to choose " + input + "? (yes/no)");
                    String confirm = game.getInput();
                    
                    if (confirm.equalsIgnoreCase("yes")) {
                        this.perk = input;
                    } else {
                        this.game.printToConsole("Perk selection cancelled.");
                    }
                } else {
                    this.game.printToConsole("Invalid perk selected.");
                }
            } else {
                this.game.printToConsole("Perks are not initialized.");
            }
        } else {
            System.out.println("Game object is not initialized.");
        }
    }
        

    public void saveGame() {
        String fileName = this.name + ".txt";
        File file = new File(fileName);
        if(!file.exists()) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Player Name: " + this.name + "\n");
            fileWriter.write("Description: " + this.description + "\n");
            fileWriter.write("Stats: " + this.stats + "\n");
            fileWriter.write("Perk: " + this.perk + "\n");
            fileWriter.write("Inventory: " + this.inventory + "\n");
            fileWriter.write("NPCs: " + this.npcs + "\n");
            fileWriter.write("Room: " + this.room + "\n");
        } catch (IOException e) {
            this.game.printToConsole("Something done sploded :( " + fileName);
        }
        }
    }
    public void loadGame(String name) {
        String fileName = name + ".txt";
        File file = new File(fileName);
        if(file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line = br.readLine();
                while (line != null) {
                    if(line.contains("Player Name:")) {
                        this.name = line.substring(13);
                    }else if(line.contains("Description:")) {
                        this.description = line.substring(13);
                    }else if(line.contains("Stats:")) {
                        this.stats.put(line.substring(7, 18), Integer.parseInt(line.substring(19)));
                    }else if(line.contains("Perk:")) {
                        this.perk = line.substring(6);
                    }else {
                        this.game.printToConsole("Error reading file.");
                    }
                    this.game.printToConsole(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                this.game.printToConsole("Error reading file.");
            }
        }else {
            this.game.printToConsole("No such file.");
        }
    }

    private void textWall(String string) {
        this.game.printToConsole(readFile(string));
    }

    private void createItemFile(String name, String desc,String optional) {
        int[] stats = new int[6];
    
        String fileName = name + ".txt";
        File file = new File(fileName);
        if(!file.exists()) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Player Name: " + name + "\n");
            fileWriter.write("Description: " + desc + "\n");
            fileWriter.write("Stats" + stats + "\n");
        } catch (IOException e) {
            this.game.printToConsole("Something done sploded :( " + fileName);
        }
        }
    }

    public void listStats() {
        this.game.printToConsole("Stats: ");
        for (String stat : stats.keySet()) {
            this.game.printToConsole(stat + ": " + stats.get(stat));
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
