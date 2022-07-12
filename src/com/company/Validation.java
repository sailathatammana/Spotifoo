package com.company;

import java.util.Scanner;

public class Validation {

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
