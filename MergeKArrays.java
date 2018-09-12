package sample;


import java.util.*;


public class Main {

    static class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }
    }

    public static int[] mergeKSortedArray(int[][] arr) {
        //PriorityQueue is heap in Java
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
        int total=0;

        //Adding arrays to heap.
        for (int i = 0; i < arr.length; i++){
            queue.add(new ArrayContainer(arr[i],0));
            //Total size of the final array.
            total += arr[i].length;

        }
        System.out.println(total);
        int m = 0;
        int [] results = new int[total];

        while(!queue.isEmpty()){
            ArrayContainer tempContainer = queue.poll();

            results[m++] = tempContainer.arr[tempContainer.index];

            if (tempContainer.index < tempContainer.arr.length-1){
                queue.add(new ArrayContainer(tempContainer.arr, tempContainer.index+1));
            }
        }

       return results;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }
}

//**********Output************
/*

[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

Process finished with exit code 0

*/
