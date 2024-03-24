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
}