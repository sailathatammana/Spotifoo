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

    public static void list() {
        try {
            List<String> test = null;
            File file = new File("D:/SDA/GitHub/Spotifoo/assets/data.txt");
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

    public void listDisplay(ArrayList<String> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.println("[" + i + "]" + " " + list.get(i - 1));
        }
        System.out.print(" Choose an option and press enter: ");
    }


    public void playSong(int selection) {
        String songName = null;
        String clipartName = null;
        try {
            songName = songFile.get(selection - 1);
            clipartName = clipArt.get(selection - 1);
            File song = new File("D:\\SDA\\GitHub\\Spotifoo\\assets\\songs\\" + songName);
            File image = new File("D:\\SDA\\GitHub\\Spotifoo\\assets\\albums\\" + clipartName);
            System.out.println(song);
            System.out.println(image);
            Desktop d = Desktop.getDesktop();
            d.open(song);
            d.open(image);
        } catch (Exception evt) {
            System.out.println("Could not play the Song !");
        }
    }

    public ArrayList<String> songSearch(String keyword) {
        ArrayList<String> updatedSongs = new ArrayList<String>();
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).contains(keyword)) {
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

    public void findSongNumber(ArrayList<String> T, int selection) {
        String song = T.get(selection - 1);
        for (int i = 0; i < songs.size(); i++) {
            if (song.equals(songs.get(i))) {
                playSong(i + 1);
            }
        }
    }

}