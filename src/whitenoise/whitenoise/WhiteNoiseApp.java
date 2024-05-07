package whitenoise;

import javax.sound.sampled.*;
import java.util.Random;

public class WhiteNoiseApp {
    private AudioFormat format = new AudioFormat(44100, 16, 1, true, false); // setting up audio format
    private SourceDataLine line = null;
    private boolean isPlaying = false;
    private Thread noiseThread;
    private Random random = new Random();

    public synchronized void startNoise() {
        if (isPlaying) return;
        isPlaying = true;
        noiseThread = new Thread(() -> {
            try {
                line = AudioSystem.getSourceDataLine(format);
                line.open(format);
                line.start();

                byte[] buffer = new byte[2];
                while(isPlaying) {
                    int value = random.nextInt(65536) - 32768; // Generates a random int between -32768 and 327667
                    buffer[0] = (byte) (value & 0xFF);
                    buffer[1] = (byte) ((value >> 8) & 0xFF);
                    line.write(buffer, 0, 2);
                }
                line.drain();
                line.close();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        });
        noiseThread.start();
    }

    public synchronized void stopNoise() {
        if (!isPlaying) return;
        isPlaying = false;
        try {
            noiseThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void setVolume(int volume) {
        // Calculate the gain based on the volume slider value
        float gain = volume / 100.0f;

        // Retrieve the control from the SourceDataLine and set the gain
        if (line != null && line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
            // Calculate the value for the gain control based on the linear scale
            float gainValue = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(gainValue);
            
        }
    }

    public static class BrownNoiseGenerator {
        public static byte[] generateBrownNoise(int duration, int sampleRate) {
            int numSamples = duration * sampleRate;
            byte[] brownNoise = new byte[numSamples];

            double lastValue = 0;
            for (int i = 0; i < numSamples; i++) {
                double whiteNoise = Math.random() * 2 - 1;
                lastValue += whiteNoise;
                brownNoise[i] = (byte) (lastValue / Math.sqrt(sampleRate));
            }

            return brownNoise;
        }

        public static void playAudio(byte[] audioData, int sampleRate) {
            try {
                AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, true);
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();
                line.write(audioData, 0, audioData.length);
                line.drain();
                line.close();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }
}