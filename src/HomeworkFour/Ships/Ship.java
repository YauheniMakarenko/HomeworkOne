package HomeworkFour.Ships;

import java.util.Random;

public class Ship {

    private int size;
    private int positionX;
    private int positionY;
    private int rnd;

    Ship(int Deck) {
        this.size = Deck;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getRnd() {
        return rnd;
    }

    public void setRnd(int rnd) {
        this.rnd = rnd;
    }

    void initWithRandom() {
        Random random = new Random();
        positionX = random.nextInt((Field.SIZE - size) + 1);
        positionY = random.nextInt((Field.SIZE - size) + 1);

        rnd = random.nextInt(2);
    }
}
