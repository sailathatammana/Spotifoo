package com.company.search;

import com.company.songs.*;

import java.util.ArrayList;

public class SearchFilter {
    static ArrayList<String> songsDisplay;

    /**
     * This method search the song using keyword provided by user and plays the song
     */
    public static void searchBy() {
        songsDisplay = SearchSong.search();
        SongPlay.playSong(songsDisplay);
    }
}
