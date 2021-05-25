package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class TerrainMap implements MapElementReceiver {
    String name;
    Area area;
    MapElementData[] additionalData;


    public TerrainMap(String name, Area area) {
        this.name = name;
        this.area = area;

        if (name == null || area == null)
            throw new NullPointerException();
        else if (name == "")
            throw new ValueException("имя карты не может быть пустым");

        additionalData = new MapElementData[0];
    }

    void addMapElement(MapElementData element){
        MapElementData[] newData = new MapElementData[additionalData.length + 1];
        for (int i = 0; i < additionalData.length; i++) {
            newData[i] = additionalData[i];
        }
        newData[newData.length - 1] = element;
        additionalData = newData;
    }

    @Override
    public String toString(){
        String text = "Название карты: " + name + ", " + area.toString() + "\n";
        for (int i = 0; i < additionalData.length; i++) {
            text += additionalData[i].toString();
        }

        return text;
    }

    @Override
    public void receiveMapElement(MapElementData mapElementData) {
        addMapElement(mapElementData);
    }
}
