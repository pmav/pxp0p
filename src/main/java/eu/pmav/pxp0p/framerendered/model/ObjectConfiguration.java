package eu.pmav.pxp0p.framerendered.model;

public class ObjectConfiguration
{
    private final int x;

    private final int y;

    private final int frameIndex;

    public ObjectConfiguration(int x, int y, int framePosition)
    {
        this.x = x;
        this.y = y;
        this.frameIndex = framePosition;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getFrameIndex()
    {
        return frameIndex;
    }
}
