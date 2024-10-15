package eu.pmav.pxp0p;

import eu.pmav.pxp0p.configuration.DevelopmentCombinatorGenerator;
import eu.pmav.pxp0p.app.model.Configuration;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import eu.pmav.pxp0p.app.Frame;
import eu.pmav.pxp0p.configuration.RandomGenerator;
import processing.core.PApplet;

public class Main extends PApplet
{
    // Canvas size
    final int CANVAS_WIDTH = 1080;
    final int CANVAS_HEIGHT = 1080;

    // Path to save each frame
    final String SAVE_PATH = "/home/pmav/Dropbox/pxp0p/";

    // Main class to load the program
    static final String MAIN_CLASS = "eu.pmav.pxp0p.Main";

    public static void main(String[] passedArgs)
    {
        PApplet.main(new String[]{MAIN_CLASS});
    }

    public void settings()
    {
        size(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    public void setup()
    {
        noLoop();
    }

    public void draw()
    {
        try
        {
            // List<Configuration> configurations = InstagramConfigurationGenerator.generateConfigurations();
            // List<Configuration> configurations = DevelopmentCombinatorGenerator.generateConfigurations();
            List<Configuration> configurations = new RandomGenerator().generateConfigurations(10);

            AtomicInteger  frameNumber = new AtomicInteger(1);

            configurations.forEach(configuration -> {
                Frame frame = new Frame(this, configuration);
                frame.render();

                saveImage(frameNumber.getAndIncrement());
            });

            exit();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void saveImage(int count)
    {
        String currentTimestamp =
            nf(year(), 4) +
                nf(month(), 2) +
                nf(day(), 2) +
                nf(hour(), 2) +
                nf(minute(), 2) +
                nf(second(), 2);

        save(String.format("%s/%s_%d.png", SAVE_PATH, currentTimestamp, count));
    }
}
