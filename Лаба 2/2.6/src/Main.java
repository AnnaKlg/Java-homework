import geometry2d.*;
import geometry3d.*;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Демонстрация успешной работы");
        try {
            // Создаем плоские фигуры
            Figure circle = new Circle(5.0);
            Figure rectangle = new Rectangle(4.0, 6.0);

            System.out.println(circle);
            System.out.println(rectangle);

            // Создаем цилиндры на их основе
            Cylinder roundCylinder = new Cylinder(circle, 10.0);
            Cylinder rectangularCylinder = new Cylinder(rectangle, 5.0);

            System.out.println(roundCylinder);
            System.out.println(rectangularCylinder);

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }

        System.out.println("\nДемонстрация обработки исключений");

        // Передаем некорректные размеры фигуры
        try {
            Figure badCircle = new Circle(-3);
        } catch (InvalidFigureException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        // Передаем некорректную высоту цилиндра
        try {
            Figure goodRect = new Rectangle(2, 3);
            Cylinder badCylinder = new Cylinder(goodRect, -5);
        } catch (Exception e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        // Передаем null вместо основания
        try {
            Cylinder nullBaseCylinder = new Cylinder(null, 10);
        } catch (Exception e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
    }
}
