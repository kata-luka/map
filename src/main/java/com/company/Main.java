package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя карты: ");
        String mapName = in.nextLine();
        System.out.println("Введите ширину области: ");
        int width = Integer.parseInt(in.nextLine());
        System.out.println("Введите длину области: ");
        int length = Integer.parseInt(in.nextLine());

        Area mapArea = new Area(width, length);
        TerrainMap newTerrainMap = new TerrainMap(mapName, mapArea);
        System.out.println("Создана карта - " + newTerrainMap.toString());

        MapEditor mapEditor = new MapEditor(newTerrainMap, in);
        mapEditor.showEditMenu();
    }
}




// name
// area m2s
// forest area m2
// forest trees types
// agriculture area m2
// agriculture types
// lakes area m2
// lake level

// функционал
// Получить прцоент занимаемой области для каждого типа (лес, поля, озеро)