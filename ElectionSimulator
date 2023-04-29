//Hannah Lee
//CSE 121 
//Section BP
//TA: Melody Lam
//Programming Assignment 1: Election Simulator
//the program simulates an election poll and returns the average of every simulation for the candidate we care about

import java.util.*;

public class ElectionSimulator {
    //declare class constants
    public static final int NUM_SIMS = 5;
    public static final int NUM_DISTS = 10;
    public static final double POLL_AVG = .52;
    public static final double POLL_ERR = .07;

    public static void main(String[] args){

        //instantiate a random object
        Random r = new Random();
        //print opening statement
        System.out.println("Welcome to the Election Simulator!");
        System.out.println("Running " + NUM_SIMS 
            + " simulations of " + NUM_DISTS + " districts.");
        System.out.println("Our candidate is polling at " + (POLL_AVG * 100) 
            + "% with a " + (POLL_ERR * 100) + "% margin of error.");

        System.out.println();

        //create variable to store the number of total percentage for the candidate
        double totalPercentage = 0;
        //find voting percentage for 10 simulations
        for(int i = 1; i <= NUM_SIMS; i++){
            System.out.println("Running simulation #" + i +":");
            int districtVotes = 0;
            int totalCandVotes = 0;
            //find number of voters for the districts
            for(int k = 0; k < NUM_DISTS; k++){
                int totalVoters = r.nextInt(1000) + 1;
                double candidateVoters = totalVoters*(POLL_AVG 
                    + (r.nextGaussian() * 0.5 * POLL_ERR));
                districtVotes += totalVoters;
                totalCandVotes += candidateVoters;
            }
            //find opposition voters
            int oppositionVoters = districtVotes - totalCandVotes;
            //calculate percentage of candidate voters for this simulation
            double candidatePercentage = (totalCandVotes * 100.0) / districtVotes;
            totalPercentage += candidatePercentage;

            //determine if they won or lost
            winOrLose(candidatePercentage);

            //print result statement
            results(districtVotes, totalCandVotes, candidatePercentage, oppositionVoters);

            //System.out.println();
            visualization(totalCandVotes, oppositionVoters);
            System.out.println();
        }
        System.out.println();
        //calculate average percentage of candidate voters for all the simulations
        double averagePercentage = totalPercentage/NUM_SIMS;
        System.out.println("Average vote percentage: " + (averagePercentage + "%"));
    }

    public static void winOrLose(double candidatePercentage){
        boolean wL = candidatePercentage > 50.0;
        System.out.println("  Win? " + wL);
    }

    public static void results(int districtVotes, double totalCandVotes, 
    double candidatePercentage, int oppositionVoters){
        double opponentPercentage = 100 - candidatePercentage;
        System.out.println("  Results: " + (int) totalCandVotes + " (" 
            + candidatePercentage + "%) - " + oppositionVoters + " (" 
            + opponentPercentage + "%)");
    }

    public static void visualization(double totalCandVotes, 
    double oppositionVoters){
        int pluses = (int) totalCandVotes/100;
        int minuses = (int) oppositionVoters/100;
        System.out.print("  Visualization: ");
        for(int i = 0; i < pluses; i++){
            System.out.print("+");
        }
        System.out.println();
        System.out.print("                 ");
        for(int i = 0; i < minuses; i++){
            System.out.print("-");
        }
    }
}
