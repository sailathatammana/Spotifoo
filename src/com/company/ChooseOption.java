package com.company;

import com.company.search.SearchFilter;
import com.company.songs.*;
import com.company.validations.*;

public class ChooseOption {

    public static void mainDisplay() {
        int choice;

        Display.mainMenu();
        choice = Validation.readAndValidateChoice();
        Display.cls();

        switch (choice) {
            case 1:
                System.out.println("Songs menu :");
                Display.listDisplay(Songs.getSongs());
                //select = Filter.selection(Songs.getSongs());
                //SongPlay.playSong(select);*/
                SongPlay.playSong(Songs.getSongs());
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
                System.out.print("Search for a song by song name, artist, album :");
                SearchFilter.searchBy();
                break;
            case 6:
                System.out.println("Good Bye");
                break;
            default:
                System.out.println("Incorrect choice: Please enter a valid choice");
        }
    }
}