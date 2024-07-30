package jackal.face;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Set;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class GUI extends JFrame {
    private Player player;
    private static JTextArea jTextArea;
    private JTextField jTextFeild;
    private JPanel btnPanel;
    private JPanel inputPanel;
    private Game game;
    private JButton inventoryButton, dialogButton, moveButton, inspectButton;
    private JPanel statsPanel;
    private String[] roomChoices, npcChoices, itemChoices;
    private Color periwinkle;


    public GUI(Game game) {
        periwinkle = new Color(204, 204, 255);
        this.game = game;
        this.player = game.getPlayer();
        roomChoices = new String[]{"Room1", "Room2", "Room3"};
        npcChoices = new String[]{"NPC1", "NPC2", "NPC3"};
        itemChoices = new String[]{"Item1", "Item2", "Item3"};
        
        // Set up JFrame
        setTitle("Busy Beavers by Jackal Face"); 
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statsPanel = new JPanel();
        statsPanel.setBackground(periwinkle);
        statsPanel.setPreferredSize(new Dimension(1200, 35));
        ((JPanel) statsPanel).setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel statsLabel = new JLabel();
        statsLabel.setText(updateStatus());
        statsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statsLabel.setForeground(Color.BLACK);
        statsPanel.add(statsLabel);
        add(statsPanel, BorderLayout.NORTH);

        // Initialize txtPanal
        inputPanel = new JPanel();
        inputPanel.setBackground(periwinkle);
        
        btnPanel = new JPanel();
        btnPanel.setBackground(periwinkle);
        add(btnPanel, BorderLayout.SOUTH);

        inputPanel = new JPanel();
        btnPanel.add(inputPanel);

        jTextArea = new JTextArea(30, 60);
        jTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        jTextArea.setBackground(Color.WHITE);
        jTextArea.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
    @Override
    protected void configureScrollBarColors() {
        this.thumbColor = Color.MAGENTA; 
        this.trackColor = Color.CYAN;
    }
});
        add(scrollPane, BorderLayout.CENTER);
        
        // Initialize jTextFeild
        jTextFeild = new JTextField(20);
        jTextFeild.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create buttons
        moveButton = new JButton("Move");
        moveButton.setFont(new Font("Arial", Font.BOLD, 16));
        dialogButton = new JButton("Dialog");
        dialogButton.setFont(new Font("Arial", Font.BOLD, 16));
        inspectButton = new JButton("Inspect");
        inspectButton.setFont(new Font("Arial", Font.BOLD, 16));
        inventoryButton = new JButton("Inventory");
        inventoryButton.setFont(new Font("Arial", Font.BOLD, 16));

        Dimension buttonSize = new Dimension(150, 50);
        moveButton.setPreferredSize(buttonSize);
        dialogButton.setPreferredSize(buttonSize);
        inspectButton.setPreferredSize(buttonSize);
        inventoryButton.setPreferredSize(buttonSize);

        // Add buttons to panel
        btnPanel.add(moveButton);
        btnPanel.add(dialogButton);
        btnPanel.add(jTextFeild);
        btnPanel.add(inspectButton);
        btnPanel.add(inventoryButton);


        getjTextArea().setLineWrap(true);
        getjTextArea().setWrapStyleWord(true);

// Add border to statsPanel
statsPanel.setBorder(new LineBorder(Color.BLACK, 2));

// Add border to inputPanel
inputPanel.setBorder(new LineBorder(Color.BLACK, 2));




// Add border to jTextArea
jTextArea.setBorder(new LineBorder(Color.BLACK, 2));

// Add border to jTextFeild
jTextFeild.setBorder(new LineBorder(Color.BLACK, 2));

// Add border to buttons
moveButton.setBorder(new LineBorder(Color.BLACK, 2));
dialogButton.setBorder(new LineBorder(Color.BLACK, 2));
inspectButton.setBorder(new LineBorder(Color.BLACK, 2));
inventoryButton.setBorder(new LineBorder(Color.BLACK, 2));


moveButton.addActionListener(new ActionListener() {
            private boolean moveSuccessful = false;
            

            @Override
            public void actionPerformed(ActionEvent e) {
                Room currentRoom = player.getRoom();
                String[] exits = currentRoom.getExits();
                System.out.println("Available exits: " + Arrays.toString(exits));
                
                String selectedExit = (String) JOptionPane.showInputDialog(
                    null, 
                    "Choose an exit:", 
                    "Available Exits", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    exits, 
                    exits[0]
                );
                
                if (selectedExit != null) {
                    // Handle the selected exit
                    System.out.println("Selected exit: " + selectedExit);
                    game.move(selectedExit);
                    moveSuccessful = true;
                    if (!moveSuccessful) {
                        System.out.println("There is no exit in that direction.");
                    }
                }
        }
        });

        dialogButton.addActionListener(e -> {
            String selectedNPC = (String) JOptionPane.showInputDialog(this, "Choose an NPC:", "Dialog", JOptionPane.QUESTION_MESSAGE, null, new String[]{"NPC1", "NPC2", "NPC3"}, "NPC1");
            if (selectedNPC != null) {
                game.player.dialog(selectedNPC);
                printToJTextArea(jTextArea, "Dialog with " + selectedNPC);
            }
        });

        inspectButton.addActionListener(e -> {
            String selectedItem = (String) JOptionPane.showInputDialog(this, "Choose an item:", "Inspect", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Item1", "Item2", "Item3"}, "Item1");
            if (selectedItem != null) {
                game.player.inspect(selectedItem);
                printToJTextArea(jTextArea, "Inspected " + selectedItem);
            }
        });

        inventoryButton.addActionListener(e -> {
            String selectedItem = (String) JOptionPane.showInputDialog(this, "Choose an item:", "Inventory", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Item1", "Item2", "Item3"}, "Item1");
            if (selectedItem != null) {
                game.player.inventory(selectedItem);
                printToJTextArea(jTextArea, "Inventory action with " + selectedItem);
            }
        });

        jTextFeild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = jTextFeild.getText();
                if (!command.trim().isEmpty()) {
                    game.executeCommand(command);
                    printToJTextArea(jTextArea, "Command executed: " + command);
                    jTextFeild.setText(""); // Clear the text field after executing the command
                }
            }
        });

        this.setVisible(true);
        this.game = game;
    }

    public String[] getItemChoices() {
        return itemChoices;
    }
    public String updateStatus(){
      return "Player: " + player.getName() + " | Money: " + game.player.getMoney() + " | Experience: " + game.player.getExperience();
    }
    public void setItemChoices(String[] itemChoices) {
        this.itemChoices = itemChoices;
    }

    public String[] getNpcChoices() {
        return npcChoices;
    }

    public void setNpcChoices(String[] npcChoices) {
        this.npcChoices = npcChoices;
    }

    public String[] getRoomChoices() {
        return roomChoices;
    }

    public void setRoomChoices(String[] roomChoices) {
        this.roomChoices = roomChoices;
    }

    public JTextField getjTextFeild() {
        return jTextFeild;
    }

    public void setjTextFeild(JTextField jTextFeild) {
        this.jTextFeild = jTextFeild;
    }
    private void printToJTextArea(JTextArea jTextArea2, String message) {
        GUI.jTextArea.append("\n" + message + "\n");
    }
    public static JTextArea getjTextArea() {
        return jTextArea;
    }
}