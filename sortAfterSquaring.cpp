/*

Given a array of both positive and negative integers ‘arr[]’ which are sorted. Task is to sort square of the numbers of the Array.
Examples:

Input  : arr[] =  {-6, -3, -1, 2, 4, 5}
Output : 1, 4, 9, 16, 25, 36 

Input  : arr[] = {-5, -4, -2, 0, 1}
Output : 0, 1, 4, 16, 25

*/

// function to sort array after doing squares of elements 
void sortSquares(int arr[], int n) 
{ 
    // first dived array into part negative and positive 
    int K = 0; 
    for (K = 0 ; K < n; K++) 
        if (arr[K] >= 0 ) 
            break; 
  
    // Now do the same process that we learn 
    // in merge sort to merge to two sorted array 
    // here both two half are sorted and we traverse 
    // first half in reverse meaner because 
    // first half contain negative element 
    int i = K-1; // Initial index of first half 
    int j = K; // Initial index of second half 
    int ind = 0; // Initial index of temp array 
  
    // store sorted array 
    int temp[n]; 
    while (i >= 0 && j < n) 
    { 
        if (arr[i] * arr[i] < arr[j] * arr[j]) 
        { 
            temp[ind] = arr[i] * arr[i]; 
            i--; 
        } 
        else
        { 
            temp[ind] = arr[j] * arr[j]; 
            j++; 
        } 
        ind++; 
    } 
  
    /* Copy the remaining elements of first half */
    while (i >= 0) 
    { 
        temp[ind] = arr[i] * arr[i]; 
        i--; 
        ind++; 
    } 
  
    /* Copy the remaining elements of second half */
    while (j < n) 
    { 
        temp[ind] = arr[j] * arr[j]; 
        j++; 
        ind++; 
    } 
