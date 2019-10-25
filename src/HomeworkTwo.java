import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomeworkTwo {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(isPalindrome("asdsa"));
        System.out.println("---------------------------------------");
        System.out.println("Task 2");
        int[] array = arrayRandom(15);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------");
        System.out.println("Task 3");
        System.out.println(arrayRandomFind(array, 10));
        System.out.println("---------------------------------------");
        System.out.println("Task 4");
        System.out.println(Arrays.toString(arrayMaxMinElement(array)));
        System.out.println("---------------------------------------");
        System.out.println("Task 5");
        System.out.println(meanArray(array));
        System.out.println("---------------------------------------");
        System.out.println("Task 6");
        System.out.println(searchNegative(array));
        System.out.println("---------------------------------------");
        System.out.println("Task 7");
        System.out.println(Arrays.toString(deleteArrayElement(array, 3)));
        System.out.println("---------------------------------------");
        System.out.println("Task 8");
        System.out.println(Arrays.toString(inverseOrderArrays(array)));
        System.out.println("---------------------------------------");
        System.out.println("Task 9");
        System.out.println(isArraySorted(array));
        System.out.println("---------------------------------------");
        System.out.println("Task 10");
        System.out.println(Arrays.toString(mixElementArrayRandom(array)));
        System.out.println("---------------------------------------");
        System.out.println("Task 11");
        System.out.println(Arrays.toString(sortUp(array)));
        System.out.println("---------------------------------------");
        System.out.println("Task 12");
        createDynamicRandomArray(3,4);
        System.out.println("---------------------------------------");
        System.out.println("Task 13");
        System.out.println(sumElementArrayRecursion(0, array));
        System.out.println("---------------------------------------");
        System.out.println("Task 14");
        System.out.println(Arrays.toString(dynamicArrayIncrease(array, 44)));
        System.out.println("---------------------------------------");
    }


    public static boolean isPalindrome(String givenString) {
        return givenString.equals((new StringBuilder(givenString)).reverse().toString());
    }

    public static int[] arrayRandom(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100) - 50;
        }
        return array;
    }

    public static int arrayRandomFind(int[] array, int findNumber) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findNumber) {
                return i;
            }
        }
        return -1;
    }

    public static int[] arrayMaxMinElement(int[] array) {
        int max = 0;
        int maxElement = array[0];
        int min = 0;
        int minElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                max = i;
            } else if (array[i] < minElement) {
                minElement = array[i];
                min = i;
            }
        }
        array[max] = minElement;
        array[min] = maxElement;
        return array;
    }

    public static double meanArray(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static int searchNegative(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] deleteArrayElement(int[] array, int deletePoz) {
        int[] result = new int[array.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length) {
                result[j] = array[i];
                j++;
            }
            if (i == deletePoz) {
                i++;
            }
        }
        return result;
    }

    public static int[] inverseOrderArrays(int[] array) {
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }

    public static boolean isArraySorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] mixElementArrayRandom(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int index = rand.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        return array;
    }

    public static int[] sortUp(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }

    public static void createDynamicRandomArray(int line, int column) {
        int[][] arrayNumber = new int[line][column];
        Random r = new Random();
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                arrayNumber[i][j] = r.nextInt(100);
                System.out.print(arrayNumber[i][j] + " ");
                if (j == (column - 1))
                    System.out.println();
            }
        }
    }

    public static int sumElementArrayRecursion(int index, int[] array) {
        if (index == (array.length)) {
            return 0;
        } else {
            return array[index] + sumElementArrayRecursion(index + 1, array);
        }
    }

    public static int[] dynamicArrayIncrease(int[] array, int index) {
        System.out.println(Arrays.toString(array));
        array = Arrays.copyOf(array, array.length + 50);
        array[array.length-1] = index;
        return array;
    }
}

