import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ExplorerSwitch {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExplorerSwitch::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("explorerSwitch");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.getContentPane().setBackground(java.awt.Color.BLUE);

        JButton startButton = new JButton("START");
        startButton.setBounds(60, 20, 160, 80);

        startButton.setBackground(java.awt.Color.BLUE);
        startButton.setForeground(java.awt.Color.WHITE);
        startButton.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 15));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand("explorer.exe");
            }
        });

        JButton killButton = new JButton("KILL");

        killButton.setBounds(60, 120, 160, 80);
        killButton.setBackground(java.awt.Color.RED);
        killButton.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 15));

        killButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand("taskkill /f /im explorer.exe");
            }
        });

        frame.add(startButton);
        frame.add(killButton);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }

    private static void executeCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error executing command: " + ex.getMessage());
        }
    }
}
