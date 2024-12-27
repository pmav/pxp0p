package eu.pmav.pxp0p;

import eu.pmav.pxp0p.frameconfiguration.impl.*;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.utils.ExitHandler;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main
{
    // Path to save each frame
    // TODO: read from command line
    static final String SAVE_PATH = "/Users/pedro/Workspace/pxp0p/tmp";
    //static final String SAVE_PATH = "/mnt/Storage/pxp0p/";


    public static void main(String[] args) throws Exception
    {
        // Create directory to save frames
        final String saveDirectory = String.format("%s/%s", SAVE_PATH, Utils.getTimestampID());
        Utils.createDirectory(saveDirectory);

        // Create exit handler
        ExitHandler exitHandler = new ExitHandler();

        // Create frame configurations
        List<FrameConfiguration> frameConfigurations = new ArrayList<>();

        //configurations.addAll((new CuidadoComOCaoManualGenerator()).generateConfigurations());
        //configurations.addAll((new InstagramManualGenerator()).generateConfigurations());
        //configurations.addAll((new DevelopmentManualGenerator()).generateConfigurations());
        //configurations.addAll((new OlympicsManualGenerator()).generateConfigurations());
        //configurations.addAll((new RandomGenerator(1)).generateConfigurations(5));
        //configurations.addAll((new RandomGenerator(2)).generateConfigurations(5));

        frameConfigurations.addAll((new NewFrameConfigurationGenerator()).generateConfigurations());

        // Render each frame on a new Applet
        AtomicInteger frameNumber = new AtomicInteger(1);

        frameConfigurations.forEach(frameConfiguration ->
        {
            // Add frame path
            final String framePath = String.format("%s/%d.png", saveDirectory, frameNumber.getAndIncrement());
            frameConfiguration.setFramePath(framePath);

            // Create Applet
            Applet applet = new Applet(frameConfiguration, exitHandler);

            // Register applet
            exitHandler.registerApplet(applet);

            // Run Applet
            PApplet.runSketch(new String[]{applet.getClass().getName()}, applet);
        });
    }
}
