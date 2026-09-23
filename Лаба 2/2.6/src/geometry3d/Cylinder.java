package geometry3d;

import geometry2d.Figure;
import exceptions.InvalidFigureException;
import exceptions.NullFigureException;

public class Cylinder {
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) throws InvalidFigureException {
        if (base == null) {
            throw new NullFigureException("Основание цилиндра не может быть null.");
        }
        if (height <= 0) {
            throw new InvalidFigureException("Высота цилиндра должна быть больше 0. Передано: " + height);
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        // Объем обобщенного цилиндра = площадь основания * высота
        return base.area() * height;
    }

    @Override
    public String toString() {
        return String.format("Обобщенный цилиндр (Основание: %s, Высота: %.2f, Объем: %.2f)",
                base.toString(), height, volume());
    }
}
