package HomeworkFour;

public class Square extends Figure {

    private int length;

    public Square(String name, int length) {
        super(name);
        this.length = length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength(){
        return length;
    }


    @Override
    public double periment() {
        return length * 4;
    }

    @Override
    public double area() {
        return Math.pow(length,2);
    }

    @Override
    public String toString() {
        return String.format("Name:  %s, Length: %d ", this.getName(), this.length);
    }


}

