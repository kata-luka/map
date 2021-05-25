package com.company;

import java.util.Scanner;

public class MapEditor {
    MapElementReceiver mapElementReceiver;
    Scanner input;

    Area areaToCreate;
    String[] textToUse;

    public MapEditor(MapElementReceiver receiver, Scanner input) {
        this.mapElementReceiver = receiver;
        this.input = input;

        textToUse = new String[0];
    }

    public void showEditMenu() {
        System.out.println("Выберите данные для добавления. Введите цифру:");
        System.out.println("[1] Данные о лесомассиве");
        System.out.println("[2] Данные о озерах");
        System.out.println("[3] Данные о животных");
        System.out.println("[5] Отобразить данные карты");
        int startEditing = Integer.parseInt(input.nextLine());
        switch (startEditing) {
            case 1:
                editForestData();
                break;
            case 5:
                System.out.println(mapElementReceiver.toString());
                break;
            case 2:
                editLakeData();
                break;
            case 3:
                editAnimalData();
                break;

            default:
                System.out.println("Ошибка");
                break;
        }
    }

    void editForestData() {
        System.out.println("Введите ширину лесомассива, метры:");
        int forestAreaWidth = Integer.parseInt(input.nextLine());
        System.out.println("Введите продолжительность лесомассива, метры:");
        int forestAreaLength = Integer.parseInt(input.nextLine());
        areaToCreate = new Area(forestAreaWidth, forestAreaLength);

        editForestType();
    }

    void editLakeData() {
        System.out.println("Введите ширину озера, метры:");
        int laketAreaWidth = Integer.parseInt(input.nextLine());
        System.out.println("Введите продолжительность озера, метры:");
        int lakeAreaLength = Integer.parseInt(input.nextLine());
        System.out.println("Введите глубину озера, метры:");
        int lakeLevel = Integer.parseInt(input.nextLine());
        areaToCreate = new Area(laketAreaWidth, lakeAreaLength);

        LakeData dataLake = new LakeData(areaToCreate, lakeLevel);
        mapElementReceiver.receiveMapElement(dataLake);
        showEditMenu();

    }

    void editAnimalData() {
        System.out.println("Введите ширину поля, где живут животные, метры:");
        int animalAreaWidth = Integer.parseInt(input.nextLine());
        System.out.println("Введите длину поля, где живут животные, метры:");
        int animalAreaLength = Integer.parseInt(input.nextLine());
        System.out.println("Введите количество животных:");
        areaToCreate = new Area(animalAreaWidth, animalAreaLength);
        textToUse = new String[0];
        editAnimalType();

    }

    void editForestType() {
        System.out.println("Введите тип деревьев. Введите finish для завершения редактирования");
        String treeType = input.nextLine();

        switch (treeType) {
            case "finish":
                ForestData forestData = new ForestData(areaToCreate, textToUse);
                mapElementReceiver.receiveMapElement(forestData);
                showEditMenu();
                break;
            default:
                String[] newTypes = new String[textToUse.length + 1];
                for (int i = 0; i < textToUse.length; i++) {
                    newTypes[i] = textToUse[i];
                }
                newTypes[newTypes.length - 1] = treeType;
                textToUse = newTypes;
                editForestType();
                break;
        }
    }

    void editAnimalType() {
        System.out.println("Введите виды животных. Введите finish для завершения редактирования");
        String animalType = input.nextLine();

        switch (animalType) {
            case "finish":
                AnimalData animalData = new AnimalData(areaToCreate, textToUse);
                mapElementReceiver.receiveMapElement(animalData);
                showEditMenu();
                break;
            default:
                String[] newTypes = new String[textToUse.length + 1];
                for (int i = 0; i < textToUse.length; i++) {
                    newTypes[i] = textToUse[i];
                }
                newTypes[newTypes.length - 1] = animalType;
                textToUse = newTypes;
                editAnimalType();
                break;
        }
    }
}


