package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class Area {
    int width;
    int length;
    String String1;
    
    public Area(int width, int length) {
        this.width = width;
        this.length = length;

        if (width < 1 || length < 1)
            throw  new ValueException("значения области должны быть > 0");
    }

    public int getSquareMeters() {
        return width * length;
    }

    @Override
    public String toString(){
        return getSquareMeters() + " m2";
    }
}
