package eu.pmav.pxp0p.utils;

import eu.pmav.pxp0p.Applet;

import java.util.ArrayList;
import java.util.List;

public class ExitHandler
{
    private final List<Applet> applets = new ArrayList<>();

    public ExitHandler()
    {
    }

    public void registerApplet(Applet applet)
    {
        this.applets.add(applet);
    }

    public void notifyFinish(Applet applet)
    {
        applets.remove(applet);

        if (applets.isEmpty())
        {
            System.exit(0);
        }
    }
}
