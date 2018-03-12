package org.ecoslogic.mineseeker.entities.field.location;

class HorizontalPoint {
    private int mPointAsInt;

    private HorizontalPoint(int pointAsInt) {
        mPointAsInt = pointAsInt;
    }

    public static HorizontalPoint from(int pointAsInt) {
        return new HorizontalPoint(pointAsInt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HorizontalPoint that = (HorizontalPoint) o;

        return mPointAsInt == that.mPointAsInt;
    }

    @Override
    public int hashCode() {
        return mPointAsInt;
    }
}