package org.ecoslogic.mineseeker.entities.field.location;

public class DimensionPoint {
    private HorizontalPoint mHorizontalPoint;
    private VerticalPoint mVerticalPoint;

    private HorizontalPoint ZeroHorizontalPoint = HorizontalPoint.from(0);
    private HorizontalPoint LastHorizontalPoint = HorizontalPoint.from(0);

    private VerticalPoint ZeroVerticalPoint = VerticalPoint.from(getDimensions()-1);
    private VerticalPoint LastVerticalPoint = VerticalPoint.from(getDimensions()-1);

    public boolean isNorthBorder() {
        return mHorizontalPoint.equals(ZeroHorizontalPoint);
    }

    public boolean youAreTheFirstInTheTop() {
        return mHorizontalPoint.equals(ZeroHorizontalPoint) && mVerticalPoint.equals(ZeroVerticalPoint);
    }

    public boolean youAreTheLastInTheTop() {
        return mHorizontalPoint.equals(ZeroHorizontalPoint) && mVerticalPoint.equals(LastVerticalPoint);
    }

    public boolean isSouthBorder() {
        return mHorizontalPoint.equals(LastHorizontalPoint);
    }

    public boolean youAreTheFirstInTheBottom() {
        return mHorizontalPoint.equals(LastHorizontalPoint) && mVerticalPoint.equals(ZeroVerticalPoint);
    }

    public boolean youAreTheLastInTheBottom() {
        return mHorizontalPoint.equals(LastHorizontalPoint) && mVerticalPoint.equals(LastVerticalPoint);
    }

    public boolean isEastBorder() {
        return mVerticalPoint.equals(ZeroVerticalPoint);
    }

    public boolean isWestBorder() {
        return mVerticalPoint.equals(LastVerticalPoint);
    }

    private int getDimensions() {
        return 10;
    }
}
