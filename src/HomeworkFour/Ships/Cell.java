package HomeworkFour.Ships;

public class Cell {


    static int SIZE = 10;
    private char[][] cell = new char[SIZE][SIZE];
    private final int[] DECK = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
    Ship[] ships = new Ship[DECK.length];

    void fillField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cell[i][j] = '.';
            }
        }
    }

    void viewField() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(cell[i][j] + " ");
            }
            System.out.println();
        }
    }

    void shipOnTheField() {
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

    boolean coincideShip(Ship ship) {

        if (ship.rnd == 0) {
            for (int i = 0; i < ship.size; i++) {
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        if (ship.positionY + dy + i < 0 || ship.positionY + dy + i >= SIZE || ship.positionX + dx < 0 || ship.positionX + dx >= SIZE) {
                            continue;
                        }
                        if (cell[ship.positionY + dy + i][ship.positionX + dx] == '#') {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < ship.size; i++) {
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        if (ship.positionY + dy < 0 || ship.positionY + dy >= SIZE || ship.positionX + dx + i < 0 || ship.positionX + dx + i >= SIZE) {
                            continue;
                        }
                        if (cell[ship.positionY + dy][ship.positionX + dx + i] == '#') {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    void drawnShip(Ship tmpShip) {
        if (tmpShip.rnd == 0) {
            for (int i = 0; i < tmpShip.size; i++) {
                cell[tmpShip.positionY + i][tmpShip.positionX] = '#';
            }
        } else {
            for (int i = 0; i < tmpShip.size; i++) {
                cell[tmpShip.positionY][tmpShip.positionX + i] = '#';
            }
        }
    }
}
