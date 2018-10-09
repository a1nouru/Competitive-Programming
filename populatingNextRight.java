public void connect(TreeLinkNode root) {
    if(root == null) 
        return;
 
    TreeLinkNode lastHead = root;//prevous level's head 
    TreeLinkNode lastCurrent = null;//previous level's pointer
    TreeLinkNode currentHead = null;//currnet level's head 
    TreeLinkNode current = null;//current level's pointer
 
    while(lastHead!=null){
        lastCurrent = lastHead;
 
        while(lastCurrent!=null){
            if(currentHead == null){
                currentHead = lastCurrent.left;
                current = lastCurrent.left;
            }else{
                current.next = lastCurrent.left;
                current = current.next;
            }
 
            if(currentHead != null){
                current.next = lastCurrent.right;
                current = current.next;
            }
 
            lastCurrent = lastCurrent.next;
        }
 
        //update last head
        lastHead = currentHead;
        currentHead = null;
    }
 
}
