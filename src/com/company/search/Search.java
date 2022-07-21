package com.company.search;

import com.company.Display;
import com.company.Filter;
import com.company.songs.SongPlay;
import com.company.songs.Songs;
import com.company.validations.Validation;

import java.util.ArrayList;

public class Search {
    public static void search() {
        int choice;
        int select;
        SearchDisplay.mainMenu();
        choice = Validation.readAndValidateChoice();
        Display.cls();

        switch (choice) {
            case 1:
                System.out.println("Search for a song name :");
                System.out.print("Write the name of the song and press enter: ");
                SearchFilter.searchBy(Songs.getSongs());
                break;
            case 2:
                System.out.println("Search by artist :");
                System.out.print("Write the name of the artist and press enter: ");
                SearchFilter.searchBy(Songs.getArtists());
                break;
            case 3:
                System.out.println("Search by album :");
                System.out.print("Write the name of the album and press enter: ");
                SearchFilter.searchBy(Songs.getAlbums());
                break;
            default:
                System.out.println("Incorrect choice: Please enter a valid choice");
        }
    }
}
