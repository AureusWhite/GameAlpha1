package beavers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public final class Game {

    public static Game game;
    private final Player player;
    private boolean running;
    private HashMap<String, Command> commands;
    private HashMap<String, Room> rooms;
    private String input;
    private Scanner scanner;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Game(Player player) {
        game = this;
        scanner = new Scanner(System.in);
        this.player = player;
        initualizeCommands();
        buildMap();
        buildWorld();
    }

    public void start() {
        running = true;
        System.out.println("Welcome to the game.");
        System.out.println("Type 'help' for a list of advanced commands.");
        this.gameLoop();
    }
    
    public void buildWorld(){
        Item key = new Item("Key Card", "A plastic card used to access various rooms of the facility, you have one yourself. Who's is this?.", "key");
        Item diaper = new Item("Diaper", "A clean white diaper.", "Clothing");
        Item book = new Item("Book", "So you got rejuved, what now. A book for rejuve early readers.", "Book");
        Item phone = new Item("Phone", "A large red toy phone, it rings but the person on the other end never answers, how rude.", "Toy");
        Item puzzle = new Item("puzzle", "A wooden puzzle.", "Toy");

        NPC white = new NPC("white", "I'm a white NPC.");
        NPC black = new NPC("black", "I'm a black NPC.");
        NPC red = new NPC("red", "I'm a red NPC.");
        NPC blue = new NPC("blue", "I'm a blue NPC.");
        NPC green = new NPC("green", "I'm a green NPC.");

        rooms.get("foyer").addNPC(white);
        rooms.get("kitchen").addNPC(black);
        rooms.get("livingroom").addNPC(red);
        rooms.get("bedroom").addNPC(blue);
        rooms.get("bathroom").addNPC(green);

        rooms.get("foyer").addItem(key);
        rooms.get("kitchen").addItem(diaper);
        rooms.get("livingroom").addItem(book);
        rooms.get("bedroom").addItem(phone);
        rooms.get("bathroom").addItem(puzzle);
    
    }
    
    public void clearConsole() {
        // Print several new lines to push the previous output up
        for (int i = 0; i < 10; i++) {
            System.out.println(".");
        }
        System.out.println("------------------------------------------------");
        System.out.flush();
    }
    
    public Player getPlayer() {
        return player;
    }

    public boolean isRunning() {
        return running;
    }
   
    public void setRunning(boolean running) {
        this.running = running;
    }
   
    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

private void gameLoop() {
    while (running) {
        clearConsole() ;
        System.out.print("| ");
        for (String command : commands.keySet()) {
            System.out.print(command + " | ");
        }
        System.out.println();
        System.out.print("What do you want to do? -> ");
        try {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                if (input != null && !input.isBlank()) {
                    Command command = commands.get(input);
                    if (command != null) {
                        command.execute();
                    } else {
                        System.out.println("No such command.");
                    }
                } else {
                    System.out.println("Invalid input.");
                }
            } else {
                System.out.println("No input available.");
            }
        } catch (Exception ex) {
            System.out.println("Error reading input: " + ex.getMessage());
        }
    }
}

    private void buildMap() {
        rooms = new HashMap<>();
        Room foyer = new Room("foyer");
        Room kitchen = new Room("kitchen");
        Room livingRoom = new Room("livingroom");
        Room bedroom = new Room("bedroom");
        Room bathroom = new Room("bathroom");
        rooms.put("foyer", foyer);
        rooms.put("kitchen", kitchen);
        rooms.put("livingroom", livingRoom);
        rooms.put("bedroom", bedroom);
        rooms.put("bathroom", bathroom);

    }

    private String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName.concat(".txt")))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
            ex.printStackTrace();
        }
        return sb.toString();
    }

    private void initualizeCommands() {
commands = new HashMap<>();
        commands.put("go", (Command) () -> {
            System.out.println(ANSI_YELLOW + "Where would you like to go?" + ANSI_RESET);
            try {
                String input = scanner.nextLine();
                Room nextRoom = rooms.get(input);
                if (nextRoom != null) {
                    player.go(nextRoom);
                    System.out.print(readFile((player.getRoom().getName())+player.getRoom().getClock().getTimeOfDay()));
                } else {
                    System.out.println("No room by that name.");
                    
                }
            }finally {
                System.out.println("Error reading input.");
            }
            });
        commands.put("talk", (Command) () -> {
            System.out.println("Who would you like to talk to?");
            try {
                String input = scanner.nextLine().toLowerCase();
                if (player.getRoom().hasNPC(input)) {
                    NPC npc = player.getRoom().getNPC(input);
                    System.out.println(npc.getName() + ": " + npc.getDialogue());
                } else {
                    System.out.println("No such NPC.");
                }
        } finally {
            System.out.println("Error reading input.");
        }
        }
        );
        commands.put("quit", () -> running = false);
        commands.put("help", () -> {
            System.out.println("Commands:");
            for (String command : commands.keySet()) {
                System.out.println(command);
            }
        });
        commands.put("inventory", () -> {
            player.listItems();
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
            this.player.getRoom().listItems();
            System.out.println("");
            System.out.println("NPCs in the room:");
            this.player.getRoom().listNPCs();
            System.out.println("");
            System.out.print(readFile(player.getRoom().getName().concat(player.getRoom().getClock().getTimeOfDay())));    ;

        });
        commands.put("drop", () -> {
            System.out.println("What do you want to drop?");
            try{
            String itemName = scanner.nextLine();
            Item item = player.getItem(itemName);
            this.player.getInventory().remove(item);
            
            if (item == null) {
                System.out.println("Error: You don't have an item named " + itemName);
            } else {
                player.dropItem(item);
            }
        }finally {
            System.out.println("Error reading input.");
        }
        });
    }
}
