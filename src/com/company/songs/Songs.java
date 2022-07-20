package com.company.songs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Songs {

    static ArrayList<String> songs = new ArrayList<>();
    static ArrayList<String> artists = new ArrayList<>();
    static ArrayList<String> albums = new ArrayList<>();
    static ArrayList<String> genres = new ArrayList<>();
    static ArrayList<String> songFile = new ArrayList<>();
    static ArrayList<String> clipArt = new ArrayList<>();

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
    public void list() {
        try {
            List<String> splitList;
            File file = new File("assets/data.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                splitList = Arrays.asList(scan.nextLine().split(","));
                songs.add(splitList.get(0));
                artists.add(splitList.get(1));
                albums.add(splitList.get(2));
                genres.add(splitList.get(3));
                songFile.add(splitList.get(4));
                clipArt.add(splitList.get(5));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}