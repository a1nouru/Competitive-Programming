/*
HOW IT WORKS: 

//Left
1. If left subtree exists, process the left subtree
…..1.a) Recursively convert the left subtree to DLL.
…..1.b) Then find rightmost node in left subtree).
…..1.c) Make rightmost node in left subtree as previous of root and root as next of rightmost node in left subtree

//Right
2. If right subtree exists, process the right subtree (Below 3 steps are similar to left subtree).
…..2.a) Recursively convert the right subtree to DLL.
…..2.b) Then find leftmost node in right subtree).
…..2.c) Make leftmost node in right subtree as next of root and root as previous of leftmost node in right subtree.
3. Find the leftmost node and return it (the leftmost node is always head of converted DLL).

*/

// The main function that first calls bintree2listUtil(), then follows 
    // step 3 of the above algorithm 
       
    Node bintree2list(Node node)  
    { 
        // Base case 
        if (node == null) 
            return node; 
   
        // Convert to DLL using bintree2listUtil() 
        node = bintree2listUtil(node); 
   
        // bintree2listUtil() returns root node of the converted 
        // DLL.  We need pointer to the leftmost node which is 
        // head of the constructed DLL, so move to the leftmost node 
        while (node.left != null) 
            node = node.left; 
   
        return node; 
    } 

Node bintree2listUtil(Node node)  
    { 
        // Base case 
        if (node == null) 
            return node; 
   
        // Convert the left subtree and link to root 
        if (node.left != null)  
        { 
            // Convert the left subtree 
            Node left = bintree2listUtil(node.left); 
   
            // Find rightmost node in left subtree. After this loop, left 
            // will point to the inorder predecessor 
            for (; left.right != null; left = left.right); 
   
            // Make root as next of the predecessor 
            left.right = node; 
   
            // Make predecssor as previous of root 
            node.left = left; 
        } 
   
        // Convert the right subtree and link to root 
        if (node.right != null)  
        { 
            // Convert the right subtree 
            Node right = bintree2listUtil(node.right); 
   
            // Find inorder successor. After this loop, right 
            // will point to the inorder successor 
            for (; right.left != null; right = right.left); 
   
            // Make root as previous of successor 
            right.left = node; 
   
            // Make successor as next of root 
            node.right = right; 
        } 
   
        return node; 
    } 
