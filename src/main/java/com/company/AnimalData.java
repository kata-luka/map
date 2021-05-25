package com.company;

public class AnimalData extends MapElementData {
    Area animalArea;
    String[] animalTypes;

    public AnimalData(Area animalArea, String[] animalTypes) {
        this.animalArea = animalArea;
        this.animalTypes = animalTypes;
    }

    @Override
    public String toString(){
        String text = "\nПлощадь обитания животных:" + animalArea.toString();
        text += "\nТипы животных: ";
        for (int i = 0; i < animalTypes.length; i++) {
            text += animalTypes[i];

            if (i < animalTypes.length - 1)
                text += ",";
        }

        return text;
    }
}
