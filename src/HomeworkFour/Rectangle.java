package HomeworkFour;

public class Rectangle extends Figure {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength(){
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public double periment() {
        return (length + width) * 2;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return String.format("Name:  %s, Length: %d, Width: %d ", this.getName(), this.length, this.width);
    }
}

