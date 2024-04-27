package whitenoise;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.*;

public class WhiteNoiseAppGUI {
    
    private static void createAndShowGUI() {
        WhiteNoiseApp noiseApp = new WhiteNoiseApp(); // Instantiate the White noise app        
        
        
        // JFrame & BorderLayout()
        JFrame frame =  new JFrame("Focus Audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);  // default size of application
        frame.setLayout(new BorderLayout(0,0)); // CAN ADD A GAP BETWEEN PANELS HERE LATER IF I WANT
        //-----------------------------------------------------------------//
        // Toolbar & Background Panels 
        ToolBar toolbarPanel = new ToolBar(noiseApp); // instantiate toolbar
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        // JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();


        leftPanel.setPreferredSize(new Dimension(350,100));
        

        rightPanel.setPreferredSize(new Dimension(0,0));
        // topPanel.setPreferredSize(new Dimension(0,100));
        centerPanel.setPreferredSize(new Dimension(100,100));
        
        toolbarPanel.setBackground(Color.WHITE);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBackground(Color.WHITE);
        // topPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setBackground(Color.WHITE);


        frame.add(toolbarPanel, BorderLayout.SOUTH); // ADD TOOLBAR BUT MAYBE ME WE DO A PANEL HERE INSTEAD POTENTIALLY
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        // frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        

        
        
        
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        JPanel whiteNoisePanel = new JPanel();
        whiteNoisePanel.setPreferredSize(new Dimension(200,200));
        whiteNoisePanel.setBackground(Color.ORANGE);

        JPanel brownNoisePanel = new JPanel();
        brownNoisePanel.setPreferredSize(new Dimension(200,200));
        brownNoisePanel.setBackground(Color.GREEN);

        
        JPanel natureSoundsPanel = new JPanel();
        natureSoundsPanel.setPreferredSize(new Dimension(200, 200));
        natureSoundsPanel.setBackground(Color.BLUE);


        JPanel rssFeedPanel = new JPanel();
        rssFeedPanel.setPreferredSize(new Dimension(200,200));
        rssFeedPanel.setBackground(Color.MAGENTA);

        leftPanel.add(whiteNoisePanel);
        leftPanel.add(brownNoisePanel);
        leftPanel.add(natureSoundsPanel);
        leftPanel.add(rssFeedPanel);

        Dimension buttonDimension = new Dimension(150,150);

        whiteNoisePanel.setLayout(new BorderLayout());
        JButton whiteNoiseButton = new JButton("White Noise");
        whiteNoiseButton.setPreferredSize(buttonDimension);
        whiteNoiseButton.setFocusable(false);
        whiteNoisePanel.add(whiteNoiseButton, BorderLayout.EAST);

        brownNoisePanel.setLayout(new BorderLayout());
        JButton brownNoiseButton = new JButton("Brown Noise");
        brownNoiseButton.setPreferredSize(buttonDimension);
        brownNoiseButton.setFocusable(false);
        brownNoisePanel.add(brownNoiseButton, BorderLayout.EAST);

        natureSoundsPanel.setLayout(new BorderLayout());
        JButton natureSoundsButton = new JButton("Nature Sounds");
        natureSoundsButton.setPreferredSize(buttonDimension);
        natureSoundsButton.setFocusable(false);
        natureSoundsPanel.add(natureSoundsButton, BorderLayout.EAST);

        rssFeedPanel.setLayout(new BorderLayout());
        JButton rssFeedButton = new JButton("RSS Feed");
        rssFeedButton.setPreferredSize(buttonDimension);
        rssFeedButton.setFocusable(false);
        rssFeedPanel.add(rssFeedButton, BorderLayout.EAST);

        whiteNoisePanel.setVisible(true);
        leftPanel.setVisible(true);
        frame.setVisible(true);
    }

    // ------------------------------------------------------------//
    public static void main(String[] args) {
        // Esnrue the GUI Construction is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
