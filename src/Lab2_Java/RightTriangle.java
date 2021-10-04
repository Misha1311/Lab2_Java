package Lab2_Java;

public class RightTriangle extends Triangle {
    public RightTriangle() {
        do {
            setRand();
        } while (!isExist());
        Angle();
        Perimetr();
        Square();
    }

    @Override
    public boolean isExist() {
        return getC() > getA() && getC() > getB() && (getA() * getA()) + (getB() * getB()) == (getC() * getC());
    }

    @Override
    public String toString() {
        return "Прямоугльный треугольник{ " +
                "a = " + getA() +
                ", b = " + getB() +
                ", c = " + getC() +
                ", Угол 1 = " + getAngle1() +
                ", Угол 2 = " + getAngle2() +
                ", Угол 3 = " + getAngle3() +
                ", Периметр = " + getPerimetr() +
                ", Площадь = " + getSquare() +
                '}';
    }
}
