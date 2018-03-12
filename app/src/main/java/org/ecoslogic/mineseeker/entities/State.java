package org.ecoslogic.mineseeker.entities;

interface State {
    State open();
    State lock();
}
