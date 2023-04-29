//Hannah Lee
//13.10.2022
//CSE 121 BP
//Melody Lam
//Creative Project 1: Drawing Shapes
//code creates images using turtle object

import java.util.*;
public class Shapes {
    public static void main(String[] args) {
        Turtle t1 = new Turtle();
        // Task 1: Draw a regular shape
        //draw a pentagon
        for(int i = 0; i < 5; i++){
            t1.forward(50);
            t1.right(72);
        }

        //separate the two drawings
        t1.up();
        t1.right(90);
        t1.forward(100);
        t1.down();
        t1.left(90);

        // Task 2: Draw a regular shape many times
        //draw 5 completely separate pentagons
        for(int k = 0; k < 5; k++){
            t1.up();
            t1.forward(100);
            t1.down();
            for(int i = 0; i < 5; i++){
                t1.forward(50);
                t1.right(72);
            }
        }

        //separate the two drawings
        t1.up();
        t1.right(90);
        t1.forward(200);
        t1.down();

        // Extension A: Random
        //draw 10 squares of random sizes trailing down
        Random r = new Random();
        for(int k = 0; k < 10; k++){
            //set max int number at 100 and min at 1
            int randInt = r.nextInt(100) + 1;
            for (int i = 0; i < 4; i++){
                t1.forward(randInt);
                t1.right(90);
            }
            //separate the shapes slightly
            t1.up();
            t1.forward(randInt + 20);
            t1.down();
        }

        //separate two images
        t1.up();
        t1.right(90);
        t1.forward(500);
        t1.down();

        // Extension B: Many Times
        //draw two hexagons getting progressively bigger
        for(int k = 0; k < 2; k++){
            for (int i = 0; i < 200; i++){
                t1.forward(i);
                t1.right(60);
            }
            t1.right(k);
        }


    }
}
