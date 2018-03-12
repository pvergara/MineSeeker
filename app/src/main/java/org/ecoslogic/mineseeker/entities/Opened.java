package org.ecoslogic.mineseeker.entities;

class Opened implements State {
    @Override
    public State open() {
        return this;
    }

    @Override
    public State lock() {
        return new Closed();
    }
}
