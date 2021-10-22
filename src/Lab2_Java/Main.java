package Lab2_Java;

public class Main {
    public static final int TriangleCount = 5;
    public static Triangle[] triangle = new Triangle[TriangleCount];
    public static RightTriangle[] rightTriangle = new RightTriangle[TriangleCount];


    public static void main(String[] args) {
        double averagesquare = 0;
        double maxhypos = 0;
        Serialize serialize = new Serialize();

        for (int i = 0; i < TriangleCount; i++) {
            triangle[i] = new Triangle(true);
            System.out.println(triangle[i].toString());
            averagesquare += triangle[i].getSquare();
        }

        for (int j = 0; j < TriangleCount; j++) {
            rightTriangle[j] = new RightTriangle(true);
            System.out.println(rightTriangle[j].toString());
            if (rightTriangle[j].getC() > maxhypos) {
                maxhypos = rightTriangle[j].getC();
            }
        }
        System.out.println("Средняя площадь " + averagesquare / 5);
        System.out.println("Максимальная гипотенуза " + maxhypos);
        System.out.println("\nНативная сериализация \n--------------------------------------------------------------------------------------------------------------------------------");
        serialize.SerializeSave();
        serialize.SerializeLoad();
        System.out.println("\nJSON сериализация \n--------------------------------------------------------------------------------------------------------------------------------");
        serialize.SerializeSaveJson();
        serialize.SerializeLoadJson();
    }

}
