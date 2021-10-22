package Lab2_Java;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.Scanner;

public class Serialize extends Main {

    public void SerializeSave() {
        try {
            FileOutputStream fileS = new FileOutputStream("Triangle.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fileS);
            for (int i = 0; i < TriangleCount; i++) {
                oos.writeObject(triangle[i]);
            }
            for (int i = 0; i < TriangleCount; i++) {
                oos.writeObject(rightTriangle[i]);
            }
            oos.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void SerializeLoad() {
        try {
            FileInputStream fileL = new FileInputStream("Triangle.bin");
            ObjectInputStream ois = new ObjectInputStream(fileL);
            for (int i = 0; i < TriangleCount; i++) {
                triangle[i] = (Triangle) ois.readObject();
                System.out.println(triangle[i].toString());
            }
            for (int i = 0; i < TriangleCount; i++) {
                rightTriangle[i] = (RightTriangle) ois.readObject();
                System.out.println(rightTriangle[i].toString());
            }
            ois.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void SerializeSaveJson() {
        FileWriter outStream = null;
        try {
            outStream = new FileWriter("Triangle.json");
            BufferedWriter bw = new BufferedWriter(outStream);
            bw.write(JSON.toJSONString(triangle));
            bw.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SerializeLoadJson() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("Triangle.json"));
            triangle = JSON.parseObject(scanner.nextLine(), Triangle[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.close();
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle[i].toString());
        }
    }
}
