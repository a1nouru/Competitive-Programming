public class LinkedList {
    Node head;
    Node tail;
    int size;
    class Node{
        Node next;
        int data;
        public Node(int d){
            next = null;
            data = d;
        }
    }

    public void append(int new_data){
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        Node temp_node = head;
        while(temp_node.next != null){
            temp_node = temp_node.next;
        }

        new_node.next = null;
        temp_node.next = new_node;
        tail = new_node;
    }
    void findSize(LinkedList list1, LinkedList list2){
        if(list1 == null || list2 == null){
            return;
        }

        Node temp_node1 = list1.head;
        Node temp_node2 = list2.head;

        int count1 = 0;

        while(temp_node1.next != null)
            count1++;


        int count2 = 0;
        while(temp_node2.next != null)
            count2++;

        list1.size = count1;
        list2.size = count2;
    }

   public Node intersect(LinkedList list1, LinkedList list2){
        Node temp_node1 = list1.head;
        Node temp_node2 = list2.head;

        if(list1.tail != list2.tail) return null; //no intersection

        int move =  Math.abs(Math.abs(list1.size - list2.size) -2);
        if(Math.abs(list1.size-list2.size) != 2) {
            if (list1.size > list2.size) {
                for (int i = 0; i < move; i++) {
                    temp_node2 = temp_node2.next;
                }
            } else {
                for (int i = 0; i < move; i++) {
                    temp_node1 = temp_node1.next;
                }
            }
        }

        if(list1.size > list2.size) {
            while (temp_node1.next != null && temp_node2 != null) {
                temp_node1 = temp_node1.next.next;
                temp_node2 = temp_node2.next;
                if (temp_node1 == temp_node2) return temp_node1;

            }
        }
        else {
            while (temp_node1.next != null && temp_node2 != null) {
                temp_node2 = temp_node2.next.next;
                temp_node1 = temp_node1.next;
                if (temp_node1 == temp_node2) return temp_node1;

            }
        }
        return null; //no intersection;
    }


    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(8);
        linkedList.append(7);
        linkedList.append(2);
        linkedList.append(3);

        LinkedList linkedList2 = new LinkedList();

        linkedList2.append(9);
        linkedList2.append(4);
        linkedList2.append(7);
        linkedList2.append(2);
        linkedList2.append(3);

        Node currtnode = intersect(linkedList, linkedList2);
    }
}
