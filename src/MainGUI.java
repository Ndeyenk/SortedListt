import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    private SortedList sortedList = new SortedList();

    private JTextField inputField = new JTextField(20);
    private JButton addButton = new JButton("Add");
    private JButton searchButton = new JButton("Search");
    private JTextArea displayArea = new JTextArea(15, 40);

    public MainGUI() {
        super("Sorted List - Lab 10");
        displayArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> handleAdd());
        searchButton.addActionListener(e -> handleSearch());
        inputField.addActionListener(e -> handleAdd());

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void handleAdd() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;
        int idx = sortedList.add(text);
        displayArea.append("Added"+ text + "at index" + idx + "\n");
        displayArea.append(sortedList.toString() + "\n");
        inputField.setText("");
    }

    private void handleSearch() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;
        displayArea.append(sortedList.search(text) + "\n\n");
        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI());
    }
}
