package geometry2d;

import exceptions.InvalidFigureException;

public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) throws InvalidFigureException {
        if (radius <= 0) {
            throw new InvalidFigureException("Радиус должен быть больше 0. Передано: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Круг (Радиус: %.2f, Площадь: %.2f, Периметр: %.2f)",
                radius, area(), perimeter());
    }
}
