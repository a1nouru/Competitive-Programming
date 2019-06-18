/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.
*/ 

/* 
HOW THIS WORKS: 
Essentially we are using the number of elements less than k to get closer to the kth smallest element. 
If number of elems less than mid is less than k then lo = mid+1 else hi = end. Mid will eventually be equal to kth smallest 
elem and low and hi will be equal hence exiting from the Binary search loop. 
*/
class Solution{
    public int kthSmallest(int [][] matrix, int k){
        if ( matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, low = matrix[0][0], high = matrix[m-1][m-1];
        
        while(low < high){
            int mid = (low + high)/2;
            int count = counting(matrix, mid); // num of elements less than mid. 
            if (count < k) low = mid+1; 
            else high = mid;
        }
        return low; 
    }
    
    public int counting(int [][] matrix, int mid){
        int i = matrix.length-1, j = 0, count = 0;
        
        while (i >= 0 && j < matrix[0].length){
            if (matrix[i][j] <= mid){ 
                j++;
                count += i+1; // num elemets less than mid 
            }
            else i--;
        }
        return count;
    }
}
