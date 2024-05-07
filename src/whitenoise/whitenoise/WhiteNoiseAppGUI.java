package whitenoise;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.accessibility.Accessible;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.ActionListener;

public class WhiteNoiseAppGUI {

    private static JButton[] buttons; // Declare an array to store the buttons!!!
    
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

    // TODO: Fix these fucking buttons
    // 
    //
    private static JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(350,0));        
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        buttons = new JButton[3]; // Initialize the array to hold the 3 buttons
        
        leftPanel.add(Box.createVerticalStrut(5));

        buttons[0] = (createButton("White Noise",Color.LIGHT_GRAY));  // Store to array
        leftPanel.add(createButtonPanel(buttons[0]));

        leftPanel.add(Box.createVerticalStrut(5));

        buttons[1] = (createButton("Brown Noise",Color.LIGHT_GRAY));  // Store to array
        leftPanel.add(createButtonPanel(buttons[1]));

        leftPanel.add(Box.createVerticalStrut(5));

        buttons[2] = (createButton("Nature Sounds",Color.LIGHT_GRAY)); // Store to array
        leftPanel.add(createButtonPanel(buttons[2]));

        leftPanel.add(Box.createVerticalStrut(5));

        return leftPanel;
        
    }

    /// RIGHT UP THERE ^^^^^^^^^
    
    private static JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);    
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));


        JLabel welcomeTitle = new JLabel("Welcome to Focus Audio!");
        welcomeTitle.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeTitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel introductionText = new JLabel("<html>In today's fast-paced world filled with distractions, maintaining focus and productivity can be a challenge. Introducing Focus Audio – your ultimate companion in enhancing concentration and productivity. Backed by scientific research, Focus Audio offers a unique blend of white noise, brown noise, and calming nature sounds meticulously crafted to optimize cognitive performance. Whether you're studying, working, or simply seeking a moment of tranquility in your day, Focus Audio provides the perfect auditory environment to help you stay on track and unlock your full potential. Say goodbye to distractions and hello to a more focused, productive you with Focus Audio.</html>");
        introductionText.setAlignmentX(Component.CENTER_ALIGNMENT);
        introductionText.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel developedBy = new JLabel("Developed by Noah Tah");
        developedBy.setAlignmentX(Component.RIGHT_ALIGNMENT);
        

        JPanel developedByPanel = new JPanel();
        developedByPanel.setLayout(new BoxLayout(developedByPanel, BoxLayout.X_AXIS));
        developedByPanel.setBackground(Color.WHITE);
        
        
        developedByPanel.add(developedBy);
        centerPanel.add(Box.createVerticalStrut(50)); 
        centerPanel.add(welcomeTitle);
        centerPanel.add(Box.createVerticalStrut(50));
        centerPanel.add(introductionText);
        centerPanel.add(Box.createVerticalStrut(280));
        centerPanel.add(developedByPanel, BorderLayout.EAST);

        return centerPanel;

    }

    private static JPanel createButtonPanel(JButton button) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(button, BorderLayout.WEST);
        buttonPanel.setPreferredSize(new Dimension(350, 200));

        return buttonPanel;

    }


    private static JButton createButton(String buttonText, Color backgroundColor) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(345,200));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setBackground(Color.LIGHT_GRAY);



        // I DONT KNOW HOW BUT YOUR  BUTTON ACTUALLY WORKS JIMMY NEUTRON
        // <(O.O)>
        //

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonText.equals("Brown Noise")) {
                    // byte[] brownNoise = WhiteNoiseApp.BrownNoiseGenerator.generateBrownNoise(10, 44100);
                    System.out.println("brown noise button pressed");
                } else if (buttonText.equals("White Noise")) {
                    System.out.println("White Noise Button Pressed");
                }  if (buttonText.equals("Nature Sounds")) {
                    System.out.println("Nature Sounds Button Pressed");
                }
            }
        });
        return button;
    }


    // ---------------------------------------------------     ---------//
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}