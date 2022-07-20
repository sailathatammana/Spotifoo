package com.company;

import java.util.*;

public class Validation {

    public static int readAndValidateChoice() {
        Scanner sc = new Scanner(System.in);
        String inputValue;
        int choice = 50;
        int check = 0;
        while (check != 1) {
            try {
                inputValue = sc.nextLine();
                choice = Integer.parseInt(inputValue);
                while (choice > 6 || choice <= 0) {
                    System.out.println(" Please enter a number between 1 to 6!");
                    System.out.print(" Choose an option and press enter: ");
                    inputValue = sc.nextLine();
                    choice = Integer.parseInt(inputValue);
                }
                check = 1;
            } catch (NumberFormatException e) {
                System.out.println(" That's not a number!");
                System.out.print(" Choose an option and press enter: ");
            }
        }
        return choice;
    }

    public static String validateString() {
        Scanner sc = new Scanner(System.in);
        String inputValue = null;
        int check = 0;
        while (check != 1) {
            try {
                inputValue = sc.next();
                Integer.parseInt(inputValue);
                System.out.println(" That's not a String!");
                System.out.print(" Enter a string value: ");
            } catch (NumberFormatException e) {
                check = 1;
            }
        }
        return inputValue;
    }

    public static int validateChoice(ArrayList<String> sl) {
        Scanner sc = new Scanner(System.in);
        String inputValue;
        int choice = 50;
        int check = 0;
        while (check != 1) {
            try {
                inputValue = sc.nextLine();
                choice = Integer.parseInt(inputValue);
                while (choice > sl.size() || choice < 0) {
                    System.out.println(" Please enter a number between 1 to " + sl.size() + " !");
                    System.out.print(" Choose an option and press enter: ");
                    inputValue = sc.nextLine();
                    choice = Integer.parseInt(inputValue);
                }
                check = 1;
            } catch (NumberFormatException e) {
                System.out.println(" That's not a number!");
                System.out.print(" Choose an option and press enter: ");
            }
        }
        return choice;
    }
}
