package com.packagechallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

	    Album album = new Album("Trivium", "In The Court Of The Dragon");
	    album.addSong("The Shadow Of The Abattoir", 7.12);
	    album.addSong("Like A Sword Over Damocles", 5.30);
	    album.addSong("In The Court Of The Dragon", 5.10);
	    album.addSong("A Crisis Of Revelation", 5.36);
	    album.addSong("No Way Back Just Through", 3.54);

	    albums.add(album);

	    album = new Album("Arch Enemy", "Deceiver");
	    album.addSong("Deceiver, Deceiver", 3.52);
	    album.addSong("Handshake with Hell", 5.39);
	    album.addSong("House of Mirrors", 3.41);

	    albums.add(album);

	    LinkedList<Song> playList = new LinkedList<>();
	    albums.get(0).addToPlayList("In The Court Of The Dragon", playList);
	    albums.get(0).addToPlayList("Like A Sword Over Damocles", playList);
	    albums.get(0).addToPlayList("The Shadow Of The Abattoir", playList);
	    albums.get(0).addToPlayList("Catastrophist", playList);
	    albums.get(1).addToPlayList("Deceiver, Deceiver", playList);
	    albums.get(1).addToPlayList("House of Mirrors", playList);
	    albums.get(1).addToPlayList("Handshake with Hell", playList);
	    albums.get(1).addToPlayList("The Eagle Flies Alone", playList);

    }
}
