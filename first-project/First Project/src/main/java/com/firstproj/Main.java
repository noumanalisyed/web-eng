package com.firstproj;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Main {
    public Main()  {
        try {
            Matrix matrix1 = new Matrix(2, 2);
            matrix1.display();
            System.out.println("\n\n");
            Matrix matrix2 = new Matrix(2, 2);
            matrix2.display();
            matrix1.setMat(inputMatrix(matrix1.getRow(), matrix1.getCol()));
            matrix1.display();
            matrix2.setMat(inputMatrix(matrix2.getRow(), matrix2.getCol()));
            matrix2.display();
            Matrix matrix3 = matrix1.add(matrix2);
            matrix3.display();
        }
        catch (IOException ioException){
            System.out.println("IOException -- IOException occur");
            ioException.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Exception -- Exception occur");
            e.getMessage();
        }

    }
    public static void main(String[] args) {

       Main main =   new Main();

    }

    public int[][] inputMatrix(int r,int c) throws IOException {
        int inputData[][] = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println("Enter value Matrix["+i+"]["+j+"] = ");
                Scanner scanner = new Scanner(System.in);
                String data = scanner.nextLine();
                inputData[i][j] = Integer.parseInt(data);
            }
        }
        return inputData;
    }
}
