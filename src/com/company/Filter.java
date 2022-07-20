package com.company;

import com.company.songs.*;
import com.company.validations.FilterValidation;

import java.util.ArrayList;

public class Filter {
    /**
     * This method checks whether the entered number is valid or not in the given list.
     *
     * @param filterListDisplay list to select the choice
     * @return choice selected by the user
     */
    public static int selection(ArrayList<String> filterListDisplay) {
        int number = FilterValidation.validateChoice(filterListDisplay);
        if (number == 0) {
            Display.cls();
            ChooseOption.mainDisplay();
            System.exit(1);
        }
        return number;
    }

    /**
     * The method used to filter the list based on the user selection
     *
     * @param filterList list which the user want to filter
     */
    public static void filterBy(ArrayList<String> filterList) {
        int selection;
        ArrayList<String> songsDisplay;
        Display.listDisplay(SongsList.removeDuplicate(filterList));
        selection = selection(SongsList.removeDuplicate(filterList));
        songsDisplay = SongsList.displaySongs(SongsList.removeDuplicate(filterList), selection, filterList);
        selection = selection(songsDisplay);
        SongPlay.findSongNumber(songsDisplay, selection);
    }

    /**
     * This method search the song using keyword provided by user and plays the song
     */
    public static void searchBy() {
        String keyword;
        ArrayList<String> songsDisplay;
        int select;
        System.out.print("Write the name of the song and press enter: ");
        keyword = FilterValidation.validateString();
        songsDisplay = SongSearch.search(keyword);
        select = selection(songsDisplay);
        SongPlay.findSongNumber(songsDisplay, select);
    }
}
