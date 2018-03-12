package org.ecoslogic.mineseeker.entities;

import org.ecoslogic.mineseeker.entities.cells.location.HorizontalPosition;
import org.ecoslogic.mineseeker.entities.cells.location.VerticalPosition;

class SurroundingFieldOfMines {
    static final HorizontalPosition LEFT = HorizontalPosition.from((byte) 0);
    static final HorizontalPosition MIDDLE = HorizontalPosition.from((byte) 1);
    static final HorizontalPosition RIGHT = HorizontalPosition.from((byte) 2);

    static final VerticalPosition TOP = VerticalPosition.from((byte) 0);
    static final VerticalPosition CENTER = VerticalPosition.from((byte) 1);
    static final VerticalPosition BOTTOM = VerticalPosition.from((byte) 2);

    boolean hasMine(VerticalPosition verticalPosition, HorizontalPosition horizontalPosition) {
        return false;
    }
}
