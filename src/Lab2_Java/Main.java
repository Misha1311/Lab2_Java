package Lab2_Java;

public class Main {

    public static void main(String[] args) {
        double averagesquare = 0;
        double maxhypos = 0;
        Triangle[] triangle = new Triangle[5];
        for (int i = 0; i < 5; i++) {
            triangle[i] = new Triangle();
            System.out.println(triangle[i].toString());
            averagesquare += triangle[i].getSquare();
        }

        RightTriangle[] rightTriangle = new RightTriangle[5];
        for (int j = 0; j < 5; j++) {
            rightTriangle[j]= new RightTriangle();
            System.out.println(rightTriangle[j].toString());
            if (rightTriangle[j].getC() > maxhypos)
            {
                maxhypos = rightTriangle[j].getC();
            }
        }
        System.out.println("Средняя площадь " + averagesquare/5);
        System.out.println("Максимальная гипотенуза " + maxhypos);
    }
}
