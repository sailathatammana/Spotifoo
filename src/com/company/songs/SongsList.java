package com.company.songs;

import com.company.Display;

import java.util.ArrayList;

import static com.company.songs.Songs.*;

public class SongsList {

    /**
     * This method used to remove the duplicate values from the list
     *
     * @param originalList List which contains the duplicate values
     * @return Deduplicate list
     */
    public static ArrayList<String> removeDuplicate(ArrayList<String> originalList) {
        ArrayList<String> updatedList = new ArrayList<>();
        for (int i = 0; i < originalList.size(); i++) {
            if (!updatedList.contains(originalList.get(i))) {
                updatedList.add((originalList.get(i)));
            }
        }
        return updatedList;
    }

    /**
     * This method displays the list of songs based on the selection chosen by the user
     *
     * @param deduplicateList Deduplication list to choose a song
     * @param selection       Choice
     * @param splitList       list of split data
     * @return List of songs by the option selected by user
     */
    public static ArrayList<String> displaySongs(ArrayList<String> deduplicateList, int selection, ArrayList<String> splitList) {
        Display.cls();
        ArrayList<String> songNameList = new ArrayList<>();
        String filter = deduplicateList.get(selection - 1);
        System.out.println("Songs menu :");
        for (int i = 0; i < splitList.size(); i++) {
            if (filter.equals(splitList.get(i))) {
                songNameList.add(getSongs().get(i));
            }
        }
        Display.listDisplay(songNameList);
        return songNameList;
    }
}
