package com.company;

import com.company.songs.*;

import java.util.*;

public class ChooseOption {

    public static void extracted() {
        ArrayList<String> songsDisplay = new ArrayList<String>();
        int choice = -5;
        Scanner sc = new Scanner(System.in);
        Display.mainMenu();
        choice = Validation.readAndValidateChoice();

        switch (choice) {
            case 1:
                Display.listDisplay(Songs.getSongs());
                int selection = getSelection(Songs.getSongs());
                SongPlay.playSong(selection);
                break;
            case 2:
                filterBy(Songs.getArtists());
                break;
            case 3:
                filterBy(Songs.getAlbums());
                break;
            case 4:
                filterBy(Songs.getGenres());
                break;
            case 5:
                System.out.print("Write the name of the song and press enter: ");
                songsDisplay = SongSearch.search(sc.nextLine());
                selection = getSelection(songsDisplay);
                SongPlay.findSongNumber(songsDisplay, selection);
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
            Display.cls();
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
        Display.listDisplay(SongsList.removeDuplicate(filterList));
        selection = getSelection(SongsList.removeDuplicate(filterList));
        songsDisplay = SongsList.displaySongs(SongsList.removeDuplicate(filterList), selection, filterList);
        selection = getSelection(songsDisplay);
        SongPlay.findSongNumber(songsDisplay, selection);
    }
}
