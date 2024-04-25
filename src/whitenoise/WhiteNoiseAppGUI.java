package whitenoise;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class WhiteNoiseAppGUI {
    
    private static void createAndShowGUI() {
        WhiteNoiseApp noiseApp = new WhiteNoiseApp(); // Instantiate the White noise app        
        
        
        // JFrame & BorderLayout()
        JFrame frame =  new JFrame("White Noise Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);  // default size of application
        frame.setLayout(new BorderLayout(10,10)); // CAN ADD A GAP BETWEEN PANELS HERE LATER IF I WANT
        //-----------------------------------------------------------------//
        // Toolbar & Panels 
        ToolBar toolbarPanel = new ToolBar(noiseApp); // instantiate toolbar
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        leftPanel.setPreferredSize(new Dimension(50,100));
        rightPanel.setPreferredSize(new Dimension(50,100));
        topPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setPreferredSize(new Dimension(100,100));
        
        toolbarPanel.setBackground(Color.WHITE);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setBackground(Color.LIGHT_GRAY);


        frame.add(toolbarPanel, BorderLayout.SOUTH); // ADD TOOLBAR BUT MAYBE ME WE DO A PANEL HERE INSTEAD POTENTIALLY
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        

        
        frame.setVisible(true);
    }

    // ------------------------------------------------------------//
    public static void main(String[] args) {
        // Esnrue the GUI Construction is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
