//Hannah Lee
//Quiz Section: AB
//TA: Andrew Awada
//Programming Assignment 0: mostCommonNucleotide
//this program finds the most common nucleotide in a String
//  representing a strand of DNA

public class DNA {
    public static void main(String[] args) {
        String dna = "ATGCGCACTATGGTAG";
        String mostCommon = mostCommonNucleotide(dna);
        System.out.println(dna + " => " + mostCommon);
    }

    //this method takes in the dna String and returns the most
    //  common nucleotide by using helper methods. in the case
    //  of a tie, the nucleotide that comes first in the order 
    //  is returned of A, C, G, T.
    //parameters
    //  -String dna: the dna strand containing the nucleotides
    //output
    //  -String mostCommon: the most common nucleotide as a string
    public static String mostCommonNucleotide(String dna) {
        int[] nucleotideCounts = countNucleotides(dna);
        return mostCommon(nucleotideCounts);
    }

    //this method takes in the dna string and counts how many
    //  of every nucleotide is in the strand. it then stores the
    //  information in an array from alpahbetical order with index
    //  0 representing the counts for "A"
    //parameters
    //  -String dna: the dna strand containing the nucleotides
    //output
    //  -int[] nucleotideCounts: an array with the counts of
    //      the different nucleotides
    public static int[] countNucleotides(String dna) {
        int[] nucleotideCounts = new int[4];
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'A') {
                nucleotideCounts[0]++;
            }
            if (dna.charAt(i) == 'C') {
                nucleotideCounts[1]++;
            }
            if (dna.charAt(i) == 'G') {
                nucleotideCounts[2]++;
            }
            if (dna.charAt(i) == 'T') {
                nucleotideCounts[3]++;
            }
        }
        return nucleotideCounts;
    }

    //this method determines which nucleotide is the mostCommon
    //  common by going through the array and finding which index
    //  has the highest value.
    //parameters
    //  -int[] nucleotideCounts: the array containing the counts of
    //      the different nucleotides
    //output
    //  -the String of the most common nucleotide
    public static String mostCommon(int[] nucleotideCounts) {
        int maxCount = 0;
        for (int i = 1; i < 4; i++) {
            if (nucleotideCounts[i] > nucleotideCounts[maxCount]) {
                maxCount = i;
            }
        }
        if (maxCount == 0) {
            return "A";
        } else if (maxCount == 1) {
            return "C";
        } else if (maxCount == 2) {
            return "G";
        } else {
            return "T";
        }
    }
}
