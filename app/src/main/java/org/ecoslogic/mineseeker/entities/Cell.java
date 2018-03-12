package org.ecoslogic.mineseeker.entities;

import org.ecoslogic.mineseeker.excepitons.CaboomException;

public class Cell {
    private static final CellHPosition LEFT = CellHPosition.from((byte) 0);
    private static final CellHPosition MIDDLE = CellHPosition.from((byte) 1);
    private static final CellHPosition RIGHT = CellHPosition.from((byte) 2);

    private static final CellVPosition TOP = CellVPosition.from((byte) 0);
    private static final CellVPosition CENTER = CellVPosition.from((byte) 1);
    private static final CellVPosition BOTTOM = CellVPosition.from((byte) 2);

    private State mCurrentState;
    private boolean mHasMine;

    public Cell(boolean hasMine) {
        mHasMine = hasMine;
        mCurrentState = new Closed();
    }


    //It depends if the cell itself has a mine!!!!
    public int getMinesSurrounded(SurroundingFieldOfMines minesSurroundingMe){
        int counter = 0;
        counter += minesSurroundingMe.hasMine(TOP,LEFT)?1:0;
        counter += minesSurroundingMe.hasMine(TOP,MIDDLE)?1:0;
        counter += minesSurroundingMe.hasMine(TOP,RIGHT)?1:0;

        counter += minesSurroundingMe.hasMine(CENTER,LEFT)?1:0;
        counter += minesSurroundingMe.hasMine(CENTER,RIGHT)?1:0;

        counter += minesSurroundingMe.hasMine(BOTTOM,LEFT)?1:0;
        counter += minesSurroundingMe.hasMine(BOTTOM,MIDDLE)?1:0;
        counter += minesSurroundingMe.hasMine(BOTTOM,RIGHT)?1:0;

        return counter;
    }

    public void lock(){
        mCurrentState = mCurrentState.lock();
    }

    public void open() throws CaboomException {
        mCurrentState = mCurrentState.open();

        if (mCurrentState instanceof Opened && (mHasMine))
            throw new CaboomException();
    }
}