package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

/**

 *****QUESTION******
 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 its entire row and column are set to 0.

 BIG PITFALL: you might think that you can just iterate iterate through the matrix and every time we see a cell with value zero,
 set its row and column to 0. There's one problem with that solution though: when we come across other cells in that row or column,
 we'll see the zeros and change their row and column to zero.Pretty soon, our entire matrix will be set to zeros.


 Time: BIG O(N^2) We can get any better since we have to traverse through a 2D grid anyways 
 Space: BIG O(N)
 */

public class Main {
    static void setZeros(int[][] matrix) {
        if(matrix.length != matrix[0].length) return;
        boolean[] row = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    columns[j] = true;
                }
        }

        for (int i = 0; i < row.length; i++) {
            if(row[i]) nuliffyRow(matrix, i);
        }

        for (int j = 0; j < columns.length; j++) {
            if(columns[j]) nuliffyCol(matrix, j);
        }

        print(matrix);

    }
        static void nuliffyRow(int[][] matrix, int i){
            for(int colIndex = 0; colIndex< matrix[0].length; colIndex++){
                matrix[i][colIndex] = 0;
            }
        }

    static void nuliffyCol(int[][] matrix, int j){
        for(int rowIndex = 0; rowIndex<matrix.length; rowIndex++) {
            matrix[rowIndex][j] = 0;
        }
    }

    public static void print(int[][] matrix) {
        for(int i =0; i< matrix.length; i++) {
            for(int j =0; j< matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int  grid [][]  = { { 1, 2, 3, 4 },
                { 0, 1, 7, 8 },
                { 9, 10, 11, 12 },
                { 1, 9, 0, 4 }
        };
        setZeros(grid);
    }
}
