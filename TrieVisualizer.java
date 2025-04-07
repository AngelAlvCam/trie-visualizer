import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.mxgraph.swing.mxGraphComponent;

import trie.Trie;

public class TrieVisualizer {

    public static void main(String[] args) {
        // Setup Trie
        Trie myTrie = new Trie();

        // Setup the GUI
        JFrame frame = new JFrame("Trie Visualizer");

        // Status panel
        JPanel statusPanel = new JPanel();   
        JLabel statusLabel = new JLabel("Status: ...");
        statusPanel.add(statusLabel);

        // User input panel
        JPanel inputPanel = new JPanel();

        JTextField wordField = new JTextField(20);
        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(e -> {
            String userWord = wordField.getText();
            statusLabel.setText("Status [Insert]: " + myTrie.insert(userWord));
        });

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            String userWord = wordField.getText();
            statusLabel.setText("Status [Search]: " + myTrie.search(userWord));
        });

        JButton startsWithButton = new JButton("Starts With...");
        startsWithButton.addActionListener(e -> {
            String userWord = wordField.getText();
            statusLabel.setText("Status [Starts With...]: " + myTrie.startsWith(userWord));
        });
        inputPanel.add(wordField);
        inputPanel.add(insertButton);
        inputPanel.add(searchButton);
        inputPanel.add(startsWithButton);

        // Attach input panel and status panel to the bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.NORTH);
        bottomPanel.add(statusPanel, BorderLayout.SOUTH);

        // Add graphics to a component
		mxGraphComponent graphComponent = new mxGraphComponent(myTrie.getGraph());
        graphComponent.setZoomPolicy(mxGraphComponent.ZOOM_POLICY_WIDTH);

        // Attach everything to the frame
        frame.add(graphComponent);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}