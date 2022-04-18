package com.packagechallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String author;
    private String albumTitle;
    private List<Song> songs;

    public Album(String author, String albumTitle) {
        this.author = author;
        this.albumTitle = albumTitle;
        this.songs = new ArrayList<>();
    }

    public void addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
        } else {
            System.out.println("Song is already in the album.");
        }
    }

    private Song findSong(String title) {
        for(Song checkedSong : this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        } else {
            System.out.println("Song is not in the album.");
            return false;
        }

    }
}
