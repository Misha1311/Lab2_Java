package Lab2_Java;

import lombok.Getter;
import java.util.Random;
import java.io.Serializable;


public class Triangle implements Serializable {
    Random random = new Random();

    @Getter private double a;
    @Getter private double b;
    @Getter private double c;
    @Getter private double angle1;
    @Getter private double angle2;
    @Getter private double angle3;
    @Getter private double perimeter;
    @Getter private double square;

    public Triangle(){
        do {
            setRand();
        }while (!isExist());
        Angle();
        Perimeter();
        Square();
    }

    public void setRand() {
        this.a = random.nextInt(10) + 1;
        this.b = random.nextInt(10) + 1;
        this.c = random.nextInt(10) + 1;
    }

    public boolean isExist() {
        return a + b > c && b + c > a && a + c > b;
    }

    public void Angle() {
        angle1 = Math.round(Math.toDegrees(Math.acos(((a * a) + (c * c) - (b * b)) / (2 * a * c))));
        angle2 = Math.round(Math.toDegrees(Math.acos(((a * a) + (b * b) - (c * c)) / (2 * a * b))));
        angle3 = Math.round(Math.toDegrees(Math.acos(((b * b) + (c * c) - (a * a)) / (2 * c * b))));
    }

    public void Perimeter() {
        perimeter = a + b + c;
    }

    public void Square() {
        square = Math.round(Math.sqrt((perimeter / 2) * ((perimeter / 2) - a) * ((perimeter / 2) - b) * ((perimeter / 2) - c)));
    }

    @Override
    public String toString() {
        return "Треугольник{ " +
                "a = " + a +
                ", b = " + b +
                ", c = " + c +
                ", Угол 1 = " + angle1 +
                ", Угол 2 = " + angle2 +
                ", Угол 3 = " + angle3 +
                ", Периметр = " + perimeter +
                ", Площадь = " + square +
                '}';
    }
}
