package org.ecoslogic.mineseeker.entities;

class Closed implements State {
    @Override
    public State open() {
        return new Opened();
    }

    @Override
    public State lock() {
        return new ClosedAndLocked();
    }
}
