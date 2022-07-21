package com.company.search;

import com.company.Display;

import java.util.ArrayList;

import static com.company.songs.Songs.getSongs;

public class SearchSong {
    /**
     * This method search the song in the songs List
     *
     * @param keyword word to search the song
     * @return list of songs available in the original list with keyword
     */
    public static ArrayList<String> search(String keyword, ArrayList<String> list) {
        Display.cls();
        ArrayList<String> updatedList = new ArrayList<>();
        System.out.println("Songs menu :");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).toLowerCase()).contains(keyword.toLowerCase())) {
                updatedList.add(getSongs().get(i));
            }
        }
        if (updatedList.size() != 0) {
            Display.listDisplay(updatedList);
        } else {
            System.out.println("Nothing found related to " + keyword);
            System.exit(1);
        }
        return updatedList;
    }
}
