package com.zenika.tz.trunkkata.utils;

public class PersistenceFunctionMock<T> {
    private int callCounter;

    public void apply(T o){
        callCounter++;
    }

    public boolean wasCalled(){
        return callCounter != 0;
    }

    public int getCallCount(){
        return callCounter;
    }
}
