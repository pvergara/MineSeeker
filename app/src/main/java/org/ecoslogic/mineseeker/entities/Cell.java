package org.ecoslogic.mineseeker.entities;

import org.ecoslogic.mineseeker.entities.cells.BasicCell;
import org.ecoslogic.mineseeker.entities.cells.states.Closed;
import org.ecoslogic.mineseeker.entities.cells.states.Opened;
import org.ecoslogic.mineseeker.entities.cells.states.State;
import org.ecoslogic.mineseeker.entities.field.location.DimensionPoint;
import org.ecoslogic.mineseeker.excepitons.CaboomException;

import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.BOTTOM;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.CENTER;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.LEFT;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.MIDDLE;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.RIGHT;
import static org.ecoslogic.mineseeker.entities.SurroundingFieldOfMines.TOP;

public class Cell implements BasicCell {

    private State mCurrentState;
    private DimensionPoint mPointOfThisCellInsideTheField;
    private boolean mHasMine;
    private SurroundingFieldOfMines mMinesSurroundingMe;

    public Cell(DimensionPoint pointOfThisCellInsideTheField, boolean hasMine) {
        mPointOfThisCellInsideTheField = pointOfThisCellInsideTheField;
        mHasMine = hasMine;
        mCurrentState = new Closed();

        mMinesSurroundingMe = createDependingOn(mPointOfThisCellInsideTheField);
    }

    private SurroundingFieldOfMines createDependingOn(DimensionPoint pointOfThisCellInsideTheField) {
        //1º Determing wherever it can be created (think on sqaures and boundaries)

        mMinesSurroundingMe = new SurroundingFieldOfMines();
        if(pointOfThisCellInsideTheField.isNorthBorder())
        {
            mMinesSurroundingMe.setThereIsNoCellOn(TOP,   LEFT);
            mMinesSurroundingMe.setThereIsNoCellOn(TOP,   MIDDLE);
            mMinesSurroundingMe.setThereIsNoCellOn(TOP,   RIGHT);

            //The same as asking if stay on the west boundary, isn't it?
            if(pointOfThisCellInsideTheField.youAreTheFirstInTheTop()) {
//                (repeated)
//                mMinesSurroundingMe.setThereIsNoCellOn(TOP,   LEFT);
                mMinesSurroundingMe.setThereIsNoCellOn(CENTER,LEFT);
                mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,LEFT);
            }
            //The same as asking if stay on the east boundary, isn't it?
            if(pointOfThisCellInsideTheField.youAreTheLastInTheTop()) {
//                (repeated)
//                mMinesSurroundingMe.setThereIsNoCellOn(TOP,   RIGHT);
                mMinesSurroundingMe.setThereIsNoCellOn(CENTER,RIGHT);
                mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,RIGHT);
            }

        }
        if(pointOfThisCellInsideTheField.isSouthBorder())
        {
            mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,LEFT);
            mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,MIDDLE);
            mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,RIGHT);

            //The same as asking if stay on the west boundary, isn't it?
            if(pointOfThisCellInsideTheField.youAreTheFirstInTheBottom()) {
//                (repeated)
//                mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,LEFT);
                mMinesSurroundingMe.setThereIsNoCellOn(TOP,   LEFT);
                mMinesSurroundingMe.setThereIsNoCellOn(CENTER,LEFT);
            }

            //The same as asking if stay on the east boundary, isn't it?
            if(pointOfThisCellInsideTheField.youAreTheLastInTheBottom()) {
//                (repeated)
//                mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,RIGHT);
                mMinesSurroundingMe.setThereIsNoCellOn(TOP,   RIGHT);
                mMinesSurroundingMe.setThereIsNoCellOn(CENTER,RIGHT);
            }

        }
        if(pointOfThisCellInsideTheField.isEastBorder())
        {
            mMinesSurroundingMe.setThereIsNoCellOn(TOP,   RIGHT);
            mMinesSurroundingMe.setThereIsNoCellOn(CENTER,RIGHT);
            mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,RIGHT);
        }
        if(pointOfThisCellInsideTheField.isWestBorder())
        {
            mMinesSurroundingMe.setThereIsNoCellOn(TOP,   LEFT);
            mMinesSurroundingMe.setThereIsNoCellOn(CENTER,LEFT);
            mMinesSurroundingMe.setThereIsNoCellOn(BOTTOM,LEFT);
        }

        //2º ¿¿Try to access to this cells?? (From heeeereeee... a only Cell... ummm I don't know if I can/want make that kind of "black" magic)
        return null;
    }


    public int countSurroundingMines(){
        int counter = 0;
        counter += mMinesSurroundingMe.hasMine(TOP,LEFT)?1:0;
        counter += mMinesSurroundingMe.hasMine(TOP,MIDDLE)?1:0;
        counter += mMinesSurroundingMe.hasMine(TOP,RIGHT)?1:0;

        counter += mMinesSurroundingMe.hasMine(CENTER,LEFT)?1:0;
        counter += mMinesSurroundingMe.hasMine(CENTER,RIGHT)?1:0;

        counter += mMinesSurroundingMe.hasMine(BOTTOM,LEFT)?1:0;
        counter += mMinesSurroundingMe.hasMine(BOTTOM,MIDDLE)?1:0;
        counter += mMinesSurroundingMe.hasMine(BOTTOM,RIGHT)?1:0;

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

    @Override
    public boolean hasMine() {
        return mHasMine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return mPointOfThisCellInsideTheField.equals(cell.mPointOfThisCellInsideTheField);
    }

    @Override
    public int hashCode() {
        return mPointOfThisCellInsideTheField.hashCode();
    }
}