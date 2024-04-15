package whitenoise;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.*;

public class WhiteNoiseAppGUI {
    
    private static void createAndShowGUI() {
        // Create the main window (frame)
        JFrame frame =  new JFrame("White Noise Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // use BorderLayout to organize button and slider


        JButton button = new JButton("Start"); // button to start/stop white noise
        button.setPreferredSize(new Dimension(20, 20)); // the change added
        WhiteNoiseApp noiseApp = new WhiteNoiseApp(); // Instantiate the White noise app

        // button.addActionListener(e -> {
        //     if (button.getText().equals("Start")) {
        //         noiseApp.startNoise(); // Start the noise
        //         button.setText("Stop");
        //     } else {
        //         noiseApp.stopNoise(); // Stop the noise
        //         button.setText("Start");
        //     }
        // });
        // frame.add(button, BorderLayout.NORTH); // add button to bottom of the frame
        // frame.getContentPane().add(button);
        // frame.pack();
        // frame.setVisible(true);
        // frame.getContentPane().setBackground(Color.pink); // Eventually change the background color.

        VolumeSlider volumeSlider = new VolumeSlider(noiseApp);
        ToolBar toolbar = new ToolBar(noiseApp);
        frame.add(toolbar, BorderLayout.SOUTH);
        // Add the volume slider to center of the frame
        // frame.add(volumeSlider, BorderLayout.SOUTH);
        frame.setSize(420, 420); // Adjusts the window to fit the preferred size and layouts of it's subcomponents
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Esnrue the GUI Construction is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
