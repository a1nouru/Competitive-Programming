/*

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

class Node{ //Doubly LinkedList
    int key;
    int value;
    
    Node prev;
    Node next;
    
    public Node(int value, int key){
        this.value = value;
        this.key = key;
    }
}


//recent Node added to front and least recent node at tail;
class LRUcache{
    int capacity;
    int count;
    
    Map<integer, Node> map;
    public LRUcahe(int capacity){
        this.capacity = capacity;
        this.count = 0;
        
        head = new Node(0,0);
        tail = new Node(0,0);
        
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        
        map = new HashMap<>();
    }
    
    public Node removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        map.remove(node.val);
        
        count--;
        
        return node;
    }
    
    public void addNode(Node node){ 
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
        
        map.put(node.val, node);
        
        count++;
    }
    
    public void removeLastNode(){
        map.remove(tail.prev.val);
        
        tail.prev  = tail.prev.prev;
        tail.prev.next = tail;
        count--;
    }
    
    public int get(int key){
        if(map.contains(key)){
            Node node = map.get(key);
            addNode(removeNode(node)) //refresh node entry to come to front after accessed 
            return node.val;
        }
        return -1; //node contained 
    }
    
    public void put(int key, int value){
        Node node  = new Node(key,value);
        
        if(map.containsKey(key)){
            removeNode(map.get(key)); //remove initial entry of Node
        }
        
        if(count == capacity){ //max size attained 
            removeLastNode();
        }
        addNode(node);
    }
}
