import java.util.*;
import java.io.*;

//Hannah Lee
//CSE 122 AB
//TA: Andrew Awada
//January 24, 2023
//Programming Assignment 1: Music Playlist
//This program creates a playlist of songs based on the user's
//      input and prompts the user if they want to add more songs, play,
//      print, clear history, or delete from history.

public class MusicPlaylist {
    // TODO: Your Code Here
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String option = "";
        Queue<String> playlist = new LinkedList<>();
        Stack<String> history = new Stack<>();
        System.out.println("Welcome to the CSE 122 Music Playlist!");
        introMessage();
        option = console.nextLine();
        while(!option.equalsIgnoreCase("Q")){
            if(option.equalsIgnoreCase("A")) {
                addSong(console, playlist);
            } else if(option.equalsIgnoreCase("P")){
                playSong(playlist, history);
            } else if(option.equalsIgnoreCase("Pr")){
                printHistory(history);
            } else if(option.equalsIgnoreCase("C")){
                clearHistory(history);
            } else if(option.equalsIgnoreCase("D")) {
                deleteSong(console, history);
            }
            System.out.println();
            System.out.println();
            introMessage();
            option = console.nextLine();
        }
    }

    // this method prints the statements prompting the user for their
    //      choice and what they want to do 
    // parameters:
    //      - none
    // returns:
    //      - none
    public static void introMessage(){
        System.out.println("(A) Add song");
        System.out.println("(P) Play song");
        System.out.println("(Pr) Print history");
        System.out.println("(C) Clear history");
        System.out.println("(D) Delete from history");
        System.out.println("(Q) Quit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    // this method prompts the user to enter a song name and then adds
    //      the song to the playlist.
    // parameters:
    //      - Scanner console: allows for user input
    //      - Queue<String> playlist: the queue that contains the songs
    //          in the playlist
    // returns:
    //      - none
    public static void addSong(Scanner console, Queue<String> playlist){
        System.out.print("Enter song name: ");
        String song = console.nextLine();
        playlist.add(song);
        System.out.println("Successfully added " + song);
    }

    // this method gets the first song in the playlist and adds the song to
    //      the history stack unless the playlist is empty. throws an IllegalStateException
    //      if the playlist size is less than one because there are no songs
    //      to play
    // parameters:
    //      - Queue<String> playlist: the queue that contains the songs
    //           in the playlist
    //      - Stack<String> history: the history that contains the songs
    //           already played in the playlist
    // returns:
    //      - none
    public static void playSong(Queue<String> playlist, Stack<String> history){
        if(playlist.size() < 1){
            throw new IllegalStateException();
        }
        System.out.println("Playing song: " + playlist.peek());
        history.add(playlist.peek());
        playlist.remove();
    }

    // this method prints the elements in the history Stack unless the
    //      number of songs the user wishes to remove is greater than the
    //      size of the stack or if the stack is empty. throws an IllegalStateException
    //      if the history size is less than one because there is no song to play.
    // parameters:
    //      - Stack<String> history:the history that contains the songs
    //           already played in the playlist
    // returns:
    //      - none
    public static void printHistory(Stack<String> history){
        if(history.size() < 1){
            throw new IllegalStateException();
        }
        Stack<String> tempHist = new Stack<>();
        int length = history.size();
        for(int i = 0; i < length; i++){
            tempHist.push(history.peek());
            System.out.println("    " + history.pop());
        }
        for(int i = 0; i < length; i++){
            history.push(tempHist.pop());
        }
    }

    // this method removes all the elements in the history stack
    // parameters:
    //      - Stack<String> history: the history that contains the songs
    //           already played in the playlist
    // returns:
    //      - none
    public static void clearHistory(Stack<String> history){
        int length = history.size();
        for(int i = 0; i < length; i++){
            history.pop();
        }
    }

    // this method removes songs from the history Stack unless the absolute value
    //      of number of songs the user wants to remove is greater than the size of
    //      the history stack. if the number of songs the user wants to remove is 
    //      positive, the songs will start deleting from the top of the history stack.
    //      if it is negative, the songs will start deleting from the beginning of the
    //      history stack. throws and IllegalArgumentException if the absolute value of 
    //      number of songs the user wants to delete is more than the size of the history.
    // parameters:
    //      - Scanner console: allows for user input
    //      - Stack<String> history: the history that contains the songs
    //           already played in the playlist
    public static void deleteSong(Scanner console, Stack<String> history){
        System.out.println("A positive number will delete from recent history.");
        System.out.println("A negative number will delete from the beginning of history.");
        System.out.print("Enter number of songs to delete: ");
        int numSongs = Integer.parseInt(console.nextLine());
        if(Math.abs(numSongs) > history.size()){
            throw new IllegalArgumentException();
        }
        if(numSongs > 0){
            for(int i = 0; i < numSongs; i++){
                history.pop();
            }
        } else {
            Stack<String> tempHist = new Stack<>();
            int length = history.size();
            for(int i = 0; i < length; i++){
                tempHist.push(history.pop());
            }
            for(int i = 0; i < Math.abs(numSongs); i++){
                tempHist.pop();
            }
            int tempLength = tempHist.size();
            for(int i = 0; i < tempLength; i++){
                history.push(tempHist.pop());
            }
        }
    }
}
