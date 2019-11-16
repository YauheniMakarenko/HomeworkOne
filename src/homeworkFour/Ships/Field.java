package homeworkFour.Ships;

public class Field {

    private static int sizeField;
    private static int shipSizeMultiplier;
    private char[][] cell;
    private final int[] DECK = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
    private Ship[] ships = new Ship[DECK.length];

    public Field(int sizeField, int shipSizeMultiplier) {
        this.sizeField = sizeField;
        this.shipSizeMultiplier = shipSizeMultiplier;
    }

    public static int getSizeField() {
        return sizeField;
    }

    public static int getShipSizeMultiplier() {
        return shipSizeMultiplier;
    }

    public void outputFieldWithShipsLocated() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell.length; j++) {
                System.out.print(cell[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void generateShipsAtRandomLocations() {
        cell = new char[sizeField][sizeField];
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell.length; j++) {
                cell[i][j] = '.';
            }
        }
        for (int i = 0; i < DECK.length; i++) {
            Ship tmpShip = new Ship(DECK[i]);
            boolean isIntersect;

            do {
                isIntersect = false;
                tmpShip.initWithRandom();
                for (int j = 0; j < i; j++) {
                    if (coincideShip(tmpShip)) {
                        isIntersect = true;
                    }
                }
            } while (isIntersect);

            drawnShip(tmpShip);
            ships[i] = tmpShip;
        }
    }

    public boolean coincideShip(Ship ship) {
        if (ship.getRnd() == 0) {
            for (int i = 0; i < ship.getSize(); i++) {
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        if (ship.getPositionY() + dy + i < 0 || ship.getPositionY() + dy + i >= sizeField || ship.getPositionX() + dx < 0 || ship.getPositionX() + dx >= sizeField) {
                            continue;
                        }
                        if (cell[ship.getPositionY() + dy + i][ship.getPositionX() + dx] == '#') {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        if (ship.getPositionY() + dy < 0 || ship.getPositionY() + dy >= sizeField || ship.getPositionX() + dx + i < 0 || ship.getPositionX() + dx + i >= sizeField) {
                            continue;
                        }
                        if (cell[ship.getPositionY() + dy][ship.getPositionX() + dx + i] == '#') {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public void drawnShip(Ship tmpShip) {
        if (tmpShip.getRnd() == 0) {
            for (int i = 0; i < tmpShip.getSize(); i++) {
                cell[tmpShip.getPositionY() + i][tmpShip.getPositionX()] = '#';
            }
        } else {
            for (int i = 0; i < tmpShip.getSize(); i++) {
                cell[tmpShip.getPositionY()][tmpShip.getPositionX() + i] = '#';
            }
        }
    }
}
