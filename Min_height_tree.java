/*
Given a sorted (increasing order) array with unique integer elements, 
write an algorithm to create a binary search tree with minimal height.
*/

/*
Okay this can be super confusing just like all the recursive problems. 
I advice looking at the solution and writting down what the solution does. This gives you a clear image of how the solution works.
Get an array of your choice and work it out. I got
*/
 
 TreeNode creatMinimal(int array[]){
        return createMininal(array, 0, array.length-1);
    }


    TreeNode createMininal(int array[], int start, int end){

    if(end < start)
        return null;

        int mid = (start + end)/2;
        TreeNode tempNode = new TreeNode(array[mid]);

        tempNode.left = createMininal(array, 0, mid-1);
        tempNode.right = createMininal(array, mid+1, end);

        return tempNode;
    }
