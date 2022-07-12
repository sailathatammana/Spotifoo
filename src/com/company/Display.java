package com.company;

import java.util.Scanner;

public class Display {

    public static void welcomeMsg() {
        System.out.println(" Welcome to Spotifoo");
        System.out.println("------------------------");
    }

    public static void mainMenu(){
        System.out.println(" Main menu options:");
        System.out.println(" 1. Songs");
        System.out.println(" 2. Artists");
        System.out.println(" 3. Albums");
        System.out.println(" 4. Genres");
        System.out.println(" 5. Search");
        System.out.println(" 6. Quit\n");
        System.out.print(" Choose an option and press enter: ");
    }
}
