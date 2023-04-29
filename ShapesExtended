import java.util.*;

//Hannah Lee
//TA:Melody Lam
//CSE 121 Section BP
//Creative Assignment 2
//11.03.2022

//A program that creates shapes with paramaterized methods
public class Shapes {
    public static void main(String[] args) {
        // TODO: Your code here
        Turtle t = new Turtle();
        Random rand = new Random();
        int width = 50;
        int height = 100;

        //implement task 1 pt 1
        drawingRectangle(t, width, height);
        separate(t);
        int triangleLength = 100;

        //implement task 1 pt 2
        drawingTriangle(t, triangleLength);
        separate(t);
        int numSquares = 10;
        int maxSize = 200;
        
        //implement task 3 extension 1
        randomSquares(t, rand, numSquares, maxSize);
        separate(t);
        int numSides = 7;
        int sideLength = 300;
        separate(t);

        //implement task 3 extension 4
        drawGon(t, numSides, sideLength);
        numSides = 10;
        compoundShapes(t, rand, numSides, sideLength);
        
    }

    // TODO: Your methods here
    //task 1 rectangle
    public static void drawingRectangle(Turtle t, int width, int height){
        //for loop for rectanle
        for(int i = 0; i < 2; i++){
            t.forward(width);
            t.right(90);
            t.forward(height);
            t.right(90);
        }
    }

    //task 1 triangle
    public static void drawingTriangle(Turtle t, int length){
        //turn turtle right so triangle is straight
        t.right(60);
        //for loop for triangle sides
        for(int i = 0; i < 3; i++){
            t.forward(length);
            t.right(120);
        }
    }

    //task 3 extension 1
    public static void randomSquares(Turtle t, Random rand, int numSquares, int maxSize){
        int sideSize = 0;
        for(int i = 0; i < numSquares; i++){
            sideSize = rand.nextInt(maxSize) + 1;
            for(int j = 0; j < 4; j++){
                t.forward(sideSize);
                t.right(90);
            }
        }
    }

    //task 3 extension 4
    public static void drawGon(Turtle t, int numSides, int sideLength){
        double angle = 360.0 / numSides;
        for(int i = 0; i < numSides; i++){
            t.forward(sideLength);
            t.right(angle);
        }
    }
     //task 2
    public static void compoundShapes(Turtle t, Random rand, int numSides, int sideLength){
        drawGon(t, numSides, sideLength);
        randomSquares(t, rand, numSides, sideLength / 2);
        t.up();
        t.forward(sideLength);
        t.down();
        drawingTriangle(t, sideLength);
        t.up();
        t.right(30);
        t.forward(sideLength / 2);
        t.down();
        drawGon(t, numSides / 2, sideLength / 2);

    }

    //separatate drawings
    public static void separate(Turtle t){
        t.up();
        t.right(30);
        t.forward(300);
        t.down();
    }
}
