import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class TextEditorPanel extends JPanel {
    private JTextArea textArea;
    private JButton copyButton;

    public TextEditorPanel() {
        initializeComponents();
        layoutComponents();
        attachListeners();
    }

    private void initializeComponents() {
        textArea = new JTextArea();
        copyButton = new JButton("Copy");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(); // Buttons area

        topPanel.add(copyButton);
        add(topPanel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
    }

    private void attachListeners() {
        copyButton.addActionListener(e -> copyTextToClipboard());
    }

    private void copyTextToClipboard() {
        String textToCopy = textArea.getText();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                new StringSelection(textToCopy), null
        );
    }



}
