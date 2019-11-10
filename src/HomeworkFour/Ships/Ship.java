package HomeworkFour.Ships;

import java.util.Random;

public class Ship {
    int size;
    int positionX;
    int positionY;
    int rnd;
    Random random = new Random();

    Ship(int Deck) {
        this.size = Deck;
    }


    void initWithRandom() {
        positionX = random.nextInt((Cell.SIZE - size) + 1);
        positionY = random.nextInt((Cell.SIZE - size) + 1);

        rnd = random.nextInt(2);


    }
}
