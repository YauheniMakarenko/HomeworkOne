package homeworkFour;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Figure square = new Square("Square",15);
        System.out.println(square.toString());
        System.out.println("Periment: " + square.periment());
        System.out.println("Area: " + square.area());
        System.out.println();

        Figure rectangle = new Rectangle("Rectangle",4, 5);
        System.out.println(rectangle.toString());
        System.out.println("Periment: " + rectangle.periment());
        System.out.println("Area: " + rectangle.area());
        System.out.println();

        Figure circle = new Circle("Circle",5);
        System.out.println(circle.toString());
        System.out.println("Periment: " + circle.periment());
        System.out.println("Area: " + circle.area());
        System.out.println();

        Figure ball = new Sphere("Sphere",7);
        System.out.println(ball.toString());
        System.out.println("Periment: " + ball.periment());
        System.out.println("Area: " + ball.area());
        System.out.println();

        System.out.println("---------Task 2-----------------------");

        Picture picture = new Picture();
        picture.addToList(square);
        picture.addToList(rectangle);
        picture.addToList(circle);
        picture.addToList(ball);
        picture.addToList(new Square("Square",10));
        picture.addToList(new Circle( "Circle",5));
        System.out.println(picture.namesOfFigures());
        System.out.println(picture.sumPerimetersOfFigures());
        System.out.println(picture.sumAreasOfFigures());

        System.out.println("---------Task 3-----------------------");
        System.out.println(picture.countDifferentFigures());


        System.out.println("---------Task 5-----------------------");
        Mathematics mathematics = new Mathematics();
        System.out.println(mathematics.add(15.6, 15.5));
        int[] arrayOne = {15, 20, 50, 22, 66};
        int[] arrayTwo = {80, 72, 66, 23};
        System.out.println(Arrays.toString(mathematics.add(arrayOne, arrayTwo)));
        List list1 = new ArrayList();
        list1.add(15);
        list1.add(20);
        List list2 = new ArrayList();
        list2.add(100);
        list2.add(50);
        System.out.println(mathematics.add(list1,list2));


    }
}
