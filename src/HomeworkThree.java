import java.util.Arrays;
import java.util.Random;

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
        System.out.println(samenessCheck(array, array));
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
        notEvenElementReplace(array);
        System.out.println("---------------------------------------");
        System.out.println("Task 9");
        multiplicationDiagonalElement(createTwoDimensionalArray(), 7);
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
                array[i][j] = R.nextInt(40);
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

    public static boolean samenessCheck(int[][] givenArrayOne, int[][] givenArrayTwo) {
        return givenArrayOne == givenArrayTwo;
    }

    public static int findMissingNumber(int[] givenArray) {
        int sum = 0;
        for (int i = 0; i < givenArray.length; i++) {
            sum += givenArray[i];
        }
        int missingNumber = ((givenArray.length + 1) * givenArray.length / 2) - sum;
        return missingNumber;
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
        int maxElement = givenArray[0][0];
        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[i].length; j++) {
                if (givenArray[i][j] == minElementArray(givenArray)) {
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

    public static int[][] notEvenElementReplace(int[][] givenArray) {
        printTwoDimensionalArray(givenArray);
        System.out.println();
        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[i].length; j++) {
                if (givenArray[i][j] % 2 != 0) {
                    if (givenArray[i][j] == givenArray[i][0]) {
                        givenArray[i][j] = 0;       //меняем все нечетные элементы по счётчику j == 0, на 0
                    } else
                        givenArray[i][j] = givenArray[i][j - 1];
                }
            }
        }
        printTwoDimensionalArray(givenArray);
        return givenArray;
    }

    public static int multiplicationDiagonalElement(int[][] givenArray, int index) {
        printTwoDimensionalArray(givenArray);
        System.out.println();
        int rezult = 1;
        for (int i = 1; i < givenArray.length - 1; i++) {
            for (int j = 1; j < givenArray[i].length - 1; j++) {
                if (givenArray[i][j] == index) {
                    rezult = givenArray[i - 1][j - 1] * givenArray[i + 1][j + 1] * givenArray[i + 1][j - 1] * givenArray[i - 1][j + 1];
                }
            }
        }
        System.out.println(rezult);
        return rezult;
    }

}
