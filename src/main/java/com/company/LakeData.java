package com.company;

public class LakeData extends MapElementData {
    Area lakesArea;
    int waterLevel;

    public LakeData(Area lakesArea, int waterLevel) {
        this.lakesArea = lakesArea;
        this.waterLevel = waterLevel;
    }

    @Override
    public String toString(){
        String text = "Озера:" + lakesArea.toString();
        text += "\nУровни озер (глубина): " + waterLevel;

        return text;
    }

}
