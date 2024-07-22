package beavers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public final class Game {

    private final Player player;
    private Room room;
    private NPC npc;
    private boolean running;
    private HashMap<String, Command> commands;
    private HashMap<String, Room> rooms;

    public Game(Player player, Room room, NPC npc) {
        this.player = player;
        this.room = room;
        this.npc = npc;
        initualizeCommands();
        buildMap();
        buildWorld();
    }

    private void buildMap() {
        rooms = new HashMap<>();
        Room foyer = new Room("foyer");
        Room kitchen = new Room("kitchen");
        Room livingRoom = new Room("living room");
        Room bedroom = new Room("bedroom");
        Room bathroom = new Room("bathroom");
        rooms.put("foyer", foyer);
        rooms.put("kitchen", kitchen);
        rooms.put("living room", livingRoom);
        rooms.put("bedroom", bedroom);
        rooms.put("bathroom", bathroom);
        foyer.setDescription(readFile("foyer.txt"));
        kitchen.setDescription(readFile("kitchen.txt"));
        livingRoom.setDescription(readFile("livingRoom.txt"));
        bedroom.setDescription(readFile("bedroom.txt"));
        bathroom.setDescription(readFile("bathroom.txt"));


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
    private void initualizeCommands() {
commands = new HashMap<>();
        commands.put("go", (Command) () -> {
            System.out.println("Where?");
            Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                Room nextRoom = rooms.get(input);
                if (nextRoom != null) {
                    player.go(nextRoom);
                } else {
                    System.out.println("No room by that name.");
                }
            });
        commands.put("talk", () -> player.talk());
        commands.put("quit", () -> running = false);
        commands.put("help", () -> {
            System.out.println("Commands:");
            for (String command : commands.keySet()) {
                System.out.println(command);
            }
        });
        commands.put("inventory", () -> {
            System.out.println(player.getInventory());
        });
        commands.put("take", () -> {
            System.out.println("What do you want to take?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (player.getRoom().hasItem(input)) {
                Item item = player.getRoom().getItem(input);
                player.takeItem(item);
                System.out.println("You took " + item.getName());
            } else {
                System.out.println("No such item.");
            }

            
        });
        commands.put("look", () -> {
            this.player.getRoom().describeRoom();
            this.player.getRoom().listItems();
        });
    }

    public void start() {
        running = true;
        while (running) {
            System.out.println("What do you want to do?");
            String input = System.console().readLine();
            Command command = commands.get(input);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Type 'help' for a list of commands.");
            }
        }
    }
    public void buildWorld(){
        Item key = new Item("key", "A shiny key.");
        Item diaper = new Item("diaper", "A clean white diaper.");
        Item book = new Item("book", "A book for early readers.");
        Item phone = new Item("phone", "A large red toy phone.");
        Item puzzle = new Item("puzzle", "A wooden puzzle.");
        rooms.get("foyer").addItem(key);
        rooms.get("kitchen").addItem(diaper);
        rooms.get("living room").addItem(book);
        rooms.get("bedroom").addItem(phone);
        rooms.get("bathroom").addItem(puzzle);

    }
    public void populate () {
        NPC drWhite = new NPC("Dr. White", "A lanky looking man in a white coat.");
        NPC msSagely = new NPC("Ms. Sagely", "A wisen but kind looking woman who glances at you with a smile.");
        NPC fuzzy = new NPC("Fuzzy", "Fuzzy is an andriod teddybear with a screen for a face.");
        rooms.get("foyer").addNPC(drWhite);
        rooms.get("living room").addNPC(msSagely);
        rooms.get("bedroom").addNPC(fuzzy);
    }
}
