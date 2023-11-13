import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame mainFrame = new JFrame("Text Editor Application");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Create instance of TextEditorPanel
        TextEditorPanel textEditorPanel = new TextEditorPanel();


        // Create the action panel
        JPanel actionPanel = new JPanel();
        actionPanel.setPreferredSize(new Dimension(200, 400));

        // Create the marked text list panel
        JPanel markedTextListPanel = new JPanel();
        markedTextListPanel.setPreferredSize(new Dimension(600,200));

        // Split the main area and the marked text list
        JSplitPane splitPaneVertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textEditorPanel, markedTextListPanel);
        splitPaneVertical.setResizeWeight(0.8);

        // Add components to the main frame
        mainFrame.add(splitPaneVertical, BorderLayout.CENTER);
        mainFrame.add(actionPanel, BorderLayout.EAST);

        // Pack the components and set the visibility of the window to true
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Build the file menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Add menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners for menu items
        newItem.addActionListener(e -> LOGGER.log(Level.INFO, "New File"));
        openItem.addActionListener(e -> LOGGER.log(Level.INFO, "Open File"));
        saveItem.addActionListener(e -> LOGGER.log(Level.INFO, "Save File"));
        exitItem.addActionListener(e -> mainFrame.dispose());

        // Add items to the File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Add menu bar to the frame
        mainFrame.setJMenuBar(menuBar);
    }

}
