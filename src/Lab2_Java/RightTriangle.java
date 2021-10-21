package Lab2_Java;

import java.io.Serializable;

public class RightTriangle extends Triangle implements Serializable {
    public RightTriangle() {
        super();
        while (!isRight()){
            setRand();
        }
        Angle();
        Perimeter();
        Square();
    }

    public boolean isRight() {
        return getC() > getA() && getC() > getB() && (getA() * getA()) + (getB() * getB()) == (getC() * getC());
    }

    @Override
    public String toString() {
        return "Прямоугольный треугольник{ " +
                "a = " + getA() +
                ", b = " + getB() +
                ", c = " + getC() +
                ", Угол 1 = " + getAngle1() +
                ", Угол 2 = " + getAngle2() +
                ", Угол 3 = " + getAngle3() +
                ", Периметр = " + getPerimeter() +
                ", Площадь = " + getSquare() +
                '}';
    }
}
