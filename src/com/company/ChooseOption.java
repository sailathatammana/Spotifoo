package com.company;

import com.company.songs.*;
import com.company.validations.*;

import java.util.ArrayList;

public class ChooseOption {

    public static void mainDisplay() {
        ArrayList<String> songsDisplay;
        int choice;
        String keyword;
        int select;

        Display.welcomeMsg();
        Display.mainMenu();
        choice = Validation.readAndValidateChoice();
        Display.cls();

        switch (choice) {
            case 1:
                System.out.println("Songs menu :");
                Display.listDisplay(Songs.getSongs());
                select = Filter.selection(Songs.getSongs());
                SongPlay.playSong(select);
                break;
            case 2:
                System.out.println("Artists available :");
                Filter.filterBy(Songs.getArtists());
                break;
            case 3:
                System.out.println("Albums available :");
                Filter.filterBy(Songs.getAlbums());
                break;
            case 4:
                System.out.println("Genres available :");
                Filter.filterBy(Songs.getGenres());
                break;
            case 5:
                System.out.println("Search for a song");
                System.out.print("Write the name of the song and press enter: ");
                keyword = FilterValidation.validateString();
                songsDisplay = SongSearch.search(keyword);
                select = Filter.selection(songsDisplay);
                SongPlay.findSongNumber(songsDisplay, select);
                break;
            case 6:
                System.out.println("Good Bye");
                break;
            default:
                System.out.println("Incorrect choice: Please enter a valid choice");
        }
    }
}