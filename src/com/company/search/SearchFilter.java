package com.company.search;

import com.company.songs.*;
import com.company.validations.FilterValidation;

import java.util.ArrayList;

public class SearchFilter {
    static ArrayList<String> songsDisplay;
    static String keyword;

    /**
     * This method search the song using keyword provided by user and plays the song
     */
    public static void searchBy() {
        keyword = FilterValidation.validateString();
        songsDisplay = SearchSong.search(keyword);
        //select = Filter.selection(songsDisplay);
        SongPlay.playSong(songsDisplay);
    }
}
