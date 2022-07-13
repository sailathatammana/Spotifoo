package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        SongList sl = new SongList();
        sl.list();
        ArrayList<String> test = new ArrayList<String>();

        int choice = -5;
        Scanner sc = new Scanner(System.in);

        Display.welcomeMsg();
        Display.mainMenu();
        choice = Validation.readAndValidateChoice();

        switch (choice) {
            case 1:
                sl.listDisplay(sl.songs);
                sl.playSong(sc.nextInt());
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
                System.out.print("Write the name of the song and press enter: ");
                test = sl.songSearch(sc.nextLine());
                sl.findSongNumber(test, parseInt(sc.nextLine()));
                break;
            case 6:
                System.out.println("Good Bye");
                break;
            default:
                System.out.println("Incorrect choice: Please enter a valid choice");
        }
    }
}

