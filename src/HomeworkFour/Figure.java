package HomeworkFour;

public abstract class Figure {
    private String name;

    public Figure(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double periment();
    public abstract double area();
}
