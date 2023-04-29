//Hannah Lee
//CSE 122 AB
//TA: Andrew Awada
//February 15, 2023

//Programming Assignment 2: Absurdle
//This program plays a word game with the user
//    trying to stall the game for as long as possible. It compares
//    the characters in the guessed word as well as the list of words
//    and chooses the pattern that prunes the dictionary the smallest 
//    so the a largest amount of words is remaining. If multiple patterns
//    have the same amount of words, the pattern that appears first isEmpty
//    returned.

import java.util.*;
import java.io.*;

public class Absurdle  {
    public static final String GREEN = "🟩";
    public static final String YELLOW = "🟨";
    public static final String GRAY = "⬜";

    // [[ ALL OF MAIN PROVIDED ]]
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the game of Absurdle.");

        System.out.print("What dictionary would you like to use? ");
        String dictName = console.next();

        System.out.print("What length word would you like to guess? ");
        int wordLength = console.nextInt();

        List<String> contents = loadFile(new Scanner(new File(dictName)));
        Set<String> words = pruneDictionary(contents, wordLength);

        List<String> guessedPatterns = new ArrayList<>();
        while (!isFinished(guessedPatterns)) {
            System.out.print("> ");
            String guess = console.next();
            String pattern = record(guess, words, wordLength);
            guessedPatterns.add(pattern);
            System.out.println(": " + pattern);
            System.out.println();
        }
        System.out.println("Absurdle " + guessedPatterns.size() + "/∞");
        System.out.println();
        printPatterns(guessedPatterns);
    }

    // [[ PROVIDED ]]
    // Prints out the given list of patterns.
    // - List<String> patterns: list of patterns from the game
    public static void printPatterns(List<String> patterns) {
        for (String pattern : patterns) {
            System.out.println(pattern);
        }
    }

    // [[ PROVIDED ]]
    // Returns true if the game is finished, meaning the user guessed the word. Returns
    // false otherwise.
    // - List<String> patterns: list of patterns from the game
    public static boolean isFinished(List<String> patterns) {
        if (patterns.isEmpty()) {
            return false;
        }
        String lastPattern = patterns.get(patterns.size() - 1);
        return !lastPattern.contains("⬜") && !lastPattern.contains("🟨");
    }

    // [[ PROVIDED ]]
    // Loads the contents of a given file Scanner into a List<String> and returns it.
    // - Scanner dictScan: contains file contents
    public static List<String> loadFile(Scanner dictScan) {
        List<String> contents = new ArrayList<>();
        while (dictScan.hasNext()) {
            contents.add(dictScan.next());
        }
        return contents;
    }

    // this method prunes the given list into a set so that all of the words inside the
    //      set are the length the user wants. If the length the user wants is less than
    //      1, the method throws an IllegalArgumentException.
    // parameters:
    //      - List<String> contents: the list of words to check their length
    //      - int wordLength: the length the user wants the words in the set to boolean
    // returns:
    //      - Set<String> modified: the new set with the words that are the wordLength
    //              specified by wordLength
    public static Set<String> pruneDictionary(List<String> contents, int wordLength) {
        if(wordLength < 1){
            throw new IllegalArgumentException();
        }
        Set<String> modified = new TreeSet<>();
        for(int i = 0; i < contents.size(); i++){
            if((contents.get(i)).length() == wordLength){
                modified.add(contents.get(i));
            }
        }
        System.out.println(modified);
        return modified;
    }

    // this method finds the patterns of the words in the given set and returns
    //     the pattern that is associated with the most amount of words in order
    //     to prune the remaining list of words as little as possible. if the set of words
    //     is empty or the length of the guess isn't equal to the wordLength, the
    //     method throws an IllegalArgumentException. if there are two patterns that have
    //     the most amount of words associated to it, the method returns the pattern that
    //     occurs first.
    // parameters:
    //     - String guess: the user's guess 
    //     - Set<String> words: The set containing the words left for the user to guess
    //     - int wordLength: the length of the words that the words in the set should be
    // returns:
    //     - String comPat: the pattern associated with the most amount of words
    //          in the Set words.
    public static String record(String guess, Set<String> words, int wordLength) {
        if(words.size() < 1 || (guess.length() != wordLength)){
            throw new IllegalArgumentException();
        }
        Map<String, Set<String>> patterns = new TreeMap<>();
        for(String word : words){
            String pattern = patternFor(word, guess);
            if(!patterns.containsKey(pattern)){
                patterns.put(pattern, new TreeSet<>());
            }
            patterns.get(pattern).add(word);
        }

        int max = 0;
        String comPat = "";
        Set<String> newWords = null;
        for(String pattern: patterns.keySet()){
            if(patterns.get(pattern).size() > max){
                max = patterns.get(pattern).size();
                comPat = pattern;
                newWords = patterns.get(pattern);
            }
        }
        replace(words, newWords);
        return comPat;
    }

    // this method is a helper method that clears the Set words and replaces
    //      the elements inside with the new words in newWords.
    // parameters:
    //      - Set<String> words: the set of words that needs to be cleared
    //            and replaced
    //      - Set<String> newWords: the Set that is replacing the elements
    //            in the Set words.
    public static void replace(Set<String> words, Set<String> newWords){
        words.clear();
        for(String word: newWords){
            words.add(word);
        }
    }
    
    // this method makes patterns for the words regarding the guess made by
    //      the user. if a character in the guess is in the same index as the
    //      word, then there should be a green square in the place of the character
    //      in the pattern. if the character in the guess is in the word but in the
    //      wrong place, there should be a yellow square representing that in the pattern.
    //      if there is no similarity between the guess and word, the pattern should have 
    //      a gray square.
    // parameters: 
    //      - String word: the word that is being compared to the guess to create a pattern
    //      - String guess: the user's guess 
    // returns:
    //      - String guess: the variable guess that has been altered so that in the place
    //              of the original characters, the pattern is being returned instead.
    public static String patternFor(String word, String guess) {
        for(int j = 0; j < guess.length(); j++){
            if(guess.charAt(j) == word.charAt(j)){
                guess = guess.substring(0, j) + "!" + guess.substring(j + 1);
                word = word.substring(0, j) + "!" + word.substring(j + 1);
            }
        }

        for(int k = 0; k < guess.length(); k++){
            if (guess.charAt(k) != '!' && word.contains("" + guess.charAt(k))){
                String temp = "" + guess.charAt(k);
                word = word.replaceFirst(temp, "*");
                guess = guess.replaceFirst(temp, "*");
            }
        } 

        for(int l = 0; l < guess.length(); l++){
            if(guess.charAt(l) != '!' && guess.charAt(l) != '*'){
                guess = guess.substring(0, l) + '%' + guess.substring(l + 1);
            }
        }

        guess = guess.replace("!", GREEN);
        guess = guess.replace("*", YELLOW);
        guess = guess.replace("%", GRAY);
        return guess;
    }
}
