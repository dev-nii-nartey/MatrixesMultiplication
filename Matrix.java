import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    public static void main(String args[]) {

        System.out.println("Lets get your first matrix...");
        int[] userInput = getValuesForMatrix();

        int[][] firstMatrix = buildMatrix(userInput, userInput[userInput.length - 2], userInput[userInput.length - 1]);

        System.out.println("Lets get your second matrix...");
        userInput = getValuesForMatrix();

        int[][] secondMatrix = buildMatrix(userInput, userInput[userInput.length - 2], userInput[userInput.length - 1]);

        int[][] outPut = matrixMultplication(firstMatrix, secondMatrix);

        for (int i = 0; i < firstMatrix.length; i++) {
            System.out.print(" Matrix A  \n");
            printMatrix(firstMatrix);
            System.out.println("\n  multiplied by  ");
            System.out.println("\n Matrix B ");
            printMatrix(secondMatrix);
            System.out.println("\n  the product is  ");
            printMatrix(outPut);
            System.out.println();
        }

    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
    }
    private static int[][] matrixMultplication(int[][] matrixA, int[][] matrixB) {

        if (matrixA[0].length != matrixB.length) {
            System.out.println("Matrix multiplication not possible");
            return null;
        }
    
        int[][] result = new int[matrixA.length][matrixB[0].length];
    
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrixB.length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }
    
    private static int[][] buildMatrix(int[] arr, int row, int col) {

        int[][] matrix = new int[row][col];

        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = arr[index];
                index++;
            }
        }
        return matrix;
    }

    private static int[] getValuesForMatrix() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the dimensions of your matrix seperated by a (,): ");
                String[] dimensions = sc.nextLine().split(",");
                if (dimensions.length != 2) {
                    throw new Exception("This application handles only two dimensional matrix");
                }
                System.out.println(Arrays.toString(dimensions));
                int row = Integer.parseInt(dimensions[0]);
                int column = Integer.parseInt(dimensions[1]);

                String userInput = "";
                for (int i = 0; i < row; i++) {
                    System.out.println("Enter values for row " + (i + 1) + " seperated by a (,):");
                    String matrixInputs = sc.nextLine();
                    userInput += matrixInputs + ",";
                }
                userInput += row + "," + column;
                // sc.close();
                String[] stringArray = userInput.split(",");
                int[] intArray = new int[stringArray.length];

                for (int i = 0; i < stringArray.length; i++) {
                    intArray[i] = Integer.parseInt(stringArray[i]);
                }
                return intArray;
            } catch (Exception e) {
                // T
                System.out.println(e.getMessage());
            }
        }
    }

}