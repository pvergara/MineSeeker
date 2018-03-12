package org.ecoslogic.mineseeker.entities.cells.states;

public interface State {
    State open();
    State lock();
}
