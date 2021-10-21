package Lab2_Java;

public class Main {

    public static void main(String[] args) {
        double averagesquare = 0;
        double maxhypos = 0;
        Serialize serialize = new Serialize();

        for (int i = 0; i < TriangleCount; i++) {
            triangle[i] = new Triangle();
            System.out.println(triangle[i].toString());
            averagesquare += triangle[i].getSquare();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        for (int j = 0; j < TriangleCount; j++) {
            rightTriangle[j]= new RightTriangle();
            System.out.println(rightTriangle[j].toString());
            if (rightTriangle[j].getC() > maxhypos)
            {
                maxhypos = rightTriangle[j].getC();
            }
        }
        System.out.println("Средняя площадь " + averagesquare/5);
        System.out.println("Максимальная гипотенуза " + maxhypos);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        serialize.SerializeSave();
        serialize.SerializeLoad();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        serialize.SerializeSaveJson();
        serialize.SerializeLoadJson();
    }

}
