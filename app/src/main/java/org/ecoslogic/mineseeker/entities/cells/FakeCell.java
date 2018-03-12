package org.ecoslogic.mineseeker.entities.cells;

public class FakeCell implements BasicCell {

    private static FakeCell mInstance;

    public boolean hasMine() {
        return false;
    }

    public static FakeCell instance() {
        if(mInstance == null)
            mInstance = new FakeCell();
        return mInstance;
    }
}
