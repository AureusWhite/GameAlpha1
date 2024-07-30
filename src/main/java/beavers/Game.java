package jackal.face;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Game {
    static JTextArea jTextArea;
    public static JTextArea getjTextArea() {
        return jTextArea;
    }
    Player player;
    private final HashMap<String,Command> commands = new HashMap<String,Command>();
    private String cmd;
    private String itemName;
    public ArrayList<Room> rooms;
    private Room porchCloset, balconyCloset, roofCloset, gardenCloset, drivewayCloset, frontYardCloset, backYardCloset, stairsCloset, hallwayCloset, nurseryCloset, kitchenCloset, livingRoomCloset, bedroomCloset, bathroomCloset, atticCloset, basementCloset, garageCloset, shedCloset, poolCloset, patioCloset, deckCloset, porch, balcony, roof, garden, driveway, frontYard, backYard, stairs, hallway, nursery, kitchen, livingRoom, bedroom, bathroom, attic, basement, garage, shed, pool, patio, deck;
    private String optional;
    private String desc;

private String name;

    public Game() {
        this.name = "BusyBeavers Home For Wayward Rejuves";
        this.optional = "Optional";
        this.desc = "Description";
        this.player = Player.createPlayer(); 
        this.rooms = new ArrayList<Room>();
        jTextArea = GUI.getjTextArea();
        }
    public HashMap<String, Command> getCommands() {
            return commands;
        }
    
    public void buildMap(){
        rooms.add(nursery);
        rooms.add(kitchen);
        rooms.add(livingRoom);
        rooms.add(bedroom);
        rooms.add(bathroom);
        rooms.add(hallway);
        rooms.add(stairs);
        rooms.add(basement);
        rooms.add(attic);
        rooms.add(garage);
        rooms.add(garden);
        rooms.add(driveway);
        rooms.add(frontYard);
        rooms.add(backYard);
        rooms.add(shed);
        rooms.add(pool);
        rooms.add(patio);
        rooms.add(deck);
        rooms.add(porch);
        rooms.add(balcony);
        rooms.add(roof);
        rooms.add(livingRoomCloset);
        rooms.add(bedroomCloset);
        rooms.add(bathroomCloset);
        rooms.add(atticCloset);
        rooms.add(basementCloset);
        rooms.add(garageCloset);
        rooms.add(shedCloset);
        rooms.add(poolCloset);
        rooms.add(patioCloset);
        rooms.add(deckCloset);
        rooms.add(porchCloset);
        rooms.add(balconyCloset);
        rooms.add(roofCloset);
        rooms.add(gardenCloset);
        rooms.add(drivewayCloset);
        rooms.add(frontYardCloset);
        rooms.add(backYardCloset);
        rooms.add(stairsCloset);
        rooms.add(hallwayCloset);
        rooms.add(nurseryCloset);
        rooms.add(kitchenCloset);
        
    }

    public Command move(String string) {
        
        if (player.room.getExitByName(string) == null) {
            printToJTextArea("There is no exit in that direction.\n");
        } else {
            player.room = player.room.getExitByName(string);
            printToJTextArea(player.room.getDescription());
            printToJTextArea(readFile(player.room.getName().concat(".txt")));
        }
        return null;
    }

    public void executeCommand(String command) {
        cmd = command;
        if (commands.containsKey(cmd)) {
            commands.get(cmd).execute();
        } else {
            printToJTextArea("Invalid command.");
        }
    }
    public void buildRooms(){
        Room nursery, kitchen, livingRoom, bedroom, bathroom, hallway, stairs, basement, attic, garage, garden, 
        driveway, frontYard, backYard, shed, pool, patio, deck, porch, balcony, roof, livingRoomCloset, bedroomCloset, 
        bathroomCloset, atticCloset, basementCloset, garageCloset, shedCloset, poolCloset, patioCloset, deckCloset, 
        porchCloset, balconyCloset, roofCloset, gardenCloset, drivewayCloset, frontYardCloset, backYardCloset, 
        stairsCloset, hallwayCloset, nurseryCloset, kitchenCloset;

        nursery = new Room("nursery");
        player.setRoom(nursery);
        kitchen = new Room("kitchen");
        livingRoom = new Room("living room");
        bedroom = new Room("bedroom");
        bathroom = new Room("bathroom");
        hallway = new Room("hallway");
        stairs = new Room("stairs");
        basement = new Room("basement");
        attic = new Room("attic");
        garage = new Room("garage");
        garden = new Room("garden");
        driveway = new Room("driveway");
        frontYard = new Room("front yard");
        backYard = new Room("back yard");
        shed = new Room("shed");
        pool = new Room("pool");
        patio = new Room("patio");
        deck = new Room("deck");
        porch = new Room("porch");
        balcony = new Room("balcony");
        roof = new Room("roof");
        livingRoomCloset = new Room("living room closet");
        bedroomCloset = new Room("bedroom closet");
        bathroomCloset = new Room("bathroom closet");
        atticCloset = new Room("attic closet");
        basementCloset = new Room("basement closet");
        garageCloset = new Room("garage closet");
        shedCloset = new Room("shed closet");
        poolCloset = new Room("pool closet");
        patioCloset = new Room("patio closet");
        deckCloset = new Room("deck closet");
        porchCloset = new Room("porch closet");
        balconyCloset = new Room("balcony closet");
        roofCloset = new Room("roof closet");
        gardenCloset = new Room("garden closet");
        drivewayCloset = new Room("driveway closet");
        frontYardCloset = new Room("front yard closet");
        backYardCloset = new Room("back yard closet");
        stairsCloset = new Room("stairs closet");
        hallwayCloset = new Room("hallway closet");
        nurseryCloset = new Room("nursery closet");
        kitchenCloset = new Room("kitchen closet");
        // initialise room exits
        nursery.addExit("Hallway", hallway);  
        nursery.addExit("Closet", nurseryCloset);
        nurseryCloset.addExit("Nursery", nursery);
        kitchen.addExit("Hallway", hallway);
        kitchen.addExit("Closet", kitchenCloset);
        kitchenCloset.addExit("Kitchen", kitchen);
        livingRoom.addExit("Hallway", hallway);
        livingRoom.addExit("Closet", livingRoomCloset);
        livingRoomCloset.addExit("Living_Room", livingRoom);
        bedroom.addExit("Hallway", hallway);
        bedroom.addExit("Closet", bedroomCloset);
        bedroomCloset.addExit("Bedroom", bedroom);
        bathroom.addExit("Hallway", hallway);
        bathroom.addExit("Closet", bathroomCloset);
        bathroomCloset.addExit("Bathroom", bathroom);
        hallway.addExit("Nursery", nursery);
        hallway.addExit("Kitchen", kitchen);
        hallway.addExit("Living_Room", livingRoom);
        hallway.addExit("Bedroom", bedroom);    
        hallway.addExit("Bathroom", bathroom);
        hallway.addExit("Stairs", stairs);
        hallway.addExit("Basement", basement);
        hallway.addExit("Attic", attic);
        hallway.addExit("Garage", garage);
        hallway.addExit("Garden", garden);
        hallway.addExit("Driveway", driveway);
        hallway.addExit("Front.Yard", frontYard);
        hallway.addExit("Back_Yard", backYard);
        stairs.addExit("Hallway", hallway); 
        stairs.addExit("Closet", stairsCloset);
        stairsCloset.addExit("Stairs", stairs);
        basement.addExit("Hallway", hallway);
        basement.addExit("Closet", basementCloset);
        basementCloset.addExit("Basement", basement);
        attic.addExit("Hallway", hallway);
        attic.addExit("Closet", atticCloset);
        atticCloset.addExit("Attic", attic);
        garage.addExit("Hallway", hallway);
        garage.addExit("Closet", garageCloset);
        garageCloset.addExit("Garage", garage);
        garden.addExit("Hallway", hallway);
        garden.addExit("Closet", gardenCloset);
        gardenCloset.addExit("Garden", garden);
        driveway.addExit("Hallway", hallway);
        driveway.addExit("Closet", drivewayCloset);
        drivewayCloset.addExit("Driveway", driveway);
        frontYard.addExit("Hallway", hallway);
        frontYard.addExit("Closet", frontYardCloset);
        frontYardCloset.addExit("Front_Yard", frontYard);
        backYard.addExit("Hallway", hallway);
        backYard.addExit("Closet", backYardCloset);
        backYardCloset.addExit("Back_Yard", backYard);
        shed.addExit("Back_Yard", backYard);
        shed.addExit("Closet", shedCloset);
        shedCloset.addExit("Shed", shed);
        pool.addExit("Back_Yard", backYard);
        pool.addExit("Closet", poolCloset);
        poolCloset.addExit("Pool", pool);
        patio.addExit("Back_Yard", backYard);
        patio.addExit("Closet", patioCloset);
        patioCloset.addExit("Patio", patio);
        deck.addExit("Back_Yard", backYard);
        deck.addExit("Closet", deckCloset);
        deckCloset.addExit("Deck", deck);
        porch.addExit("Front_Yard", frontYard);
        porch.addExit("Closet", porchCloset);
        porchCloset.addExit("Porch", porch);
        balcony.addExit("Front_Yard", frontYard);
        balcony.addExit("Closet", balconyCloset);
        balconyCloset.addExit("Balcony", balcony);
        roof.addExit("Front_Yard", frontYard);
        roof.addExit("Closet", roofCloset);
        roofCloset.addExit("Roof", roof);
        roof.addExit("Stairs", stairs);
        roof.addExit("Hallway", hallway);
        hallwayCloset.addExit("Hallway", hallway);
        }   
    public void buildCommands(){
        commands.put("move", () -> move("move"));
        commands.put("look", () -> look(player.room.getDescription()));  
        commands.put("quit", () -> System.exit(0));
        commands.put("help", () -> listCommands());
        commands.put("stuff", () -> printToJTextArea(player.getInventory().toString()));
        commands.put("take", () -> player.takeItem(cmd));
        commands.put("drop", () -> player.dropItem(cmd));
        commands.put("use", () -> player.useItem(cmd));
        commands.put("open", () -> openItem(cmd));
        commands.put("close", () -> closeItem(cmd));
        commands.put("save", () -> saveGame());
        commands.put("load", () -> loadGame());

    }

    public void listCommands() {
        StringBuilder borderedOutput = new StringBuilder();
        int i =1;
        borderedOutput.append("**************************\n");
        for (String command : commands.keySet()) {

            if(i%3==0) {
                borderedOutput.append("* ").append(command.toUpperCase()).append("\n");
                i++;
            } else {
                borderedOutput.append("* ").append(command.toUpperCase()).append("\t");
                i++;
            }

        }

        borderedOutput.append("**************************\n");
        printToJTextArea(borderedOutput.toString());
    }

        public void startGame() {
            GUI gui = new GUI(this);
            gui.setVisible(true);
            buildRooms();
            buildCommands();
            listCommands();
            printToJTextArea(readFile("intro.txt"));
            printToJTextArea("Welcome to the game!"+ "\n");
            printToJTextArea("You are in the nursery. You can move to the hallway."+ "\n");
            printToJTextArea("Type 'help' for a list of commands."+ "\n");
        }
        public void setjTextArea(JTextArea jTextArea2) {
            Game.jTextArea = jTextArea2;
        }
    
    public String getRoomByName(String selectedRoom) {
        for (Room room : rooms) {
            if (room.getName().equals(selectedRoom)) {
                return room.getName();
            }
        }
        return null;
    }

    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void generateItems(){
    Item uniformtop = new Item("Uniform Top", "A bague polo style top with a logo on the front of a happy beaver, This top is a status symbol for the residents of the BusyBeavers Home For Wayward Rejuves.", "Clothing");
    Item uniformbottom = new Item("Uniform Bottom", "A pair of khaki pants with a logo on the back pocket of a happy beaver, These bottoms are switch between a skirt and shorts with a large velcro strip along the inseem.", "Clothing");
    Item uniformshoes = new Item("Uniform Shoes", "A pair of black shoes with a logo on the side of a happy beaver, These shoes are a status symbol for the residents of the BusyBeavers Home For Wayward Rejuves.", "Clothing");
        Item schoolbag = new Item("School Bag", "A large bag with a logo on the front of a happy beaver, This bag is a status symbol for the residents of the BusyBeavers Home For Wayward Rejuves.", "Bag");
        Item lunchbox = new Item("Lunch Box", "A small box with a logo on the front of a happy beaver, This box is a status symbol for the residents of the BusyBeavers Home For Wayward Rejuves.", "Box");
        Item waterbottle = new Item("Water Bottle", "A bottle with a logo on the front of a happy beaver, This bottle is a status symbol for the residents of the BusyBeavers Home For Wayward Rejuves.", "Bottle");
        Item pencilcase = new Item("Pencil Case", "A case with a logo on the front of a happy beaver, This case is a status symbol for the residents of the BusyBeavers Home For Wayward Rejuves.", "Case");
        Item diaper = new Item("Diaper", "A plain white diaper, this diaper is avalible in all sizes. In the dorms or changing rooms throughout the BusyBeavers Home For Wayward Rejuves you can find a diaper changing station with a variety of sizes.", "Clothing");
        Item plasticknife = new Item("Plastic Knife", "A plastic knife, this knife is used for cutting food in the cafeteria. The knife is avalible in the cafeteria.", "tool"); 
        Item rubberspoon = new Item("Rubber Spoon", "A rubber spoon, this spoon is used for eating food in the cafeteria. The spoon is avalible in the cafeteria.", "tool");
        Item schoolbook = new Item("A guide for the newly rejuvenated", "A book containig advice for those who are in their first cycle.", "Book");
        Item schoolbook2 = new Item("Stroies from under the bus", "A book containig stories from the residents of the BusyBeavers Home For Wayward Rejuves.", "Book"); 
        Item schoolbook3 = new Item("Welcome to BusyBeavers!", "A book containig the history of the BusyBeavers Home For Wayward Rejuves.", "Book");
        Item shinyPenny = new Item("Shiny Penny", "A shiny penny, this penny is used for making wishes in the fountain. The penny is a reward given for good behaviour", "money");
        Item goldstar = new Item("Gold Star", "A gold star, The star is a reward given for small acts of kindness or good behaviour", "money");
        Item trash = new Item("Trash", "A bit of trash, it is generated when you make a mess. You can throw it away in the trash can.", "trash");
        Item trashcan = new Item("Trash Can", "A trash can, this can is used for throwing away trash. The trash can is avalible in the cafeteria.", "trash");
        Item crayons = new Item("Crayons", "A box of crayons, this box is used for drawing in the art room. The crayons are avalible in the art room.", "tool");
        Item coloringbook = new Item("Coloring Book", "A coloring book, this book is used for drawing in the art room. The book is avalible in the art room.", "Book");
        Item toytrain = new Item("Toy Train", "A toy train, this train is used for playing in the playroom. The train is avalible in the playroom.", "toy");
        Item doll = new Item("Doll", "A doll, this doll is used for playing in the playroom. The doll is avalible in the playroom.", "toy");
        Item puzzle = new Item("Puzzle", "A puzzle, this puzzle is used for playing in the playroom. The puzzle is avalible in the playroom.", "toy");
        Item cleaningset = new Item("Cleaning Set", "A cleaning set, this set is used for cleaning in the dorms. The set is avalible in the dorms.", "tool");
        Item labreports = new Item("Lab Reports", " A stack of lab reposts, they are pretty dificult to read with all the acronyms and jargon. These reports belong to a research student.", "Book");
        Item labcoat = new Item("Lab Coat", "A lab coat, this coat is used for working in the lab. The coat is avalible in the lab.", "Clothing");

    nursery.getInventory().add(diaper);
    nursery.getInventory().add(schoolbag);
    nursery.getInventory().add(lunchbox);
    nursery.getInventory().add(waterbottle);
    nursery.getInventory().add(pencilcase);
    kitchen.getInventory().add(plasticknife);
    kitchen.getInventory().add(rubberspoon);
    kitchen.getInventory().add(trashcan);
    kitchen.getInventory().add(trash);
    livingRoom.getInventory().add(schoolbook);
    livingRoom.getInventory().add(schoolbook2);
    livingRoom.getInventory().add(schoolbook3);
    livingRoom.getInventory().add(shinyPenny);
    livingRoom.getInventory().add(goldstar);
    bedroom.getInventory().add(uniformtop);
    bedroom.getInventory().add(uniformbottom);
    bedroom.getInventory().add(uniformshoes);
    bathroom.getInventory().add(trashcan);
    bathroom.getInventory().add(trash);
    hallway.getInventory().add(trashcan);
    hallway.getInventory().add(trash);
    stairs.getInventory().add(trashcan);
    stairs.getInventory().add(trash);
    basement.getInventory().add(trashcan);
    basement.getInventory().add(trash);
    attic.getInventory().add(trashcan);
    attic.getInventory().add(trash);
    garage.getInventory().add(trashcan);
    garage.getInventory().add(trash);
    garden.getInventory().add(trashcan);
    garden.getInventory().add(trash);
    driveway.getInventory().add(trashcan);
    driveway.getInventory().add(trash);
    frontYard.getInventory().add(trashcan);
    frontYard.getInventory().add(trash);
    backYard.getInventory().add(trashcan);
    backYard.getInventory().add(trash);
    shed.getInventory().add(trashcan);
    shed.getInventory().add(trash);
    pool.getInventory().add(trashcan);
    pool.getInventory().add(trash);
    patio.getInventory().add(trashcan);
    patio.getInventory().add(trash);
    deck.getInventory().add(trashcan);
    deck.getInventory().add(trash);
    porch.getInventory().add(trashcan);
    porch.getInventory().add(trash);
    balcony.getInventory().add(trashcan);
    balcony.getInventory().add(trash);
    roof.getInventory().add(trashcan);
    roof.getInventory().add(trash);
    roof.getInventory().add(labreports);
    roof.getInventory().add(labcoat);
    livingRoom.getInventory().add(crayons);
    livingRoom.getInventory().add(coloringbook);
    livingRoom.getInventory().add(toytrain);
    livingRoom.getInventory().add(doll);
    livingRoom.getInventory().add(puzzle);
    livingRoom.getInventory().add(cleaningset);
}

    protected void loadGame() {
        try{
            FileReader fileReader = new FileReader(player.getName().concat(".txt"));
            fileReader.close();
        } catch (IOException e) {
            printToJTextArea("Error loading game.");
        }
        }

    protected void saveGame() {
try (FileWriter fileWriter = new FileWriter(player.getName().concat(".txt"))) {
    fileWriter.write(player.getName());
    fileWriter.write(player.room.getName());
    fileWriter.write(player.getPerks().toString());
    fileWriter.write(player.getExperience());
    fileWriter.write(player.getDescription());

    fileWriter.close();
} catch (IOException e) {
    e.printStackTrace();
}
    }

    protected void closeItem(String itemName) {
        if(player.getInventory().stream().anyMatch(item -> item.getName().equals(itemName))) {
            printToJTextArea("You close the " + itemName);
        } else {
            printToJTextArea("You do not have a " + itemName);
            printToJTextArea("you look around and see a " + itemName);
            if(getItemByName(itemName) != null && player.room.getInventory().contains(getItemByName(itemName))) {
    
                player.getInventory().add(getItemByName(itemName));
                player.room.getInventory().remove(getItemByName(itemName));
                printToJTextArea("You take the " + itemName);
                closeItem(itemName);
                player.dropItem(itemName);
            }
        }
    }

    protected void openItem(String itemName) {
        if(player.getInventory().stream().anyMatch(item -> item.getName().equals(itemName))) {
            printToJTextArea("You open the " + itemName);
        } else {
            printToJTextArea("You do not have a " + itemName);
            printToJTextArea("you look around and see a " + itemName);
            if(getItemByName(itemName) != null && player.room.getInventory().contains(getItemByName(itemName))) {
    
                player.getInventory().add(getItemByName(itemName));
                player.room.getInventory().remove(getItemByName(itemName));
                printToJTextArea("You take the " + itemName);
                openItem(itemName);
                player.dropItem(itemName);
            }
        }
    }

    @SuppressWarnings("unused")
    static String readFile(String fileName) {
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
        fileWriter.write("Description: " + this.desc + "\n");
        fileWriter.write("Optional: " + this.optional+"\n");
    } catch (IOException e) {
        System.out.println("Something done sploded :( " + fileName);
        e.printStackTrace();
    }
    }
   }

    private void look(String description) {
        if (description == null) {
            printToJTextArea("There is nothing to see here.");
        } else {
            printToJTextArea(player.room.getDescription());
        }
    }

    private Item getItemByName(String itemName) {
        for (Item item : player.room.getInventory()) {
            if (item.getName().equals(itemName)) {
                return item;
            }else if(player.room.getInventory().contains(item)) {
                return item;
            }else printToJTextArea(itemName + " is not in this room.");
        }
        return null;
    }

    private void printToJTextArea(String message) {
        GUI.getjTextArea().append(message);
    }



}
