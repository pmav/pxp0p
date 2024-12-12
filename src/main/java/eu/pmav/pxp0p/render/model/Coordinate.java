package eu.pmav.pxp0p.render.model;

public class Coordinate
{
    private final int x;
    private final int y;

    private final int frameIndex;

    public Coordinate(int x, int y, int framePosition)
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
