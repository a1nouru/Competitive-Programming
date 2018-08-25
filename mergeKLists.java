public class Main {

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public class solution{

        public ListNode mergeKLists(List<ListNode> lists){

            if(lists.size() == 0 || lists == null){
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return (o1.val - o2.val);
                }
            });
            // add all listNodes from Lists to the queue.  
            for (ListNode node: lists){
               if(node != null) queue.add(node);
            }
            ListNode dummyHead = new ListNode(0);
            ListNode p = dummyHead;

            //In this iteration, I remove the smallest ListNode and add it to the head final listNode 
            while (!queue.isEmpty()) {
                ListNode temp = queue.poll();
                p.next = temp;
                if (temp.next != null) queue.add(temp.next);
                p = p.next;
            }
            return dummyHead.next;
            
        }
    }
}

/*

Your input
[[1,4,5],[1,3,4],[2,6]]
Your answer
[1,1,2,3,4,4,5,6]

*/
