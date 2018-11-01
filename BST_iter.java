/*

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Credits:

Special thanks to @ts for adding this problem and creating all test cases.
*/
 
 
 //The key to understanding this problem is by recalling basic features that make up a BST and using a stack 
 //to keep list of left most subtree. 

public class BSTIterator { 

        private Stack<TreeNode> stack;
        public BSTIterator (TreeNode root){
              stack = new Stack<>();

              while(root != null ){
                  stack.push(root);
                  root = root.left;
              }
        }

        public boolean hasNext(){
            return stack.isEmpty();
        }
        
        public int next(){
            TreeNode curr = stack.pop();

            int val = current.val;

            curr = curr.right;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            return val;
        }
    }
