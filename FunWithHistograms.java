import java.util.*;
import java.io.*;

//Hannah Lee
//TA: Melody Lam
//Programming Assignment 3: It's Data Time!
//Dec 4, 2022
//This class prompts the user for an input file containing a dataset and will then
//    process the dataset and generate a text-based histogram. The program
//    will compute and print some summary statistics of the data: the number of values
//    read, the mean and the mode.



public class FunWithHistograms{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner s = new Scanner(System.in);
        welcomeMessage();
        System.out.println();
        int[] dataArray = inputPrompt(s);
        int[] occurances = getOccurances(dataArray);
        getAverage(occurances);
        System.out.println();
        drawHistogram(occurances);
        System.out.println();
        sumStats(dataArray, occurances);

    }

    //method to print welcome message
    //  no parameters or return variables
    public static void welcomeMessage(){
        System.out.println("The program will analyze data from a dataset of\n"
            + "non-negative integer values. It will produce a\n"
            + "histogram of the data and output some statistics.");
    }

    //method to prompt user for input file
    //  parameters: Scanner
    //  return: int array
    public static int[] inputPrompt(Scanner s) throws FileNotFoundException{
        System.out.print("input file name? ");
        String inputFile = s.nextLine();
        Scanner fileScan = new Scanner(new File(inputFile)); 
        int arrayLength = fileScan.nextInt();
        int[] dataSet = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            int data = fileScan.nextInt();
            dataSet[i] = data;
        }
        return dataSet;
    }

    //method to find index of max value
    //  parameters: int array
    //  return: index of max value
    public static int getMaxIndex(int[] dataArray){
        int maxValue = 0;
        int maxIndex = 0;
        for(int i = 0; i < dataArray.length; i++){
            if(dataArray[i] > maxValue){
                maxIndex = i;
                maxValue = dataArray[i];
            }
        }
        return maxIndex;
    }

    //method to count each number's occurance in the array
    //  parameters: int array
    //  return: new array with number of occurances
    public static int[] getOccurances(int[] dataArray){
        int maxValue = dataArray[getMaxIndex(dataArray)];
        int[] occurances = new int[maxValue + 1];
        for(int i = 0; i <= maxValue; i++){
            int count = 0;
            for(int j = 0; j < dataArray.length; j++){
                if(dataArray[j] == i){
                    count++;
                }
            }
            occurances[i] = count;
        }
        return occurances;
    } 

    //method to find average of values in array
    //  parameters: array containing occurances of each number
    //  return: double of average value
    public static double getAverage(int[] occurances){
        int total = 0;
        int sum = 0;
        for(int i = 0; i < occurances.length; i++){
            sum += i * occurances[i];
            total += occurances[i];
        }
        double average = (double) sum / total;
        return average;
    }

    //method to print out histogram
    //  parameters: array containing occurances of each number
    //  no return value
    public static void drawHistogram(int[] occurances){
        for(int i = 0; i < occurances.length; i++){
            System.out.print(i + "| ");
            for(int j = 0; j < occurances[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //method to print summary statistics
    //  parameters: data array and array containing occurances
    //  no return value
    public static void sumStats(int[] dataArray, int[] occurances){
        System.out.println("Num. Values: " + dataArray.length);
        //call method 3 to find mean
        System.out.println("Mean: " + getAverage(occurances));
        //call method 5 to find greatest number of occurances
        int mode = getMaxIndex(occurances);
        System.out.println("Mode: " + mode);
    }
}
