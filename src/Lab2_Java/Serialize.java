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
        FileWriter outStreamT = null;
        FileWriter outStreamR = null;
        try {
            outStreamT = new FileWriter("Triangle.json");
            outStreamR = new FileWriter("RightTriangle.json");
            BufferedWriter bwT = new BufferedWriter(outStreamT);
            BufferedWriter bwR = new BufferedWriter(outStreamR);
            bwT.write(JSON.toJSONString(triangle));
            bwR.write(JSON.toJSONString(rightTriangle));
            bwT.close();
            bwR.close();
            outStreamT.close();
            outStreamR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SerializeLoadJson() {
        Scanner scannerT = null;
        Scanner scannerR = null;
        try {
            scannerT = new Scanner(new FileReader("Triangle.json"));
            scannerR = new Scanner(new FileReader("RightTriangle.json"));
            triangle = JSON.parseObject(scannerT.nextLine(), Triangle[].class);
            rightTriangle = JSON.parseObject(scannerR.nextLine(), RightTriangle[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle[i].toString());
        }
        for (int i = 0; i < rightTriangle.length; i++) {
            System.out.println(rightTriangle[i].toString());
        }
        scannerT.close();
        scannerR.close();
    }
}