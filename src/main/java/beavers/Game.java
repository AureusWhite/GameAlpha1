package beavers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public final class Game extends JFrame{
    public static Game game;
    private final Player player;
    private boolean running;
    private HashMap<String, Command> commands;
    private HashMap<String, Room> rooms;
    private String input;
    private JTextArea outputArea;
    private JTextField inputField;
    private JButton submitButton;

    public Game(Player player) {
        setTitle("Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.WEST);

        inputField = new JTextField();
        submitButton = new JButton("Submit");
        inputField.addActionListener(new ActionListener() {
            private JTextComponent inputField;
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                outputArea.append(input + "\n");
            }
        });
        add(inputField, BorderLayout.SOUTH);
        add(submitButton, BorderLayout.SOUTH);
        submitButton.addActionListener(new ActionListener() {
            private boolean inputReady;

            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (Game.this) {
                    input = inputField.getText();
                    inputReady = true;
                }
            }
        });
        setVisible(true);

        game = this;
        this.player = player;
        initualizeCommands();
        buildMap();
        buildWorld();
    }
    public String getInput() {
        return inputField.getText();
    }
    public void start() {
        running = true;
        printToConsole("Welcome to the game.");
        printToConsole("Type 'help' for a list of advanced commands.");
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
        printToConsole(readFile(player.getRoom().getName().concat(player.getRoom().getClock().getTimeOfDay())));
        printToConsole("What do you want to do? ->");
        try {
            if (inputField.getText() != null && !inputField.getText().isBlank()) {
                Command command = commands.get(inputField.getText());
                if (command != null) {
                    command.execute();
                } else {
                    printToConsole("No such command.");
                }
            } else {
                printToConsole("Invalid input.");
            }
        } catch (Exception ex) {
            printToConsole("Error reading input: " + ex.getMessage());
        }
        printToConsole("What do you want to do? -> ");
    }   
}
        public void printToConsole(String string) {
            outputArea.append(string);

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
            printToConsole("Error reading file: " + ex.getMessage());
            ex.printStackTrace();
        }
        return sb.toString();
    }

    private void initualizeCommands() {
commands = new HashMap<>();
        commands.put("go", (Command) () -> {
            try {
                String input = getInput().toLowerCase();
                Room nextRoom = rooms.get(input);
                if (nextRoom != null) {
                    player.go(nextRoom);
                    printToConsole(readFile((player.getRoom().getName())+player.getRoom().getClock().getTimeOfDay()));
                } else {
                    printToConsole("No room by that name.");
                    
                }
            }finally {
                printToConsole("Error reading input.");
            }
            });
        commands.put("talk", (Command) () -> {
            printToConsole("Who would you like to talk to?");
            try {
                String input = getInput().toLowerCase();
                if (player.getRoom().hasNPC(input)) {
                    NPC npc = player.getRoom().getNPC(input);
                    printToConsole(npc.getName() + ": " + npc.getDialogue());
                } else {
                    printToConsole("No such NPC.");
                }
        } finally {
            printToConsole("Error reading input.");
        }
        }
        );
        commands.put("quit", () -> running = false);
        commands.put("help", () -> {
            printToConsole("Commands:");
            for (String command : commands.keySet()) {
                printToConsole(command);
                player.loadGame(player.getName());
            }
        });
        commands.put("inventory", () -> {
            player.listItems();
        });
        commands.put("take", () -> {
            printToConsole("What do you want to take?");
            try {
                String input = game.getInput();
                if (player.getRoom().hasItem(input)) {
                    Item item = player.getRoom().getItem(input);
                    player.takeItem(item);
                    printToConsole("You took " + item.getName());
                } else {
                    printToConsole("No such item.");
                }
            }finally {
                printToConsole("Error reading input.");
            }

            
        });
        commands.put("look", () -> {
            this.player.getRoom().listItems();
            printToConsole("NPCs in the room:");
            this.player.getRoom().listNPCs();
            printToConsole(readFile(player.getRoom().getName().concat(player.getRoom().getClock().getTimeOfDay())));    ;

        });
        commands.put("drop", () -> {
            printToConsole("What do you want to drop?");
            try{
            String itemName = this.getGame().getInput();
            Item item = player.getItem(itemName);
            this.player.getInventory().remove(item);
            
            if (item == null) {
                printToConsole("Error: You don't have an item named " + itemName);
            } else {
                player.dropItem(item);
            }
        }finally {
            printToConsole("Error reading input.");
        }
        });
    }

    private Game getGame() {
        return this;
    }
    public void printToConsole(Set<String> keySet) {
        // Do nothing;
    }
}
