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
        // frame.setSize(420, 420); // Set the size of the window

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
        frame.add(button, BorderLayout.NORTH); // add button to bottom of the frame
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
        // frame.getContentPane().setBackground(Color.pink); // Eventually change the background color.

        // Create a volume slider
        JSlider volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setOrientation(SwingConstants.HORIZONTAL);
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        // Listen to hnadle volume changes
        volumeSlider.addChangeListener(e -> {
            int volume = volumeSlider.getValue();
            noiseApp.setVolume(volume);
        });

        // Add the volume slider to center of the frame
        frame.add(volumeSlider, BorderLayout.SOUTH);
        frame.setSize(420, 420); // Adjusts the window to fit the preferred size and layouts of it's subcomponents
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Esnrue the GUI Construction is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
