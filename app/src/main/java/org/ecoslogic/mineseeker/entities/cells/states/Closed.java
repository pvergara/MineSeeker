package org.ecoslogic.mineseeker.entities.cells.states;

public class Closed implements State {
    @Override
    public State open() {
        return new Opened();
    }

    @Override
    public State lock() {
        return new ClosedAndLocked();
    }
}
