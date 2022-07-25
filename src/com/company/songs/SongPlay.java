package com.company.songs;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static com.company.songs.Songs.*;

public class SongPlay {
    /**
     * This method plays the song which is selected by the user
     *
     * @param selection option to play the song
     */
    public static void playSong(int selection) {
        String songName;
        String clipartName;
        try {
            songName = getSongFile().get(selection - 1);
            clipartName = getClipArt().get(selection - 1);
            File song = new File("assets\\songs\\" + songName);
            File image = new File("assets\\albums\\" + clipartName);
            if (!image.exists()) {
                image = new File("assets\\no-picture.png");
            }
            Desktop d = Desktop.getDesktop();
            if (song.exists()) {
                System.out.println("Playing a song!");
                d.open(song);
                d.open(image);
            } else {
                System.out.println("Could not play the Song !");
            }
        } catch (Exception evt) {
            System.out.println("Could not play the Song !");
        }
    }

    /**
     * This method finds the song in original array and plays the song.
     *
     * @param filterList List to choose the song
     * @param selection  option to play song in the list
     */
    public static void findSongNumber(ArrayList<String> filterList, int selection) {
        String song = filterList.get(selection - 1);
        for (int i = 0; i < getSongs().size(); i++) {
            if (song.equals(getSongs().get(i))) {
                playSong(i + 1);
            }
        }
    }
}
