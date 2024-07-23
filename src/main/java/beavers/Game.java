package beavers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public final class Game {

    private final Player player;
    private boolean running;
    private HashMap<String, Command> commands;
    private HashMap<String, Room> rooms;
    private String input;
    private Scanner scanner;

    public Game(Player player) {
        scanner = new Scanner(System.in);
        this.player = player;
        initualizeCommands();
        buildMap();
        buildWorld();
    }

    public void start() {
        running = true;
        System.out.println("Welcome to the game.");
        System.out.println("Type 'help' for a list of commands.");
    this.gameLoop();
    }
    private void gameLoop() {
        while (running) {
            System.out.println("What do you want to do?");
            try {
                // Directly read the line, which will wait for user input
                input = scanner.nextLine();
                Command command = commands.get(input);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("No such command.");
                }
            } catch (Exception ex) {
                System.out.println("Error reading input: " + ex.getMessage());
                // Optionally, break out of the loop or handle the exception as needed
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
        NPC susy = new NPC("Susy", "A little girl with a red bow in her hair.");
        rooms.get("foyer").addNPC(drWhite);
        rooms.get("living room").addNPC(msSagely);
        rooms.get("bedroom").addNPC(fuzzy);
        rooms.get("bathroom").addNPC(susy);

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
    private void initualizeCommands() {
commands = new HashMap<>();
        commands.put("go", (Command) () -> {
            System.out.println("Where?");
            try {
                String input = scanner.nextLine();
                Room nextRoom = rooms.get(input);
                if (nextRoom != null) {
                    player.go(nextRoom);
                } else {
                    System.out.println("No room by that name.");
                }
            }finally {
                System.out.println("Error reading input.");
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
            try {
                String input = scanner.nextLine();
                if (player.getRoom().hasItem(input)) {
                    Item item = player.getRoom().getItem(input);
                    player.takeItem(item);
                    System.out.println("You took " + item.getName());
                } else {
                    System.out.println("No such item.");
                }
            }finally {
                System.out.println("Error reading input.");
            }

            
        });
        commands.put("look", () -> {
            this.player.getRoom().describeRoom();
            this.player.getRoom().listItems();
        });
    }
}
