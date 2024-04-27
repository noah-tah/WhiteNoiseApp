package whitenoise;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar implements ActionListener, ChangeListener {
    private  WhiteNoiseApp noiseApp;
    private  JButton startStopButton;

    public ToolBar(WhiteNoiseApp noiseApp) {
        this.noiseApp = noiseApp;
    
        JButton startStopButton = new JButton("Start"); // Corrected the syntax here
        startStopButton.addActionListener(this);

        VolumeSlider volumeSlider = new VolumeSlider(noiseApp);

        add(startStopButton);
        addSeparator();
        add(volumeSlider);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start")) {
            noiseApp.startNoise();
            ((JButton) e.getSource()).setText("Stop");
        } else {
            noiseApp.stopNoise();
            ((JButton) e.getSource()).setText("Start");
        }
    }
    public void actionPerformed() {
        if (startStopButton.getText().equals("Start")) { // Corrected the method name here
            noiseApp.startNoise();
            startStopButton.setText("Stop");
        } else {
            noiseApp.stopNoise();
            startStopButton.setText("Start");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Empty implementation
    }
}
