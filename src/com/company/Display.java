package com.company;

import java.util.ArrayList;

public class Display {

    public static void welcomeMsg() {
        System.out.println(" Welcome to Spotifoo");
        System.out.println("------------------------");
    }

    public static void mainMenu() {
        System.out.println(" Main menu options:");
        System.out.println(" [1] Songs");
        System.out.println(" [2] Artists");
        System.out.println(" [3] Albums");
        System.out.println(" [4] Genres");
        System.out.println(" [5] Search");
        System.out.println(" [6] Quit\n");
        System.out.print(" Choose an option and press enter: ");
    }

    /**
     * This method will display the list of songs, artists, albums, genres to the user
     *
     * @param list List selected by the user
     */
    public static void listDisplay(ArrayList<String> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.println("[" + i + "]" + " " + list.get(i - 1));
        }
        System.out.println("[0] Back to main Menu");
        System.out.print(" Choose an option and press enter: ");
    }

    /**
     * This method is used to clear the command prompt window when user selects an option.
     */
    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                Display.welcomeMsg();
            } else {
                Runtime.getRuntime().exec("clear");
                Display.welcomeMsg();
            }
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}