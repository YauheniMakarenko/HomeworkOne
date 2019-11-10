package HomeworkFour;

public class Circle extends Figure{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }
    public int getRadius(){
        return radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public double periment() {
        return 2 * Math.PI *radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return String.format("Name:  %s, Radius: %d ", this.getName(), this.radius);
    }
}

