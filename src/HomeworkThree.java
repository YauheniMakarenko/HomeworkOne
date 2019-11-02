import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkThree {

    public static final Random R = new Random();
    public static final int LENGTH = 5;
    public static final int WIDTH = 6;


    public static void main(String[] args) {

        System.out.println("Task 2");
        System.out.println(daysInFebruary(Months.MAY));
        System.out.println("---------------------------------------");

        int[][] array = createTwoDimensionalArray();

        System.out.println("Task 3");
        System.out.println(differenceBetweenMinAndMaxElementArray(array));
        System.out.println("---------------------------------------");
        System.out.println("Task 4");
        int[] oneArray = {5, 4, 8, 6, 9, 1, 2, 25};
        int[] twoArray = {1, 9, 8, 45, 15, 52};
        System.out.println(samenessCheck(oneArray, twoArray));
        System.out.println("---------------------------------------");
        System.out.println("Task 5");
        int[] newArray = {5, 8, 2, 0, 3, 9, 6, 1, 7, 4};
        System.out.println(findMissingNumber(newArray));
        System.out.println("---------------------------------------");
        System.out.println("Task 6");
        System.out.println("Min: " + minElementArray(array));
        System.out.println("---------------------------------------");
        System.out.println("Task 7");
        printTwoDimensionalArray(swapMaxMinElementArray(array));
        System.out.println("---------------------------------------");
        System.out.println("Task 8");
        oddElementReplace(array);
        System.out.println("---------------------------------------");
        System.out.println("Task 9.1");
        findMultiplicationOfDiagonalElements(createTwoDimensionalArray());
        System.out.println("---------------------------------------");
        System.out.println("Task 10");
        Holiday.CHRISTMAS.print();

    }

    public static int daysInFebruary(Months month) {
        int days = 0;
        switch (month) {
            case JANUARY:
                days = 31;
                break;
            case FEBRUARY:
                days = 28;
                break;
            case MARCH:
                days = 30;
                break;
            case APRIL:
                days = 31;
                break;
            case MAY:
                days = 31;
                break;
            case JUNE:
                days = 30;
                break;
            case JULY:
                days = 31;
                break;
            case AUGUST:
                days = 31;
                break;
            case SEPTEMBER:
                days = 30;
                break;
            case OCTOBER:
                days = 31;
                break;
            case NOVEMBER:
                days = 30;
                break;
            case DECEMBER:
                days = 31;
                break;
        }
        return days;
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

    public static int differenceBetweenMinAndMaxElementArray(int[][] givenArray) {
        int minElem = minElementArray(givenArray);
        int maxElem = givenArray[0][0];
        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[i].length; j++) {
                if (givenArray[i][j] > maxElem) {
                    maxElem = givenArray[i][j];
                }
            }
        }
        return maxElem - minElem;
    }

    public static boolean samenessCheck(int[] givenArrayOne, int[] givenArrayTwo) {
        for (int i = 0; i < givenArrayOne.length; i++) {
            if (givenArrayOne[i] != givenArrayTwo[i]) {
                return false;
            }
        }
        return true;
    }

    public static int findMissingNumber(int[] givenArray) {
        int sum = 0;
        for (int i = 0; i < givenArray.length; i++) {
            sum += givenArray[i];
        }
        return ((givenArray.length + 1) * givenArray.length / 2) - sum;
    }

    public static int minElementArray(int[][] givenArray) {
        int minElement = givenArray[0][0];
        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[i].length; j++) {
                if (givenArray[i][j] < minElement) {
                    minElement = givenArray[i][j];
                }
            }
        }
        return minElement;
    }

    public static int[][] swapMaxMinElementArray(int[][] givenArray) {
        int maxi = 0;
        int maxj = 0;
        int mini = 0;
        int minj = 0;
        int minElement = minElementArray(givenArray);
        int maxElement = givenArray[0][0];
        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[i].length; j++) {
                if (givenArray[i][j] == minElement) {
                    mini = i;
                    minj = j;
                }
                if (givenArray[i][j] > maxElement) {
                    maxElement = givenArray[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        }
        System.out.println("Max " + maxElement);
        givenArray[maxi][maxj] = minElementArray(givenArray);
        givenArray[mini][minj] = maxElement;
        return givenArray;
    }

    public static int[][] oddElementReplace(int[][] givenArray) {
        printTwoDimensionalArray(givenArray);
        System.out.println();
        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[i].length; j++) {
                if (givenArray[i][0] % 2 != 0) {
                    givenArray[i][j] = 0;
                } else if (givenArray[i][j] % 2 != 0) {
                    givenArray[i][j] = givenArray[i][j - 1];
                }
            }
        }
        printTwoDimensionalArray(givenArray);
        return givenArray;
    }

    public static int findMultiplicationOfDiagonalElements(int[][] givenArray) {
        printTwoDimensionalArray(givenArray);
        System.out.println();
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        int rezult = 1;
        outer:
        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[i].length; j++) {
                if (givenArray[i][j] == index) {
                    for (int i2 = 0; i2 < givenArray.length; i2++) {
                        for (int j2 = 0; j2 < givenArray[i].length; j2++) {
                            if (i2 == i + 1 && j2 == j + 1 || i2 == i - 1 && j2 == j - 1 || i2 == i - 1 && j2 == j + 1 || i2 == i + 1 && j2 == j - 1) {
                                rezult = rezult * givenArray[i2][j2];
                            }
                        }
                    }
                    break outer;
                }
            }
        }
        System.out.println(rezult);
        return rezult;
    }
}
