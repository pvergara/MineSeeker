package org.ecoslogic.mineseeker.entities;

class CellVPosition {
    private byte mCellVerticalPosition;

    private CellVPosition(byte cellVerticalPosition) {
        mCellVerticalPosition = cellVerticalPosition;
    }

    public static CellVPosition from(byte cellVerticalPosition) {
        return new CellVPosition(cellVerticalPosition);
    }

    public byte asByte(){
        return mCellVerticalPosition;
    }
}