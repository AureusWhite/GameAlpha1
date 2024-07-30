package jackal.face;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Item {
    String name;
    String description;
    private String type;
    private String optional;

    public Item(String name, String description, String type) {
        createItemFile();
        this.name = name;
        this.description = description;
        this.type = type;
        
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String playedWith() {
        if(this.type.equalsIgnoreCase("toy")) {
            return "You played with the " + this.name;
        }else{
            return "You can't play with the " + this.name;
        }
        
    }

    public void use() {
        if(this.type.equalsIgnoreCase("tool")) {
            System.out.println("You used the " + this.name);
        }else{
            System.out.println("You can't use the " + this.name);
        }
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

}
