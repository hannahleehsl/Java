//Hannah Lee
//10.09.2022
//TA: Melody Lam
//CSE 121 BP
//Programming Assignment 0
//program prints out sum, product, and average of 3 values
public class Mathematics {
    public static void main(String[] args) {
        int value1 = 7;
        int value2 = 10;
        int value3 = 6;

        int sum = value1 + value2 + value3;
        System.out.println("Sum = " + sum);

        int product = value1 * value2 * value3;
        System.out.println("Product = " + product);
        
        double average = sum / 3.0;
        System.out.println("Average = " + average);
    }
}
