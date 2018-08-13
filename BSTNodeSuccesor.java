 /*
        1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
        Go to right subtree and return the node with minimum key value in right subtree.
        2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
        Travel up using the parent pointer until you see a node which is left child of it’s parent. 
        The parent of such a node is the succ.
         */
        public TreeNode minValue(TreeNode node){
            TreeNode temp = node.left;
            TreeNode n = null;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        public TreeNode inOrderSuccessor(TreeNode root, TreeNode n){

            if(n.right != null) return minValue(n.right);

            TreeNode p = n.parent;
            while(p != null && n == p.right){
                n = p;
                p = p.parent;
            }

            return p; // return parent of node that was left child. 
        }
