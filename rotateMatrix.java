/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

*/


public boolean rotateMatrix(int [][]matrix){

       if (matrix.length != matrix[0].length || matrix.length == 0) return false;

       for (int layer = 0; layer < (matrix.length/2); layer++) {
           int first = layer;
           int last = matrix.length - 1 - layer;
           for (int i = 0; i < last; i++){
               int offset = i - first;
               //top -> temp
               int tempTop = matrix[first][i];

               //left -> top
               matrix[first][i] = matrix[last - offset][first];

               //bottom -> left
               matrix[last - offset][first] = matrix[last][last - offset];

               //right -> bottom
               matrix[last][last - offset] = matrix[last - offset][last];

               //topTemp -> right
               matrix[i][last] = tempTop;
           }
       }
       return true;
   }
