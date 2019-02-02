/*
Question and solution from: https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
Example :

Input :  arr[] = [1, 2, 3, 4, 5, 6, 7]
         d = 2
Output : arr[] = [3, 4, 5, 6, 7, 1, 2] 
Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is :

Reverse A to get ArB, where Ar is reverse of A.
Reverse B to get ArBr, where Br is reverse of B.
Reverse all to get (ArBr) r = BA.
Example :
Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
A = [1, 2] and B = [3, 4, 5, 6, 7]

Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]

*/
 
 /* Function to left rotate arr[] of size n by d */
    static void leftRotate(int arr[], int d) 
    { 
        int n = arr.length; 
        rvereseArray(arr, 0, d-1); 
        rvereseArray(arr, d, n-1); 
        rvereseArray(arr, 0, n-1); 
    } 
  
    /*Function to reverse arr[] from index start to end*/
    static void rvereseArray(int arr[], int start, int end) 
    { 
        int temp; 
        while (start < end) 
        { 
            temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--; 
        } 
    } 
    
   //This code is contributed by Devesh Agrawal
