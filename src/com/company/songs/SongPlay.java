package com.company.songs;

import com.company.Filter;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static com.company.songs.Songs.*;

public class SongPlay {
    /**
     * This method finds the song in list and plays the song.
     *
     * @param filterList List to choose the song
     */
    public static void playSong(ArrayList<String> filterList) {
        boolean validInput = false;
        while (!validInput) {
            int selection = Filter.selection(filterList);

            String song = filterList.get(selection - 1);
            for (int i = 0; i < getSongs().size(); i++) {
                if (song.equals(getSongs().get(i))) {
                    String songName;
                    String clipartName;
                    try {
                        songName = getSongFile().get(i);
                        clipartName = getClipArt().get(i);
                        if (songName.contains(".mp3")) {
                            File songFile = new File("assets\\songs\\" + songName);
                            File image = new File("assets\\albums\\" + clipartName);
                            if (!image.exists()) {
                                image = new File("assets\\no-picture.png");
                            }
                            Desktop d = Desktop.getDesktop();
                            if (songFile.exists()) {
                                System.out.println("Playing a song!");
                                d.open(songFile);
                                d.open(image);
                                validInput = true;
                            }
                        } else {
                            System.out.println("Could not play the Song !");
                            System.out.print(" Choose an option and press enter: ");
                        }
                    } catch (Exception evt) {
                        System.out.println("Could not play the Song !");
                    }
                }
            }
        }
    }
}