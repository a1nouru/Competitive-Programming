public class MyList {

        private final class MyListNode {
            int value;
            MyListNode next;

            MyListNode(int value) {
                this.value = value;
                
            }
        }

        private MyListNode head;
        private MyListNode tail;

        public void add(int value) {
            MyListNode newnode = new MyListNode(value);

            if (tail == null) {
                head = newnode;
            } else {
                tail.next = newnode;
            }

            tail = newnode;
        }

        public void partition(int pivot) {
            MyListNode smallListHead = null;
            MyListNode smallListTail = null;
            MyListNode largeListHead = null;
            MyListNode largeListTail = null;

            while (head != null) {
                // Remove the head node H:
                MyListNode currentNode = head;
                head = head.next;
                
                // Decide to which of the two lists to append the node H:
                if (currentNode.value < pivot) {
                    if (smallListTail == null) {
                        smallListHead = currentNode;
                    } else {
                        smallListTail.next = currentNode;
                    }

                    smallListTail = currentNode;
                } else {
                    if (largeListTail == null) {
                        largeListHead = currentNode;
                    } else {
                        largeListTail.next = currentNode;
                    }

                    largeListTail = currentNode;
                }
            }

            if (smallListHead == null) {
                head = largeListHead;
            } else if (largeListHead == null) {
                head = smallListHead;
            } else {
                head = smallListHead;
                smallListTail.next = largeListHead;
                tail = largeListTail;
                // Marks the end of the list, otherwise might be a cycle:
                largeListTail.next = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder().append('[');
            String separator = "";

            for (MyListNode node = head; node != null; node = node.next) {
                sb.append(separator).append(node.value);
                separator = ", ";
            }
            return sb.append(']').toString();
        }
        
        public static void main(String[] args) {
            MyList list = new MyList();
            
            list.add(3);
            list.add(5);
            list.add(8);
            list.add(5);
            list.add(1);
            list.add(10);
            list.add(2);
            
            System.out.println(list);
            list.partition(5);
            System.out.println(list);
            
        }
    }
