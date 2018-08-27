//Contributed by Nouru Muneza. 


/* Time complexity for this solution: Big O(n).
   Space complexity: O(1).
*/

public class Main {

    public static void removeDuplicates(int [] arr){
        int j = 1;
        int counter = 0;
        int i =0;
        int index=0;

        if(arr.length <2) return; //No possible duplicates

        while (j<arr.length){
            if(arr[index] == arr[j]){ //only move j++ pointer if both values for index and j are the same. 
                j++;
               // continue;
            }
            else if (arr[index] != arr[j] && (j-index > 1 )){ //override arr[index+1] with different element at j. 
                arr[index+1] = arr[j];
                index++;
                j++;
            }
            else /*increment both pointers if they are not the same and j 
             i s next to index(no replacement to be done). */
            {
                index++;
                j++;
            }
        }
        printArr(arr,index); //call printArr with index since it's keeps track of unique elements in arr
    }

    public static void printArr(int []arr, int n){ //Print Func
        for (int i = 0; i < n+1; i++){
            System.out.print(arr[i]+",");
        }
    }

    public static void main(String [] args){
        int []arr = {1,2,2,3,3,3,4,4,5,99,99};
        removeDuplicates(arr);
    }
}

/*
Output
1,2,3,4,5,99,
Process finished with exit code 0

 */
