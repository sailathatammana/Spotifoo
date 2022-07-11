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

    public static int readAndValidateChoice(){
        Scanner sc = new Scanner(System.in);
        int choice = 50;
        do {

            if(choice <= 0)
                System.out.println("Please enter a number between 1 to 4!");

            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            choice = sc.nextInt();
        } while (choice <= 0);
        return choice;
    }

}
