package org.ecoslogic.mineseeker.entities;

class VerticalPosition {
    private byte mCellVerticalPosition;

    private VerticalPosition(byte cellVerticalPosition) {
        mCellVerticalPosition = cellVerticalPosition;
    }

    public static VerticalPosition from(byte cellVerticalPosition) {
        return new VerticalPosition(cellVerticalPosition);
    }

    public byte asByte(){
        return mCellVerticalPosition;
    }
}