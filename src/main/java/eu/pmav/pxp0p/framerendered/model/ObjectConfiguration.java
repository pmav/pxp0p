package eu.pmav.pxp0p.framerendered.model;

public class ObjectConfiguration
{
    private final int x;

    private final int y;

    private final int size;

    private final int frameIndex;

    public ObjectConfiguration(int x, int y, int size, int frameIndex)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.frameIndex = frameIndex;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getFrameIndex()
    {
        return frameIndex;
    }
}
