package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String name, double duration) {

        var song = new Song(name, duration);
        songs.add(song);
        return true;
    }

    public Song findSong(String title) {
        for (var song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }

        return null;
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> list){}
}
