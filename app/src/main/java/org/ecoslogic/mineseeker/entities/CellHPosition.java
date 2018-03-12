package org.ecoslogic.mineseeker.entities;

class CellHPosition {
    private static byte mHorizontalPositionAsInt;

    private CellHPosition(byte horizontalPositionAsInt) {
        mHorizontalPositionAsInt = horizontalPositionAsInt;
    }

    public static CellHPosition from(byte HorizontalPositionAsInt) {
        return new CellHPosition(HorizontalPositionAsInt);
    }

    public byte asByte(){
        return mHorizontalPositionAsInt;
    }
}