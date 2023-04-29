import java.util.*;

//Hannah Lee
//Quiz Section: AB
//TA: Andrew Awada
//Programming Assignment 0: census
//this program prompts for ages of a population and then prints
//  the average of all the ages. the program will keep running
//  until a negative number is inputted.

public class Census{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Census!");
        agePrompt(console);
    }

    //this method prompt the user for multiple ages until a negative
    //  number is inputted. it finds the sum of the inputted ages and
    //  the number of ages.
    //parameters
    //  - Scanner console: to allow the user to input the ages
    public static void agePrompt(Scanner console){
        System.out.println("Input the ages of the population and we will"
            + " compute the average age");
        int age = 0;
        int count = 0;
        double sum = 0.0;
        while(age >= 0){
            System.out.print("Next person's age (negative to quit)? ");
            age = console.nextInt();
            if(age >= 0){
                sum += age;
                count ++;
            }
        }
        getAvg(sum, count);
    }

    //this method finds and prints the average of the inputted ages
    //  parameters
    //  - double sum: the sum of the ages
    //  - int count: the number of ages that were inputted
    public static void getAvg(double sum, int count){
        double avg = sum / count;
        System.out.println("The average age is " + avg);
    }
}
