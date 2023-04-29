import java.util.*;

//Hannah Lee
//10.11.2022
//TA: Melody Lam
//Quiz Section BP
//Programming Assignment 2: Prioritizing Patients
//  this program uses user input to calculate the patient's
//  priority score and uses the score to determine their level of 
//  priority and what kind of treatment they will receive

public class PatientPrioritizer {
   //declare and initialize hospital zip code as class constant
   public static final int HOSPITAL_ZIP = 12345;

   //main method
   public static void main(String[] args){
      Scanner user = new Scanner(System.in);
      //declare and initialize number of patients helped to 0
      int numberOfPatients = 0;
      //declare and initialize max priority score to 0 
      int maxScore = 0;
      //call welcom message method
      welcomeMessage();
      //space line
      System.out.println();
      String name = returnName(user);
      //create while loop that reiterates as longs as user input isn't quit
      while(!(name.equals("quit"))){
         //set priority score to return value of paitent info method
         int priorityScore = patientInfo(user);
         //determine if new max score is necessary
         if(priorityScore > maxScore){
            maxScore = priorityScore;
         }
         //blank line for space
         System.out.println();
         //call patient priority method
         patientPriority(name, priorityScore);
         //increment number of patients helped by 1
         numberOfPatients += 1;
         name = returnName(user);
      }  
      //call daily stats method if input equals quit 
      dailyStats(numberOfPatients, maxScore);
   }

   //print welcome message 
   public static void welcomeMessage(){
      System.out.println("Hello! We value you and your time, so we will help" 
         + "\nyou prioritize which patients to see next!");
      System.out.println("Please answer the following questions about the next "
         + "patient so\nwe can help you do your best work :)");
   }

   //takes in scanner object and returns patient's name
   public static String returnName(Scanner user){
      String name = "";
      //prompt user for name
      System.out.println("Please enter the next patient's name or \"quit\" "
         + "to end the program.");
      System.out.print("Patient's name: ");
      name = user.next();
      return name;
   }

   //takes in scanner object and returns priority score
   public static int patientInfo(Scanner user){
      //prompt for patient's age
      System.out.print("Patient age: ");
      int age = user.nextInt();
      //prompt for patient's zip code
      System.out.print("Patient zip code: ");
      int zipCode = user.nextInt();
      //determine whether the zip code is valid and equal too 5 digits
      while (!(fiveDigits(zipCode))){
         System.out.print("Invalid zip code, enter valid zip code: ");
         zipCode = user.nextInt();
      }
      //ask the user if the hospital is "in network"   
      System.out.print("Is our hospital \"in network\" for the patient's insurance? ");
      String network = user.next();
      //declare and initialize pain to 0   
      int pain = 0;
      while (pain == 0){
         //prompt user for their pain level
         System.out.print("Patient pain level (1-10): ");
         pain = user.nextInt();
         //determine if level is valid (between 1-10)
         while (pain < 1 || pain > 10){
            //prompt again if invalid pain level
            System.out.print("Invalid pain level, enter valid pain level (1-10): ");
            pain = user.nextInt();
         }
      }
      //prompt user for their temperature
      System.out.print("Patient temperature (in degrees Fahrenheit): ");
      double temp = user.nextDouble();
      //set priority score to return value of priority calc method
      int priorityScore = priorityCalc(age, zipCode, network, pain, temp);
      return priorityScore;
   }

   //method calculates and returns the priority score based on parameter information 
   public static int priorityCalc(int age, int zipCode, String network, int pain, double temp){
      //set priority score to 100 as base
      int priorityScore = 100;
      //age criteria
      if(age < 12 || age >= 75){
         priorityScore += 50;
      }
      //zip code criteria
      if((zipCode / 10000) == (HOSPITAL_ZIP / 10000)){
         priorityScore += 25;
         if (((zipCode % 10000) / 1000) == ((HOSPITAL_ZIP % 10000) / 1000)){
            priorityScore += 15;
         }
      }
      //network criteria
      if(network.equals("y") || network.equals("yes")){
         priorityScore += 50;
      }
      //add pain * 10 to priority score
      priorityScore += (pain * 10);
      //temperature criteria
      if(temp > 99.5){
         priorityScore += 8;
      }
      return priorityScore;
   }

   //takes in name and priority score to determine patient priority
   public static void patientPriority(String name, int priorityScore){
      System.out.println("We have found patient " + name + " to have a "
            + "priority score of: " + priorityScore);
      //high priority criteria and statement
      if(priorityScore >= 332){
         System.out.println("We have determined this patient is high priority,"
            + "\nand it is advised to call an appropriate medical provider ASAP.");
      //medium priority criteria and statement
      } else if (priorityScore < 332 && priorityScore >= 166){
         System.out.println("We have determined this patient is medium priority."
            + "\nPlease assign an appropriate medical provider to their case"
            + "\nand check back in with the patient's condition in a little while.");
      //low priority criteria and statement
      } else if (priorityScore < 166){
         System.out.println("We have determined this patient is low priority.\nPlease put "
            + "them on the waitlist for when a medical provider becomes available.");
      }
      //blank line to space out
      System.out.println();
      //ending thank you message
      System.out.println("Thank you for using our system!");
      System.out.println("We hope we have helped you do your best!");
      //blank line to space out
      System.out.println();
   }

   //takes in number of patients and maxscore for daily stats
   public static void dailyStats(int numberOfPatients, int maxScore){
      //prints summary of daily stats
      System.out.println("Statistics for the day:");
      System.out.println("..." + numberOfPatients + " patients were helped");
      System.out.println("...the highest priority patient we saw had a score of " + maxScore);
      System.out.println("Good job today!");
   }
   
   // Takes in an integer input
   // Returns true if the integer has 5 digits
   // and false otherwise.
   public static boolean fiveDigits(int val) {
      val = val / 10000; // get first digit
      if (val == 0) { // has less than 5 digits
         return false;
      } else if (val / 10 == 0) { // has 5 digits
         return true;
      } else { // has more than 5 digits
         return false; 
      }
      // NOTE: the above can be written with improved "boolean zen" as follows: 
      // return val != 0 && val / 10 == 0;
   }  
}
