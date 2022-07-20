package com.company.songs;

import com.company.Display;

import java.util.ArrayList;

import static com.company.songs.Songs.getSongs;

public class SongSearch {
    /**
     * This method search the song in the songs List
     *
     * @param keyword word to search the song
     * @return list of songs available in the original list with keyword
     */
    public static ArrayList<String> search(String keyword) {
        ArrayList<String> updatedSongs = new ArrayList<String>();
        for (int i = 0; i < getSongs().size(); i++) {
            if ((getSongs().get(i).toLowerCase()).contains(keyword.toLowerCase())) {
                updatedSongs.add((getSongs().get(i)));
            }
        }
        if (updatedSongs.size() != 0) {
            Display.listDisplay(updatedSongs);
        } else {
            System.out.println("No songs found related to " + keyword);
            System.exit(1);
        }
        return updatedSongs;
    }
}
