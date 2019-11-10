package HomeworkFour;

public class Sphere extends Figure {
    private int radius;

    public Sphere(int radius) {
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
        return "Sphere";
    }

    @Override
    public double periment() {
        return 0;
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return String.format("Name:  %s, Radius: %d ", this.getName(), this.radius);
    }
}




