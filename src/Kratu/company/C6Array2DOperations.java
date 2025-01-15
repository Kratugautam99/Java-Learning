package Kratu.company;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
public class C6Array2DOperations{
    public static int[][] matrixBuilder(int rows,int columns){
        int[][] matrix = new int[rows][columns];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                try{
                    System.out.printf("Enter for position [%d][%d] in your matrix:\n", i+1,j+1);
                    matrix[i][j] = sc.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.print("Invalid Input, Try Again with Int Input.\n");
                    sc.next();
                    j--;
                }
            }
        }
        return matrix;
    }
    public static int[][] matrixAdd(int[][] matrix1, int[][] matrix2){
        int[][] output = new int[matrix1.length][matrix1[0].length];
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length){
            for (int i = 0; i < matrix1.length; i++){
                for (int j = 0; j < matrix1[0].length; j++){
                    output[i][j] += matrix1[i][j] + matrix2[i][j];
                }
            }
        }
        else {
            System.out.println("Matrices should have equal dimensions. You will receive an empty 2D array with dimensions of the 1st matrix.\n");
        }
        return output;
    }
    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2){
        int[][] output = new int[matrix1.length][matrix2[0].length];
        if (matrix1[0].length == matrix2.length){
            for (int i = 0; i < matrix1.length; i++){
                for (int j = 0; j < matrix2[0].length; j++){
                    for (int k = 0; k < matrix1[0].length; k++){
                        output[i][j] = matrix1[i][k]*matrix2[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("Number of Columns in Matrix1 should be equal to Number of Rows in Matrix2. You will receive an empty 2D array with dimensions Matrix1 Number of Rows and Matrix2 Number of Columns.\n");
        }
        return output;
    }
    public static void matrixPrint(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
             for (int j = 0; j < matrix[0].length; j++){
                 System.out.printf("[%d]",matrix[i][j]);
             }
             System.out.println("");
        }
    }
    public static int[][] matrixReverse(int[][] matrix){
        int[][] output = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                output[Math.abs(matrix.length-1-i)][Math.abs(matrix[0].length-1-j)] = matrix[i][j];
            }
        }
        return output;
    }
    public static int[] matrixMinMax(int[][] matrix){
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] > max){
                    max = matrix[i][j];
                }
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
        }
        int[] output = {(int)max,(int)min};
        return output;
    }
    public static int[][] matrixSort(int[][] matrix){
        int[] steam = new int[matrix.length*matrix[0].length];
        int ind = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                steam[ind++] = matrix[i][j];
            }
        }
        Arrays.sort(steam);
        ind = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = steam[ind++];
            }
        }
        return matrix;
    }
    public static void main(String[] args){
        int[][] square1 = matrixBuilder(2,2);
        int[][] square2 = matrixBuilder(2,2);
        int[][] Rsquare2 = matrixReverse(square2);
        int[][] result1 = matrixAdd(square1, Rsquare2);
        int[][] result2 = matrixMultiply(square1, Rsquare2);
        System.out.println("");
        matrixPrint(square2);
        System.out.println("");
        matrixPrint(Rsquare2);
        System.out.println("");
        matrixPrint(result1);
        System.out.println("");
        matrixPrint(result2);
        System.out.println("");
        int[] arr = matrixMinMax(result1);
        System.out.println(Arrays.toString(arr));
        System.out.println("");
        matrixPrint(matrixSort(result2));
    }
}
