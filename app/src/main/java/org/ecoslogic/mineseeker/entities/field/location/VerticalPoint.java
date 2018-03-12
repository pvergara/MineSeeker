package org.ecoslogic.mineseeker.entities.field.location;

class VerticalPoint {
    private int mPositionAsInt;

    private VerticalPoint(int positionAsInt) {
        mPositionAsInt = positionAsInt;
    }

    public static VerticalPoint from(int positionAsInt) {
        return new VerticalPoint(positionAsInt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerticalPoint that = (VerticalPoint) o;

        return mPositionAsInt == that.mPositionAsInt;
    }

    @Override
    public int hashCode() {
        return mPositionAsInt;
    }
}
