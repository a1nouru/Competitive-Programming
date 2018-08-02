 ArrayList<LinkedList<TreeNode>> connect(TreeNode root){

            ArrayList<LinkedList<TreeNode>> results = new ArrayList<LinkedList<TreeNode>>();
            LinkedList<TreeNode> current = new LinkedList<>();

            if(root != null)
                current.add(root);

            while(!current.isEmpty()){
                LinkedList<TreeNode> parents = current;
                current = new LinkedList<TreeNode>();
                results.add(parents);

                for(TreeNode parent : parents){

                    if(parent.left != null)
                        current.add(parent.left);
                    if(parent.right != null)
                        current.add(parent.right);
                }
            }

            return results;
        }
