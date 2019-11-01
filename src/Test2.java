package ru.home.eivanov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test2 {

    public static final Random R = new Random();
    public static final int LENGTH = 3;
    public static final int WIDTH = 3;


    public static void main(String[] args) {

        System.out.println("Task 9");
        multiplicationDiagonalElement(createTwoDimensionalArray());
        System.out.println("---------------------------------------");
        System.out.println("Task 10");

    }


    public static int[][] createTwoDimensionalArray() {
        int[][] array = new int[LENGTH][WIDTH];
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                array[i][j] = R.nextInt(30);
            }
        }
        return array;
    }

    public static void printTwoDimensionalArray(int[][] givenArray) {
        for (int i = 0; i < givenArray.length; i++) {
            System.out.println(Arrays.toString(givenArray[i]));

        }
    }

    public static int multiplicationDiagonalElement(int[][] givenArray) {
        printTwoDimensionalArray(givenArray);
        System.out.println();

        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        System.out.println("число " + index);
        int rezult = 1;
        for (int i = 0; i < givenArray[0].length; i++) {
            for (int j = 0; j < givenArray[1].length; j++) {
                if (givenArray[i][j] == index) {
                    int t =i;
                    int k = j;
                    for(int i2=0;i2<givenArray[0].length;i2++){
                        for(int j2 = 0;j2<givenArray[1].length;j2++){
                            if (i2==t+1 && j2 ==k+1 || i2==t-1 && j2==k-1 ||  i2==t-1 && j2==k+1||  i2==t+1 && j2==k-1){
                                rezult= rezult*givenArray[i2][j2];
                            }
                        }
                    }


                }
            }
        }
        System.out.println(rezult);
        return rezult;
    }

}
