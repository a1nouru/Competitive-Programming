/*

Given an array containing N elements. Find if it is possible to sort it in non-decreasing order using atmost one swap.

Examples:

Input : arr[] = {1, 2, 3, 4}
Output : YES
The array is already sorted

Input : arr[] = {3, 2, 1}
Output : YES
Swap 3 and 1 to get [1, 2, 3]

Input : arr[] = {4, 1, 2, 3}
Output :NO

*/



/*
An efficient solution is to check in linear time. Let us consider different cases that may appear after one swap.

We swap adjacent elements. For example {1, 2, 3, 4, 5} becomes {1, 2, 4, 3, 5}
We swap non-adjacent elements. For example {1, 2, 3, 4, 5} becomes {1, 5, 3, 4, 2}
We traverse the given array. For every element, we check if it is smaller than the previous element. We count such occurrences. If the count of such occurrences is more than 2, then we cannot sort the array with one swap. If the count is one, we can find elements to swap (smaller and its previous).
If the count is two, we can find elements to swap (previous of first smaller and second smaller).
After swapping, we again check if array becomes sorted or not. We check this to handle cases like {4, 1, 2, 3}

*/

int checkSorted(int n, int arr[]) 
{ 
    // Find counts and positions of  
    // elements that are out of order. 
    int first = 0, second = 0; 
    int count = 0; 
    for (int i = 1; i < n; i++) { 
        if (arr[i] < arr[i - 1]) { 
            count++; 
            if (first == 0) 
                first = i; 
            else
                second = i; 
        } 
    } 
  
    // If there are more than two elements 
    // are out of order. 
    if (count > 2) 
        return false; 
  
    // If all elements are sorted already 
    if (count == 0) 
        return true; 
  
    // Cases like {1, 5, 3, 4, 2} 
    // We swap 5 and 2. 
    if (count == 2) 
        swap(arr[first - 1], arr[second]); 
  
    // Cases like {1, 2, 4, 3, 5} 
    else if (count == 1) 
        swap(arr[first - 1], arr[first]); 
  
    // Now check if array becomes sorted 
    // for cases like {4, 1, 2, 3} 
    for (int i = 1; i < n; i++) 
        if (arr[i] < arr[i - 1]) 
            return false; 
  
    return true; 
} 
