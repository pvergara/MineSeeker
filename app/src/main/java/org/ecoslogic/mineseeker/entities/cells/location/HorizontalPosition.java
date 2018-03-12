package org.ecoslogic.mineseeker.entities.cells.location;

public class HorizontalPosition {
    private static byte mHorizontalPositionAsInt;

    private HorizontalPosition(byte horizontalPositionAsInt) {
        mHorizontalPositionAsInt = horizontalPositionAsInt;
    }

    public static HorizontalPosition from(byte HorizontalPositionAsInt) {
        return new HorizontalPosition(HorizontalPositionAsInt);
    }

    public byte asByte(){
        return mHorizontalPositionAsInt;
    }
}