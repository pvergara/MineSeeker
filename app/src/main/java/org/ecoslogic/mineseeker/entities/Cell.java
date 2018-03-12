package org.ecoslogic.mineseeker.entities;

import org.ecoslogic.mineseeker.entities.cells.states.Closed;
import org.ecoslogic.mineseeker.entities.cells.states.Opened;
import org.ecoslogic.mineseeker.entities.cells.states.State;
import org.ecoslogic.mineseeker.excepitons.CaboomException;

import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.BOTTOM;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.CENTER;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.LEFT;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.MIDDLE;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.RIGHT;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.TOP;

public class Cell {

    private State mCurrentState;
    private boolean mHasMine;

    public Cell(boolean hasMine) {
        mHasMine = hasMine;
        mCurrentState = new Closed();
    }


    public int countSurroundingMines(SurroundingFieldOfMines minesSurroundingMe){
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