package beavers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Player {

    private Room room;
    private ArrayList<Item> inventory;
    private ArrayList<NPC> npcs;
    private HashMap<String, Integer> stats;
    private String perk, name, description;
    private int social, fineMotor, grossMotor, imgenation, learning, emotional;

    private int  resilience,luck, hunger, thirst, fatigue, stress, money, experience, level;



    private HashMap<String, Perk> perks;
    private Perk TeaParty,Brat,Trouble,Shy,Bookworm,Rebel,Overachiever,TeacherPet,ClassClown,Slacker,Popular,Outcast,Geek,Confederate;
    private Scanner scanner;
    public Player(){
        scanner = new Scanner(System.in);
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
this.room.getDescription();
    }



    public String getName() {
        return name;
    }



    public String getPerks() {
        return perks.keySet().toString();
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
    public void talk() {
        System.out.println("To whom?");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            this.getRoom().getNPCByName(input).dialogue(this);
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

    public ArrayList<NPC> getNpcs() {
        return npcs;
    }


    public void setNpcs(ArrayList<NPC> npcs) {
        this.npcs = npcs;
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
    public Perk getTeaParty() {
        return TeaParty;
    }
    public void setTeaParty(Perk teaParty) {
        TeaParty = teaParty;
    }
    public Perk getBrat() {
        return Brat;
    }
    public void setBrat(Perk brat) {
        Brat = brat;
    }
    public Perk getTrouble() {
        return Trouble;
    }
    public void setTrouble(Perk trouble) {
        Trouble = trouble;
    }
    public Perk getShy() {
        return Shy;
    }
    public void setShy(Perk shy) {
        Shy = shy;
    }
    public Perk getBookworm() {
        return Bookworm;
    }
    public void setBookworm(Perk bookworm) {
        Bookworm = bookworm;
    }
    public Perk getRebel() {
        return Rebel;
    }
    public void setRebel(Perk rebel) {
        Rebel = rebel;
    }
    public Perk getOverachiever() {
        return Overachiever;
    }
    public void setOverachiever(Perk overachiever) {
        Overachiever = overachiever;
    }
    public Perk getTeacherPet() {
        return TeacherPet;
    }
    public void setTeacherPet(Perk teacherPet) {
        TeacherPet = teacherPet;
    }
    public Perk getClassClown() {
        return ClassClown;
    }
    public void setClassClown(Perk classClown) {
        ClassClown = classClown;
    }
    public Perk getSlacker() {
        return Slacker;
    }
    public void setSlacker(Perk slacker) {
        Slacker = slacker;
    }
    public Perk getPopular() {
        return Popular;
    }
    public void setPopular(Perk popular) {
        Popular = popular;
    }
    public Perk getOutcast() {
        return Outcast;
    }
    public void setOutcast(Perk outcast) {
        Outcast = outcast;
    }
    public Perk getGeek() {
        return Geek;
    }
    public void setGeek(Perk geek) {
        Geek = geek;
    }
    public Perk getConfederate() {
        return Confederate;
    }
    public void setConfederate(Perk confederate) {
        Confederate = confederate;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public String toString() {
        return "Player[]";
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
            System.out.println("What is your name?");
            String input = this.scanner.nextLine();
            this.name = input;
            System.out.println("What is your perk?");
            input = this.scanner.nextLine();
            if(perks.containsKey(input)){
                this.perk = input;
            }else { 
                System.out.println("Invalid perk. Please choose from the following: \n" + perks.keySet());
            }
            System.out.println("What is your description?");
            input = this.scanner.nextLine();
            this.description = input;

    }

}
