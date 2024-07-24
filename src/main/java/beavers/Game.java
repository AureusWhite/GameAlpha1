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
    public void buildWorld(){
        Item key = new Item("key", "A shiny key.");
        Item diaper = new Item("diaper", "A clean white diaper.");
        Item book = new Item("book", "A book for early readers.");
        Item phone = new Item("phone", "A large red toy phone.");
        Item puzzle = new Item("puzzle", "A wooden puzzle.");
        rooms.get("foyer").addItem(key);
        rooms.get("kitchen").addItem(diaper);
        rooms.get("livingroom").addItem(book);
        rooms.get("bedroom").addItem(phone);
        rooms.get("bathroom").addItem(puzzle);
    
    }
public void populate () {
    NPC drWhite = new NPC("Dr. White", "A lanky looking man in a white coat.");
    NPC msSagely = new NPC("Ms. Sagely", "A wisen but kind looking woman who glances at you with a smile.");
    NPC fuzzy = new NPC("Fuzzy", "Fuzzy is an andriod teddybear with a screen for a face.");
    NPC susy = new NPC("Susy", "A little girl with a red bow in her hair.");
    rooms.get("foyer").addNPC(drWhite);
    rooms.get("livingroom").addNPC(msSagely);
    rooms.get("bedroom").addNPC(fuzzy);
    rooms.get("bathroom").addNPC(susy);

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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    private void gameLoop() {
        while (running) {
            System.out.println("What do you want to do?");
            try {
                input = scanner.nextLine();
                Command command = commands.get(input);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("No such command.");
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
            System.out.println("Where?");
            try {
                String input = scanner.nextLine();
                Room nextRoom = rooms.get(input);
                if (nextRoom != null) {
                    player.go(nextRoom);
                    System.out.print(readFile((player.getRoom().getName())+player.getRoom().clock.getTimeOfDay()));
                    
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
            System.out.print(readFile(player.getRoom().getName().concat(player.getRoom().clock.getTimeOfDay())));    ;
            this.player.getRoom().listItems();
        });
    }
}
