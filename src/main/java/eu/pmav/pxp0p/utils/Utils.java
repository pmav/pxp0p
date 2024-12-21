package eu.pmav.pxp0p.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils
{
    // Set deterministic behaviour
    private static final Random random = new Random(0);

    // Date and time format
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH'h'mm'm'ss's'");

    public static String getTimestampID()
    {
        return LocalDateTime.now().format(dateTimeFormatter);
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

    public static int getRandomInt(int bound)
    {
        return random.nextInt(bound);
    }

    public static float getRandomFloat(float low, float high)
    {
        return random.nextFloat(low, high);
    }
}
