package org.ecoslogic.mineseeker.entities.cells.states;

public class ClosedAndLocked implements State {
    @Override
    public State open() {
        return this;
    }

    @Override
    public State lock() {
        return new Closed();
    }
}
