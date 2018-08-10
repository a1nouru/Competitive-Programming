  
//Time complexity: Big O(n^2) where n is the number of nodes in the tree. 
int getHeight(TreeNode root){
            if(root == null) return -1;
  
            return Math.max(getHeight(root.left), getHeight(root.right))+1; // find height of this subtree
        }

        boolean is_balanced(TreeNode root){
            if(root == null) //base case
                return true;
            int heightDiff = (getHeight(root.left) - getHeight(root.right));

            if(Math.abs(heightDiff) > 1){ //check if height is >1
                return false;
            }
            else
                return is_balanced(root.left) && is_balanced(root.right); > //recursive call to move down the tree while checking all heights
        }


// A more optimized solution.

//Here the idea is to subtract min dept(value returned by midepth) from Max depth and the we can find difference in height. 
boolean isBalanced(TreeNode root){
            if(root == null) throw new IllegalArgumentException("tree is empty");

            return maxDepth(root) - minDepth(root) <=1;
        }

        int maxDepth(TreeNode root){ //finding max depth of the root
            if (root == null) return 0;

            return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
        }

        int minDepth(TreeNode root){ //finding min depth of the root 
            if (root == null) return 0;
            
            return Math.min(minDepth(root.left), minDepth(root.right))+1;
        }
