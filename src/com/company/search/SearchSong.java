package com.company.search;

import com.company.Display;
import com.company.songs.SongsList;

import java.util.ArrayList;

import static com.company.songs.Songs.*;

public class SearchSong {
    /**
     * This method search the song in the songs List
     *
     * @param keyword word to search the song
     * @return list of songs available in the original list with keyword
     */
    public static ArrayList<String> search(String keyword) {
        Display.cls();
        ArrayList<String> updatedList = new ArrayList<>();
        ArrayList<String> songsList;
        System.out.println("Songs menu :");
        for (int i = 0; i < getSongs().size(); i++) {
            if ((getSongs().get(i).toLowerCase()).contains(keyword.toLowerCase())) {
                updatedList.add(getSongs().get(i));
            }
        }
        for (int i = 0; i < getArtists().size(); i++) {
            if ((getArtists().get(i).toLowerCase()).contains(keyword.toLowerCase())) {
                updatedList.add(getSongs().get(i));
            }
        }
        for (int i = 0; i < getAlbums().size(); i++) {
            if ((getAlbums().get(i).toLowerCase()).contains(keyword.toLowerCase())) {
                updatedList.add(getSongs().get(i));
            }
        }
        songsList = SongsList.removeDuplicate(updatedList);
        if (songsList.size() != 0) {
            Display.listDisplay(songsList);
        } else {
            System.out.println("No songs found related to " + keyword);
            System.exit(1);
        }
        return songsList;
    }
}
