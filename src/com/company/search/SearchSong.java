package com.company.search;

import com.company.Display;
import com.company.validations.FilterValidation;

import java.util.ArrayList;

import static com.company.songs.Songs.*;

public class SearchSong {
    /**
     * This method search the song in the songs List
     *
     * @return list of songs available in the original list with keyword
     */
    public static ArrayList<String> search() {
        ArrayList<String> updatedList = new ArrayList<>();
        String keyword;
        boolean validInput = false;
        while (!validInput) {
            keyword = FilterValidation.validateString();
            for (int i = 0; i < getSongs().size(); i++) {
                if ((getSongs().get(i).toLowerCase()).contains(keyword.toLowerCase())) {
                    updatedList.add(getSongs().get(i));
                }
            }
            if (updatedList.size() != 0) {
                Display.cls();
                System.out.println("Songs menu :");
                Display.listDisplay(updatedList);
                validInput = true;
            } else {
                System.out.println("No songs found related to " + keyword);
                System.out.print("Search for a song by song name, artist, album :");
            }
        }
        return updatedList;
    }
}