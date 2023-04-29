//Hannah Lee
//TA:Melody Lam 
//Quiz Section: BP
//Creative Project 3:Turtle Drawing From File
//November 30 2022
//this porgram reads instructions from a file and commands the 
//turtle to act according the instructions.

import java.util.*;
import java.io.*;

public class TurtleInterpreter {
    public static void main(String[] args) throws FileNotFoundException {
        // comment out line 8 and uncomment line 9 once you have completed
        // the second extension and written your own TurtleTalk code
        //Scanner fileScan = new Scanner(new File("instructions.txt"));
         Scanner fileScan = new Scanner(new File("my_instructions.txt"));
        Turtle t = new Turtle();

        while (fileScan.hasNextLine()) {
            // TODO: Read in line from file and make Scanner over it
            Scanner lineScan = new Scanner(fileScan.nextLine());
            //       Read in the first token from new Scanner and store 
            //       it in the variable 'String command'
            String command = lineScan.next();

            if (command.equals("Forwards")) { 
                double distance = lineScan.nextDouble(); // Read in param
                t.forward(distance); // Go forwards by distance
                
            } else if (command.equals("Backwards")) {
                // TODO: Read in parameter and execute "Backwards" command
                double distance = lineScan.nextDouble();
                t.backward(distance);

            } else if (command.equals("Left")) {
                // TODO: Implement remaining commands by extending 
                //       this conditional structure
                double angle = lineScan.nextDouble();
                t.left(angle);

            //read in turn right command
            } else if (command.equals("Right")) {
                double angle = lineScan.nextDouble();
                t.right(angle);

            //read in lift turtle command
            } else if (command.equals("Up")) {
                t.up();

            //read in place turtle back down command
            } else if (command.equals("Down")) {
                t.down();

            //read in change color command
            } else if (command.equals("ChangeColor")) {
                String color = lineScan.next();
                t.penColor(color);

            //read in draw square command           
            } else if (command.equals("Square")) {
                double length = lineScan.nextDouble();
                for(int i = 0; i < 4; i++) {
                    t.forward(length);
                    t.right(90);
                }
            
            //read in draw triangle command
            } else if (command.equals("Triangle")) {
                double length = lineScan.nextDouble();
                for(int i = 0; i < 3; i++) {
                    t.right(120);
                    t.forward(length);
                }
            
            //read in draw circle command
            } else if (command.equals("Circle")) {
                double size = lineScan.nextDouble();
                for(int i = 0; i < 360; i++) {
                    t.forward(size);
                    t.right(1);
                }
            
            //read in draw curve line command
            } else if (command.equals("Semi")) {
                double size = lineScan.nextDouble();
                for(int i = 0; i < 180; i++) {
                    t.forward(size);
                    t.right(1);
                }
            }
        }
    }
}
