package whitenoise;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;

public class WhiteNoiseAppGUI {
    
    private static void createAndShowGUI() {
        // Create the main window (frame)
        JFrame frame =  new JFrame("White Noise Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900); // Set the size of the window

        frame.setLayout(new BorderLayout()); // use BorderLayout to organize button and slider


        JButton button = new JButton("Start"); // button to start/stop white noise
        WhiteNoiseApp noiseApp = new WhiteNoiseApp(); // Instantiate the White noise app

        button.addActionListener(e -> {
            if (button.getText().equals("Start")) {
                noiseApp.startNoise(); // Start the noise
                button.setText("Stop");
            } else {
                noiseApp.stopNoise(); // Stop the noise
                button.setText("Start");
            }
        });
        frame.add(button, BorderLayout.SOUTH); // add button to bottom of the frame
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);

        // Create a volume slider
        JSlider volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setOrientation(SwingConstants.HORIZONTAL);
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        // Listen to hnadle volume changes
        volumeSlider.addChangeListener(e -> {
            int volume = volumeSlider.getValue();
            // You'll need to implement setVolume in your WhiteNoiseApp class
            //noiseApp.setVolume(volume)
        });

        // Add the volume slider to center of the frame
        frame.add(volumeSlider, BorderLayout.CENTER);

        frame.setSize(1600, 900); // Adjusts the window to fit the preferred size and layouts of it's subcomponents
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Esnrue the GUI Construction is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
