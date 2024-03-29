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
        SongPlay.playSong(songsDisplay);
    }
}