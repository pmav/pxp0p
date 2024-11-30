package eu.pmav.pxp0p;

import eu.pmav.pxp0p.app.model.Configuration;
import eu.pmav.pxp0p.configuration.manual.impl.DevelopmentManualGenerator;
import eu.pmav.pxp0p.configuration.manual.impl.OlympicsManualGenerator;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    // Path to save each frame
    static final String SAVE_PATH = "/mnt/Storage/pxp0p/";

    private List<Applet> applets = new ArrayList<>();

    public static void main(String[] args) throws Exception
    {
        (new Main()).run();
    }


    public void run() throws Exception {
        final String saveDirectory = String.format("%s/%s", SAVE_PATH, Utils.getTimestampID());

        // Create directory
        Utils.createDirectory(saveDirectory);

        List<Configuration> configurations;
        List<Configuration> configurations2;

        //configurations = (new CuidadoComOCaoManualGenerator()).generateConfigurations();
        //configurations = (new InstagramManualGenerator()).generateConfigurations();
        configurations = (new DevelopmentManualGenerator()).generateConfigurations();
        configurations2 = (new OlympicsManualGenerator()).generateConfigurations();
        //configurations = (new RandomGenerator(1)).generateConfigurations(10);

        Applet applet = new Applet(configurations, saveDirectory, this);
        applets.add(applet);
        PApplet.runSketch(new String[]{applet.getClass().getName()}, applet);

        Applet applet2 = new Applet(configurations2, saveDirectory, this);
        applets.add(applet2);
        PApplet.runSketch(new String[]{applet2.getClass().getName()}, applet2);
    }

    public void m(Applet applet) {
        System.out.println("Removing: "+applet.hashCode());
        applets.remove(applet);
        if (applets.isEmpty())
        {
            System.out.println("Done");
            System.exit(0);
        }
    }
}
