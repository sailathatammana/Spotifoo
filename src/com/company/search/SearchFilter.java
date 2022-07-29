package com.company.search;

import com.company.songs.*;

import java.util.ArrayList;

public class SearchFilter {
    static ArrayList<String> songsDisplay;

    /**
     * This method search the song using keyword provided by user and plays the song
     */
    public static void searchBy() {
        System.out.println("Search for a song a song:");
        System.out.print("Write the name of a song and press enter:");
        songsDisplay = SearchSong.search();
        SongPlay.playSong(songsDisplay);
    }
}