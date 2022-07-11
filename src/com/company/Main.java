package com.company;

public class Main {

    public static void main(String[] args) {
        int choice = -5;

        Display.welcomeMsg();


        while (choice != 6) {
            Display.mainMenu();
            choice = Display.readAndValidateChoice();
            boolean listHasTasks;


            switch (choice) {
                case 1:
                    System.out.println("List of songs");
                    break;
                case 2:
                    System.out.println("Artists");
                    break;
                case 3:
                    System.out.println("Albums");
                    break;
                case 4:
                    System.out.println("Genres");
                    break;
                case 5:
                    System.out.println("Search");
                    break;
                case  6:
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Incorrect choice: Please enter a valid choice");
            }

        }
    }
}
