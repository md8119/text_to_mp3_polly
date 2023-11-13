import javax.swing.*;
import java.awt.BorderLayout;
public class MarkedTextListPanel extends JPanel {

    private JList<String> markedTextList;
    private DefaultListModel<String> listModel;

    public MarkedTextListPanel() {
        super(new BorderLayout()); // Set the layout in the constructor

        listModel = new DefaultListModel<>();
        markedTextList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(markedTextList);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    // Methods to manage marked texts
    public void addMarkedText(String text) {
        listModel.addElement(text);
    }

    public void removeMarkedText(String text) {
        listModel.removeElement(text);
    }

    // Additional utility methods can be added as needed
}
