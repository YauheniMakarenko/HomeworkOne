package homeworkFour.Ships;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(10, 1);
        field.generateShipsAtRandomLocations();
        field.outputFieldWithShipsLocated();
    }
}

