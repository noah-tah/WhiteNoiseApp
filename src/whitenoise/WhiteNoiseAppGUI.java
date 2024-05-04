package whitenoise;

import javax.swing.JPanel;
import javax.accessibility.Accessible;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.*;

public class WhiteNoiseAppGUI {
    
    private static void createAndShowGUI() {
        WhiteNoiseApp noiseApp = new WhiteNoiseApp(); // Instantiate the White noise app        
        JFrame frame = createFrame();
        JPanel leftPanel = createLeftPanel();
        JPanel centerPanel = createCenterPanel();
        ToolBar toolbarPanel = new ToolBar(noiseApp);


        frame.add(toolbarPanel, BorderLayout.SOUTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    
    private static JFrame createFrame() {
        JFrame frame =  new JFrame("Focus Audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700); 
        frame.setLayout(new BorderLayout(0,0));

        return frame;
    }

    private static JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(350,0));        
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(createButtonPanel("White Noise",Color.LIGHT_GRAY));
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(createButtonPanel("Brown Noise",Color.LIGHT_GRAY));
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(createButtonPanel("Nature Sounds",Color.LIGHT_GRAY));
        leftPanel.add(Box.createVerticalStrut(10));
        return leftPanel;
        
    }
    
    private static JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        JLabel welcomeTitle = new JLabel("Welcome to Focus Audio!"); //this is where
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(welcomeTitle);

        return centerPanel;

    }
    
    private static JPanel createButtonPanel(String buttonText, Color backgroundColor) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(350, 200));
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(340,200));
        button.setFocusable(false);

        //-------------------------//
        // button.setBorderPainted(false);
        // button.setContentAreaFilled(false);
        button.setBackground(backgroundColor);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(button, BorderLayout.WEST);

        return buttonPanel;

    }


    // ------------------------------------------------------------//
    public static void main(String[] args) {
        // Esnrue the GUI Construction is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}   