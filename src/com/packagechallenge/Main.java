package com.packagechallenge;

import java.util.*;

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

	    printOptions();
	    play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in the playlist");
        } else {
            System.out.println("The first song of the playlist: " + listIterator.next().toString());
        }

        while(!exit) {
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    System.out.println("Playlist complete");
                    exit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next().toString();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("We are playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous().toString();
                        }
                        forward = false;
                    }

                    if(listIterator.hasPrevious()) {
                        System.out.println("We are playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("We have reached the beginning of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("We are replaying: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the beginning of the playlist");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("We are replaying: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We are at the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    System.out.println("==================");
                    System.out.println("Our playlist: ");
                    for(Song songs : playList) {
                        System.out.println(songs);
                    }
                    System.out.println("==================");
                    break;
            }
        }

    }

    public static void printOptions() {
        System.out.println("=================");
        System.out.println("This is a playlist of songs. Please enter your choice");
        System.out.println("0 - Exit \n" +
                "1 - Next song\n" +
                "2 - Previous song\n" +
                "3 - Replay current song\n" +
                "4 - Print the list");
    }
}
