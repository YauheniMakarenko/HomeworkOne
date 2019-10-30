import java.time.LocalDate;
import java.time.Period;

public enum Holiday {
    NEW_YEAR("31.12"),
    CHRISTMAS("5.1"),
    KNOWLEDGE_DAY("1.09");


    String date;

    Holiday(String name) {
        this.date = name;
    }

    public String getDate() {
        return date;
    }

    public int getDay() {
        int a = date.lastIndexOf(".");
        String s = date.substring(0, a);
        return Integer.valueOf(s);
    }

    public int getMonth() {
        int a = date.lastIndexOf(".") + 1;
        String s = date.substring(a, date.length());
        return Integer.valueOf(s);
    }

    public String holidayPassed(Holiday holiday) {

        int days = Period.between(LocalDate.of(LocalDate.now().getYear(), holiday.getMonth(), holiday.getDay()), LocalDate.now()).getDays();
        int months = Period.between(LocalDate.of(LocalDate.now().getYear(), holiday.getMonth(), holiday.getDay()), LocalDate.now()).getMonths();
        int years = Period.between(LocalDate.of(LocalDate.now().getYear(), holiday.getMonth(), holiday.getDay()), LocalDate.now()).getYears();

        if (days <= 0 && months <= 0 && years <= 0) {
            return holiday.name() + " Еще будет " + holiday.getDate();
        } else {
            return holiday.name() + " Прошел " + holiday.getDate();
        }
    }

    public void print() {
        System.out.println(holidayPassed(Holiday.this));
    }
}
