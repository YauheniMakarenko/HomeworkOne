package homeworkFour.Ships;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(20, 2);
        field.generateShipsAtRandomLocations();
        field.outputFieldWithShipsLocated();
    }
}

