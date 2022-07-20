package com.company;

import com.company.songs.Songs;

public class Main {
    static Songs songs = new Songs();

    public static void main(String[] args) {
        songs.list();
        Display.cls();
        ChooseOption.mainDisplay();
    }
}