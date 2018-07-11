package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

/**

 *****QUESTION******
 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 write a method to rotate the image by 90 degrees. Can you do this in place?
 
 QUESTIONS TO ASK INTERVIEWER: 
 Is rotation clock-wise or Anti-clock wise?
 Usually most interviewer will say clock wise, but don't just assume. 

 EXPLANATION
 A very common approach would be to sway each index. You dont want to create temp arrays because you'd be eating up
 memory.

 TIME: BIG O(N^2) We can get any better since we have to traverse through a 2D grid anyways
 */

public class Main {

    static boolean rotateArr(int [][] matrix)
    {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false; // We cant rotate in this case

        int n = matrix.length;
        for(int layers = 0; layers < n/2; layers++){
            int first = layers;
            int last  = n - 1 - layers;
            for (int i = first; i< last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                //left -> top
                matrix[first][i] = matrix[last - offset][first];

                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top;
            }
        }
        print(matrix);
        return true;
    }

    static void print(int[][] matrix) {
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
        rotateArr(grid);
    }
}

/****OUTPU*****

1 9 0 1 
9 10 1 2 
0 11 7 3 
4 12 8 4 

Process finished with exit code 0
*/
