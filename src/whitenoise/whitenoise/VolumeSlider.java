package whitenoise;

import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class VolumeSlider extends JSlider{


    public VolumeSlider(WhiteNoiseApp noiseApp) {
        super(0, 100, 50);

        setOrientation(SwingConstants.HORIZONTAL);
        setMajorTickSpacing(10);
        setPaintTicks(true);
        setPaintLabels(true);

        addChangeListener(e -> {
            int volume = getValue();
            noiseApp.setVolume(volume);
        });
    }
    
}