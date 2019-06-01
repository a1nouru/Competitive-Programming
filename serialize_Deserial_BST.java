/*

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

*/

public class Codec {
    int index = 0;
    
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        return deserialize(data.split(","));
    }
    
    public TreeNode deserialize(String [] arr){
        String val = arr[index++];
        if (val.equals("#")) return null; 
        
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialize(arr);
        root.right = deserialize(arr);
            
        return root;    
    }
}
