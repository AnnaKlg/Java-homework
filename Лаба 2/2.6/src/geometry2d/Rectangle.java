package geometry2d;

import exceptions.InvalidFigureException;

public class Rectangle implements Figure {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) throws InvalidFigureException {
        if (width <= 0 || height <= 0) {
            throw new InvalidFigureException(
                    String.format("Стороны прямоугольника должны быть больше 0. Передано: ширина = %.2f, высота = %.2f", width, height)
            );
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник (Ширина: %.2f, Высота: %.2f, Площадь: %.2f, Периметр: %.2f)",
                width, height, area(), perimeter());
    }
}
