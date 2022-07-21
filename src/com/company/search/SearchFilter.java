package com.company.search;

import com.company.Filter;
import com.company.songs.*;
import com.company.validations.FilterValidation;

import java.util.ArrayList;

public class SearchFilter {
    static ArrayList<String> songsDisplay;
    static int select;
    static String keyword;

    /**
     * This method search the song using keyword provided by user and plays the song
     */
    public static void searchBy(ArrayList<String> list) {
        keyword = FilterValidation.validateString();
        songsDisplay = SearchSong.search(keyword, list);
        select = Filter.selection(songsDisplay);
        SongPlay.findSongNumber(songsDisplay, select);
    }
}
