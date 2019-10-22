import java.time.LocalDate;
import java.time.Period;

public class HomeworkOne {
    public static void main(String[] args) {
        System.out.println(intToString(15));
        System.out.println(stringToInt("152"));
        System.out.println(evenNumber(11));
        System.out.println(endAtSeven(687));
        System.out.println(containsChar("Hell@ W@rld ", '@'));
        System.out.println(convertTime1(12));
        System.out.println(convertTime2(1369584));
        System.out.println(stringtoUpperLowerCase("hello word"));
        System.out.println(calcOfAreaAndLengthOfCircle(4));
        System.out.println(circleCoverRectangle(3, 4, 3));
        System.out.println(ageCalculate(30, 06, 1984));
    }

    public static String intToString(int number) {
        String s = String.valueOf(number);
        String t = Integer.toString(number);
        return s + t;
    }

    public static int stringToInt(String st) {
        int a = Integer.parseInt(st);
        int b = Integer.valueOf(st);
        return a + b;
    }

    public static String evenNumber(int number) {
        if (number % 2 == 0) {
            return "Число: " + number + " четное";
        } else {
            return "Число: " + number + " нечетное";
        }
    }

    public static String endAtSeven(int number) {
        if (number % 10 == 7) {
            return "Число: " + number + " заканчивается цифрой 7";
        } else {
            return "Число: " + number + " не заканчивается цифрой 7";
        }
    }

    public static String containsChar(String givenString, char c) {
        if (givenString.indexOf(c) != -1) {
            return "Строка: " + givenString + "содержит символ " + c;
        } else {
            return "Символ " + c + " отсутствует";
        }
    }

    public static String convertTime1(int hour) {
        int minutes = hour * 60;
        int seconds = hour * 3600;
        return hour + "часов = " + minutes + "мин или " + seconds + "секунд";
    }

    public static String convertTime2(long seconds) {
        long day = seconds / 86400;
        long balance = seconds % 86400;
        long hour = balance / 3600;
        long minutes = balance % 3600 / 60;
        long remainingSeconds = balance % 3600 % 60 % 60;
        return seconds + " секунд = " + day + "дней " + hour + "часам " + minutes + "минутам " + remainingSeconds + " секундам";
    }

    public static String stringtoUpperLowerCase(String givenString) {
        char[] c = givenString.toCharArray();
        String result = "";
        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                result = result + String.valueOf(c[i]).toUpperCase();
            } else {
                result = result + String.valueOf(c[i]).toLowerCase();
            }
        }
        return result;
    }

    public static String calcOfAreaAndLengthOfCircle(int radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double length = 2 * Math.PI * radius;
        return "Площадь = " + area + " Длина = " + length;
    }

    public static boolean circleCoverRectangle(int length, int width, int radius) {
        return (radius > 0 && length > 0 && width > 0 && radius * 2 >= Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2)));
    }

    public static String ageCalculate(int day, int month, int year) {
        LocalDate birthday = LocalDate.of(year, month, day);
        Period vozrast = Period.between(birthday, LocalDate.now());
        return "Ваш возраст " + vozrast.getYears() + " года " + vozrast.getMonths() + " месяцев " + vozrast.getDays() + " дней";
    }
}
