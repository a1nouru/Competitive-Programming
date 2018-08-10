//creating a BST from a sorted array. 

//time complexity: Big O(n)
TreeNode isBST(int array[], int start, int end){
             if(array == null || array.length == 0 || start > end) {
                 return null;
             }

            int mid = (end+start)/2;
            TreeNode root = new TreeNode(array[mid]);

            root.left = isBST(array, start, mid-1);
            root.right = isBST(array, mid+1, end);

            return root;
         }
         
      
