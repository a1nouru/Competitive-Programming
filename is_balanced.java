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
