package eu.pmav.pxp0p;

import eu.pmav.pxp0p.frameconfiguration.impl.OlympicsFrameConfigurationGenerator;
import eu.pmav.pxp0p.frameconfiguration.impl.examples.semicircle.*;
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
    static final String SAVE_PATH = "./tmp";


    public static void main(String[] args) throws Exception
    {
        // Get initial timestamp
        final String initialTimestamp = Utils.getTimestampID();

        // Create exit handler
        ExitHandler exitHandler = new ExitHandler();

        // Create frame configurations
        List<FrameConfiguration> frameConfigurations = new ArrayList<>();

        frameConfigurations.addAll((new OlympicsFrameConfigurationGenerator()).generateConfigurations());

        //frameConfigurations.addAll((new CuidadoComOCaoManualGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new InstagramManualGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new DevelopmentManualGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new RandomGenerator(1)).generateConfigurations(5));
        //frameConfigurations.addAll((new RandomGenerator(2)).generateConfigurations(5));

        // Semi-circle
        //frameConfigurations.addAll((new SemiCircleWavesBlackAndWhiteFrameConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircleWatermelonFrameConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircleTestsFrameConfigurationGenerator()).generateConfigurations());

        // Examples

        // Square variations
        //frameConfigurations.addAll((new Square01ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square02ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square03ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square04ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square05ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square06ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square07ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square08ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Square09ConfigurationGenerator()).generateConfigurations());

        // Circle variations
        //frameConfigurations.addAll((new Circle01ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Circle02ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Circle03ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Circle04ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Circle05ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Circle06ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Circle07ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Circle08ConfigurationGenerator()).generateConfigurations());

        // Triangle variations
        //frameConfigurations.addAll((new Triangle01ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle02ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle03ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle04ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle05ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle06ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle07ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle08ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new Triangle09ConfigurationGenerator()).generateConfigurations());

        // Semi-circle variations
        //frameConfigurations.addAll((new SemiCircle01ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircle02ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircle03ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircle04ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircle05ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircle06ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircle07ConfigurationGenerator()).generateConfigurations());
        //frameConfigurations.addAll((new SemiCircle08ConfigurationGenerator()).generateConfigurations());

        // Render each frame on a new Applet
        AtomicInteger frameNumber = new AtomicInteger(1);

        frameConfigurations.forEach(frameConfiguration ->
        {
            // Add frame path
            final String framePath = String.format("%s/%s-%03d-%s.png", SAVE_PATH, initialTimestamp, frameNumber.getAndIncrement(), frameConfiguration.getId());
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
