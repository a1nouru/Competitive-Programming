  int getHeight(TreeNode root){
            if(root == null) return -1;

            return Math.max(getHeight(root.left), getHeight(root.right))+1;
        }

        boolean is_balanced(TreeNode root){
            if(root == null)
                return true;
            int heightDiff = (getHeight(root.left) - getHeight(root.right));

            if(Math.abs(heightDiff) > 1){
                return false;
            }
            else
                return is_balanced(root.left) && is_balanced(root.right);
        }
