package eu.pmav.pxp0p.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static processing.core.PApplet.*;

public class Utils
{

    // TODO Remove PApplet dependency
    public static String getTimestampID()
    {
        final String year = nf(year(), 4);
        final String month = nf(month(), 2);
        final String day = nf(day(), 2);
        final String hour = nf(hour(), 2);
        final String minute = nf(minute(), 2);
        final String second = nf(second(), 2);

        return String.format("%s%s%s_%sh%sm%ss", year, month, day, hour, minute, second);
    }


    public static void createDirectory(String directory)
    {
        try
        {
            Files.createDirectories(Paths.get(directory));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
