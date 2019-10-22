import java.util.Arrays;
import java.util.Random;

public class HomeworkTwo {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(isPalindrome("asdsa"));
        System.out.println("Task 2");
        System.out.println(Arrays.toString(arrayRandomNumber(15)));
        System.out.println("Task 3");
        System.out.println(arrayRandomFind(20, 10));
        System.out.println("Task 4");
        System.out.println(Arrays.toString(arrayMaxMinElement(15)));
        System.out.println("Task 5");
        System.out.println(meanArray(15));
        System.out.println("Task 6");
        System.out.println(searchNegative(10));
        System.out.println("Task 7");
        System.out.println(Arrays.toString(deleteArrayElement(15, 3)));
        System.out.println("Task 8");
        System.out.println(Arrays.toString(inverseOrderArrays(15)));
        System.out.println("Task 9");
        System.out.println(isArraySorted(15));
        System.out.println("Task 10");
        System.out.println(Arrays.toString(mixElementArrayRandom(15)));
        System.out.println("Task 11");
        System.out.println(Arrays.toString(sortUp(15)));
        System.out.println("Task 12");
        createTwoDimensionalRandomArray(3, 4);
    }

    public static boolean isPalindrome(String givenString) {
        return givenString.equals((new StringBuilder(givenString)).reverse().toString());
    }

    public static int[] arrayRandomNumber(int number) {
        int[] arrayNumber = new int[number];
        Random rand = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = rand.nextInt();
        }
        return arrayNumber;
    }

    public static int arrayRandomFind(int number, int findNumber) {
        int[] arrayNumber = new int[number];
        Random randomNumber = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = randomNumber.nextInt(100);
        }
        System.out.println(Arrays.toString(arrayNumber));
        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] == findNumber) {
                return i;
            }
        }
        return -1;
    }

    public static int[] arrayMaxMinElement(int number) {
        int[] arrayNumber = new int[number];
        Random randomNumber = new Random();
        for (int i = 0; i < arrayNumber.length; i++)
            arrayNumber[i] = randomNumber.nextInt(100);
        System.out.println(Arrays.toString(arrayNumber));
        int max = 0;
        int maxElement = arrayNumber[0];
        int min = 0;
        int minElement = arrayNumber[0];
        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] > maxElement) {
                maxElement = arrayNumber[i];
                max = i;
            } else if (arrayNumber[i] < minElement) {
                minElement = arrayNumber[i];
                min = i;
            }
        }
        arrayNumber[max] = minElement;
        arrayNumber[min] = maxElement;
        return arrayNumber;
    }

    public static double meanArray(int number) {
        double sum = 0;
        int[] arrayNumber = new int[number];
        Random randomNumber = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = randomNumber.nextInt(100);
            sum += arrayNumber[i];
        }
        return sum / arrayNumber.length;
    }

    public static int searchNegative(int number) {
        int count = 0;
        int[] arrayNumber = new int[number];
        Random rand = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = rand.nextInt();
            if (arrayNumber[i] < 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] deleteArrayElement(int number, int deletePoz) {
        int[] arrayNumber = new int[number];
        Random rand = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arrayNumber));
        int[] result = new int[arrayNumber.length - 1];
        int j = 0;
        for (int i = 0; i < arrayNumber.length; i++) {
            if (i < arrayNumber.length) {
                result[j] = arrayNumber[i];
                j++;
            }
            if (i == deletePoz) {
                i++;
            }
        }
        return result;
    }

    public static int[] inverseOrderArrays(int number) {
        int[] arrayNumber = new int[number];
        Random rand = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arrayNumber));
        int[] result = new int[arrayNumber.length];
        for (int i = arrayNumber.length - 1; i >= 0; i--) {
            result[i] = arrayNumber[arrayNumber.length - 1 - i];
        }
        return result;
    }

    public static boolean isArraySorted(int number) {
        int[] arrayNumber = new int[number];
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = i;
        }
        System.out.println(Arrays.toString(arrayNumber));
        for (int i = 1; i < arrayNumber.length; i++) {
            if (arrayNumber[i] < arrayNumber[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] mixElementArrayRandom(int number) {
        int[] arrayNumber = new int[number];
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = i;
        }
        System.out.println(Arrays.toString(arrayNumber));
        Random rand = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            int index = rand.nextInt(i + 1);
            int a = arrayNumber[index];
            arrayNumber[index] = arrayNumber[i];
            arrayNumber[i] = a;
        }
        return arrayNumber;
    }

    public static int[] sortUp(int number) {
        int[] arrayNumber = new int[number];
        Random rand = new Random();
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arrayNumber));
        for (int i = 1; i < arrayNumber.length; i++) {
            int current = arrayNumber[i];
            int j = i - 1;
            while (j >= 0 && current < arrayNumber[j]) {
                arrayNumber[j + 1] = arrayNumber[j];
                j--;
            }
            arrayNumber[j+1] = current;

        }
        return arrayNumber;
    }

    public static void createTwoDimensionalRandomArray(int a, int b) {
        int[][] arrayNumber = new int[a][b];
        Random r = new Random();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arrayNumber[i][j] = r.nextInt(100);
                System.out.print(arrayNumber[i][j] + " ");
                if (j == (b - 1))
                    System.out.println();
            }
        }
    }
}
