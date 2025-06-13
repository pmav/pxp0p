package eu.pmav.pxp0p.frameconfiguration.model;


import eu.pmav.pxp0p.framerendered.forms.FormType;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrameConfiguration implements Serializable
{
    // Frame id
    private final String id;

    // Frame path
    private String framePath;

    // Canvas size
    private int canvasWidth;
    private int canvasHeight;

    // Space used inside canvas
    private int gridWidth;
    private int gridHeight;

    // Objects in the grid
    private int objectColumns;
    private int objectLines;

    // Space between objects in px
    private int objectSpacing;

    // Background color
    private int colorBackground;

    // Blur value
    private float blurValue;

    // Forms to be generated
    private List<FormType> formTypes;

    // Forms colors
    private final Map<FormType, int[]> colorsForm = new HashMap<>();

    // Initial Position variation
    private IntFunction xVariationFunction = null;
    private IntFunction yVariationFunction = null;

    // Size Transform
    private FloatFunction sizeTransformFunction = null;

    // Alpha value
    private IntFunction alphaFunction = null;

    // Stroke
    private boolean stroke;
    private int strokeSize;
    private int strokeColor;

    // Cuts
    private boolean cuts;
    private float cutSize;

    // TODO To be refactor and remove hardcoded reference to Forms
    private int[] colorsCutCircle;
    private int[] colorsCutSquare;
    private int[] colorsCutTriangle;

    // Direction
    private IntFunction directionFunction = null;

    // Rotate
    private FloatFunction rotateFunction = null;

    // Center object
    private boolean centerObject;
    private float centerObjectSize;
    private int[] colorsCenterObject;

    // Lambda functions
    public interface IntFunction extends Serializable {
        int run(int frameIndex);
    }

    public interface FloatFunction extends Serializable {
        float run(int frameIndex);
    }

    // Constructor
    public FrameConfiguration(String id)
    {
        this.id = id;
    }

    public FrameConfiguration copy() throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(outputStream);
        ObjectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        return (FrameConfiguration) objInputStream.readObject();
    }

    @Override
    public String toString()
    {
        return "Configuration{" +
                "canvasWidth=" + canvasWidth +
                ", canvasHeight=" + canvasHeight +
                ", gridWidth=" + gridWidth +
                ", gridHeight=" + gridHeight +
                ", objectColumns=" + objectColumns +
                ", objectLines=" + objectLines +
                ", objectSpacing=" + objectSpacing +
                "}\n";
    }

    //region Getters and setters

    // General

    public String getId() {
        return id;
    }

    public String getFramePath()
    {
        return this.framePath;
    }

    public void setFramePath(String framePath)
    {
        this.framePath = framePath;
    }

    public int getCanvasWidth()
    {
        return this.canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth)
    {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight()
    {
        return this.canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight)
    {
        this.canvasHeight = canvasHeight;
    }

    public int getGridWidth()
    {
        return this.gridWidth;
    }

    public void setGridWidth(int gridWidth)
    {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight()
    {
        return this.gridHeight;
    }

    public void setGridHeight(int gridHeight)
    {
        this.gridHeight = gridHeight;
    }

    // Layout

    public int getObjectColumns()
    {
        return this.objectColumns;
    }

    public void setObjectColumns(int objectColumns)
    {
        this.objectColumns = objectColumns;
    }

    public int getObjectLines()
    {
        return this.objectLines;
    }

    public void setObjectLines(int objectLines)
    {
        this.objectLines = objectLines;
    }

    public int getObjectSpacing()
    {
        return this.objectSpacing;
    }

    public void setObjectSpacing(int objectSpacing)
    {
        this.objectSpacing = objectSpacing;
    }

    // Form types

    public List<FormType> getFormTypes() {
        return formTypes;
    }

    public void setFormTypes(List<FormType> formTypes) {
        this.formTypes = formTypes;
    }

    // Initial Position variation

    public IntFunction getxVariationFunction() {
        return xVariationFunction;
    }

    public void setxVariationFunction(IntFunction xVariationFunction) {
        this.xVariationFunction = xVariationFunction;
    }

    public IntFunction getyVariationFunction() {
        return yVariationFunction;
    }

    public void setyVariationFunction(IntFunction yVariationFunction) {
        this.yVariationFunction = yVariationFunction;
    }

    // Background color

    public int getColorBackground()
    {
        return this.colorBackground;
    }

    public void setColorBackground(int colorBackground)
    {
        this.colorBackground = colorBackground;
    }

    // Blur

    public float getBlurValue()
    {
        return this.blurValue;
    }

    public void setBlurValue(float blurValue)
    {
        this.blurValue = blurValue;
    }

    // Size

    public FloatFunction getSizeTransformFunction() {
        return sizeTransformFunction;
    }

    public void setSizeTransformFunction(FloatFunction sizeTransformFunction) {
        this.sizeTransformFunction = sizeTransformFunction;
    }

    // Cuts

    public boolean hasCuts()
    {
        return this.cuts;
    }

    public void setCuts(boolean haveCuts)
    {
        this.cuts = haveCuts;
    }

    public float getCutSize()
    {
        return this.cutSize;
    }

    public void setCutSize(float cutSize)
    {
        this.cutSize = cutSize;
    }

    // Object colors

    public int[] getColorsCutCircle()
    {
        return this.colorsCutCircle;
    }

    public void setColorsCutCircle(int[] colorsCutCircle)
    {
        this.colorsCutCircle = colorsCutCircle;
    }

    public int[] getColorsCutSquare()
    {
        return this.colorsCutSquare;
    }

    public void setColorsCutSquare(int[] colorsCutSquare)
    {
        this.colorsCutSquare = colorsCutSquare;
    }

    public int[] getColorsCutTriangle()
    {
        return this.colorsCutTriangle;
    }

    public void setColorsCutTriangle(int[] colorsCutTriangle)
    {
        this.colorsCutTriangle = colorsCutTriangle;
    }

    // Alpha

    public IntFunction getAlphaFunction() {
        return alphaFunction;
    }

    public void setAlphaFunction(IntFunction alphaFunction) {
        this.alphaFunction = alphaFunction;
    }

    // Stroke

    public boolean hasStroke()
    {
        return this.stroke;
    }

    public void setStroke(boolean haveStroke)
    {
        this.stroke = haveStroke;
    }

    public int getStrokeColor()
    {
        return this.strokeColor;
    }

    public void setStrokeColor(int strokeColor)
    {
        this.strokeColor = strokeColor;
    }

    public int getStrokeSize()
    {
        return this.strokeSize;
    }

    public void setStrokeSize(int strokeSize)
    {
        this.strokeSize = strokeSize;
    }

    public Map<FormType, int[]> getColorsForm()
    {
        return this.colorsForm;
    }

    public void addColorsForm(FormType formType, int[] colors)
    {
        this.colorsForm.put(formType, colors);
    }

    // Center object

    public boolean hasCenterObject()
    {
        return this.centerObject;
    }

    public void setCenterObject(boolean haveCenterObject)
    {
        this.centerObject = haveCenterObject;
    }

    public float getCenterObjectSize()
    {
        return this.centerObjectSize;
    }

    public void setCenterObjectSize(float centerObjectSize)
    {
        this.centerObjectSize = centerObjectSize;
    }

    public int[] getColorsCenterObject()
    {
        return this.colorsCenterObject;
    }

    public void setColorsCenterObject(int[] colorsCenterObject)
    {
        this.colorsCenterObject = colorsCenterObject;
    }

    // Direction

    public IntFunction getDirectionFunction() {
        return directionFunction;
    }

    public void setDirectionFunction(IntFunction directionFunction) {
        this.directionFunction = directionFunction;
    }

    // Rotate

    public FloatFunction getRotateFunction() {
        return rotateFunction;
    }

    public void setRotateFunction(FloatFunction rotateFunction) {
        this.rotateFunction = rotateFunction;
    }

    //endregion
}

