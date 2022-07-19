package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static SongList sl = new SongList();

    /**
     * This used to run by the choice selected by the user.
     */
    public static void extracted() {
        ArrayList<String> songsDisplay = new ArrayList<String>();
        int choice = -5;
        Scanner sc = new Scanner(System.in);
        Display.mainMenu();
        choice = Validation.readAndValidateChoice();

        switch (choice) {
            case 1:
                sl.listDisplay(sl.getSongs());
                int selection = getSelection(sl.getSongs());
                sl.playSong(selection);
                break;
            case 2:
                filterBy(sl.getArtists());
                break;
            case 3:
                filterBy(sl.getAlbums());
                break;
            case 4:
                filterBy(sl.getGenres());
                break;
            case 5:
                System.out.print("Write the name of the song and press enter: ");
                songsDisplay = sl.songSearch(sc.nextLine());
                selection = getSelection(songsDisplay);
                sl.findSongNumber(songsDisplay, selection);

                break;
            case 6:
                System.out.println("Good Bye");
                break;
            default:
                System.out.println("Incorrect choice: Please enter a valid choice");
        }
    }

    /**
     * This method checks whether the entered number is valid or not in the given list.
     *
     * @param filterListDisplay list to select the choice
     * @return choice selected by the user
     */
    private static int getSelection(ArrayList<String> filterListDisplay) {
        int number = Validation.validateChoice(filterListDisplay);
        if (number == 0) {
            extracted();
            System.exit(1);
        }
        return number;
    }

    /**
     * The method used to filter the list based on the user selection
     *
     * @param filterList list which the user want to filter
     */
    private static void filterBy(ArrayList<String> filterList) {
        int selection;
        ArrayList<String> songsDisplay;
        sl.listDisplay(sl.removeDuplicate(filterList));
        selection = getSelection(sl.removeDuplicate(filterList));
        songsDisplay = sl.displaySongs(sl.removeDuplicate(filterList), selection, filterList);
        selection = getSelection(songsDisplay);
        sl.findSongNumber(songsDisplay, selection);
    }

    public static void main(String[] args) {
        sl.list();
        Display.welcomeMsg();
        extracted();
    }


}

