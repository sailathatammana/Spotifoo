package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SongList {

    static ArrayList<String> songs = new ArrayList<String>();
    static ArrayList<String> artists = new ArrayList<String>();
    static ArrayList<String> albums = new ArrayList<String>();
    static ArrayList<String> genres = new ArrayList<String>();
    static ArrayList<String> songFile = new ArrayList<String>();
    static ArrayList<String> clipArt = new ArrayList<String>();

    public static ArrayList<String> getSongs() {
        return songs;
    }

    public static ArrayList<String> getArtists() {
        return artists;
    }

    public static ArrayList<String> getAlbums() {
        return albums;
    }

    public static ArrayList<String> getGenres() {
        return genres;
    }

    public static ArrayList<String> getSongFile() {
        return songFile;
    }

    public static ArrayList<String> getClipArt() {
        return clipArt;
    }

    /**
     * Method to split the data into list.
     */
    public static void list() {
        try {
            List<String> test = null;
            File file = new File("assets/data.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                test = Arrays.asList(scan.nextLine().split(","));
                songs.add(test.get(0));
                artists.add(test.get(1));
                albums.add(test.get(2));
                genres.add(test.get(3));
                songFile.add(test.get(4));
                clipArt.add(test.get(5));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will display the list of songs, artists, albums, genres to the user
     *
     * @param list List selected by the user
     */
    public void listDisplay(ArrayList<String> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.println("[" + i + "]" + " " + list.get(i - 1));
        }
        System.out.println("[0] Back to main Menu");
        System.out.print(" Choose an option and press enter: ");
    }

    /**
     * This method used to remove the duplicate values from the list
     *
     * @param originalList List which contains the duplicate values
     * @return Deduplicate list
     */
    public static ArrayList<String> removeDuplicate(ArrayList<String> originalList) {
        ArrayList<String> updatedList = new ArrayList<String>();
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
    public ArrayList<String> displaySongs(ArrayList<String> deduplicateList, int selection, ArrayList<String> splitList) {
        ArrayList<String> songNameList = new ArrayList<String>();
        String filter = deduplicateList.get(selection - 1);
        for (int i = 0; i < splitList.size(); i++) {
            if (filter.equals(splitList.get(i))) {
                songNameList.add(getSongs().get(i));
            }
        }
        listDisplay(songNameList);
        return songNameList;
    }

    /**
     * This method plays the song which is selected by the user
     *
     * @param selection option to play the song
     */
    public void playSong(int selection) {
        String songName = null;
        String clipartName = null;
        try {
            songName = getSongFile().get(selection - 1);
            clipartName = getClipArt().get(selection - 1);
            File song = new File("assets\\songs\\" + songName);
            File image = new File("assets\\albums\\" + clipartName);
            if (!image.exists()) {
                image = new File("assets\\no-picture.png");
            }
            System.out.println(song);
            System.out.println(image);
            Desktop d = Desktop.getDesktop();
            d.open(song);
            d.open(image);
        } catch (Exception evt) {
            System.out.println("Could not play the Song !");
        }
    }

    /**
     * This method search the song in the songs List
     *
     * @param keyword word to search the song
     * @return list of songs available in the original with keyword
     */
    public ArrayList<String> songSearch(String keyword) {
        ArrayList<String> updatedSongs = new ArrayList<String>();
        for (int i = 0; i < songs.size(); i++) {
            if ((songs.get(i).toLowerCase()).contains(keyword.toLowerCase())) {
                updatedSongs.add((songs.get(i)));
            }
        }
        if (updatedSongs.size() != 0) {
            listDisplay(updatedSongs);
        } else {
            System.out.println("No songs found");
        }
        return updatedSongs;
    }

    /**
     * This method finds the song in original array plays the song.
     *
     * @param filterList List to choose the song
     * @param selection  option to play song in the list
     */
    public void findSongNumber(ArrayList<String> filterList, int selection) {
        String song = filterList.get(selection - 1);
        for (int i = 0; i < songs.size(); i++) {
            if (song.equals(songs.get(i))) {
                playSong(i + 1);
            }
        }
    }

}