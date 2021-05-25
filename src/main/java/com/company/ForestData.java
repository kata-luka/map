package com.company;

public class ForestData extends MapElementData {
    Area forestArea;
    String[] treeTypes;

    public ForestData(Area forestArea, String[] treeTypes) {
        this.forestArea = forestArea;
        this.treeTypes = treeTypes;
    }

    @Override
    public String toString(){
        String text = "\nЛесной массив:" + forestArea.toString();
        text += "\nТипы деревьев: ";
        for (int i = 0; i < treeTypes.length; i++) {
            text += treeTypes[i];

            if (i < treeTypes.length - 1)
                text += ",";
        }

        return text;
    }
}
