//Hannah Lee
//CSE 122 AB
//TA: Andrew Awada
//February 23, 2023

//Creative Assignment 2: Twitter Trends
//This class is where the analysis methods for TweetBot are made

import java.util.*;
import java.io.*;

public class TwitterTrends {
    private TweetBot bot;

    // this method is the constructor that initializes this TwitterTrends 
    //      with the given TweetBot for analysis
    // parameters: 
    //      - TweetBot bot: to make a TweetBot for analysis
    // returns:
    //      - none
    public TwitterTrends(TweetBot bot){
        this.bot = bot;
    }

    // this method iterates through the tweets and finds the most common word
    // parameters:
    //      - none
    // returns:
    //      - String mostFrequentWord: the word that appears the most in 
    //              the tweets.
    public String getMostFrequentWord(){
        Map<String, Integer> wordCount = new TreeMap<String, Integer>();
        for(int i = 0; i < bot.numTweets(); i++) {
            String tweet = bot.nextTweet().toLowerCase();
            Scanner scanner = new Scanner(tweet);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
        }
        String mostFrequentWord = "";
        int max = 0;
        for(String word : wordCount.keySet()){
            if(wordCount.get(word) > max){
                max = wordCount.get(word);
                mostFrequentWord = word;
            }
        }
        return mostFrequentWord;
    }

    // this method determines whether or not the tweets contain misinformation
    //      about covid-19 at all. if the method senses any misinformation, it 
    //      immediately returns true for misinformation.
    // parameters:
    //      - none
    // returns:
    //      - boolean: whether or not there is misinformation in the tweets
    public boolean misinfo(){
        Map<String, Integer> wordCount = new TreeMap<String, Integer>();
        for(int i = 0; i < bot.numTweets(); i++) {
            String tweet = bot.nextTweet().toLowerCase();
            Scanner scanner = new Scanner(tweet);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
        }
        if(wordCount.containsKey("covid")){
            if(wordCount.containsKey("fake") || 
                wordCount.containsKey("propaganda") ||
                wordCount.containsKey("")){
                    return true;
            }
        }
        return false;
    }
}
