package whitenoise;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class WhiteNoiseAppGUI {
    
    private static void createAndShowGUI() {
        // Create the main window (frame)
        JFrame frame =  new JFrame("White Noise Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // Set the size of the window

        // Add a button to start/stop the white noise
        JButton button = new JButton("Start");
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

        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Esnrue the GUI Construction is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
