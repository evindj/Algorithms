import java.util.*;
public class LRUCache {
    public class LRUNode{
        public int value;
        public int key;
        public LRUNode next;
        public LRUNode previous;
        public LRUNode(int key, int value){
            this.value = value;
            this.key = key;
        }
    }
    HashMap<Integer, LRUNode> storage;
    LRUNode oldest, newest;
    int MAXCAP =0;
    int numberElements =0;
    public LRUCache(int capacity) {
        storage = new HashMap<>();
        MAXCAP= capacity;
        numberElements=0;
    }

    public int get(int key) {
        LRUNode current = storage.get(key);
        if(current!=null){
            moveToFront(current);
            return current.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        LRUNode current = storage.get(key);
        if(current != null){
            current.value = value;
            moveToFront(current);
        }
        else{
            if(isFull()){
                storage.remove(oldest.key);
                removeOldest();
            }
            current = new LRUNode(key,value);
            storage.put(key,current);
            addToEnd(current);
            numberElements++;
        }

    }
    private void removeOldest(){
        if(newest == oldest){
            newest = null;
            oldest = null;
        }
        if(oldest!=null){
            oldest = oldest.next;
            oldest.previous = null;
        }
        numberElements--;
    }
    private void addToEnd(LRUNode node){
        node.previous = newest;
        if(newest != null)
            newest.next = node;
        else
            oldest = node;
        newest = node;
    }
    private boolean isFull(){
        return numberElements == MAXCAP;
    }
    private void moveToFront(LRUNode node){
        if(newest == node) return;
        if(oldest != newest){
            if(oldest == node){
                oldest = oldest.next;
            }
            if(node.previous != null)
              node.previous.next = node.next;
            if(node.next != null)
              node.next.previous = node.previous;
            newest.next = node;
            node.previous = newest;
            node.next = null;
            newest = node;
        }
    }
    public void printQueue(){
      LRUNode cursor = oldest;
      while(cursor != null){
        System.out.print(cursor.key + " , ");
        cursor = cursor.next;
      }
      System.out.println("");
    }
    public static void main(String[] args){
        LRUCache cache = new LRUCache(3);
        cache.set(1,1);
        cache.printQueue();
        cache.set(2,2);
        cache.printQueue();
        cache.set(3,3);
        cache.printQueue();
        cache.set(4,4);
        cache.printQueue();
        cache.get(4);
        cache.printQueue();
        cache.get(3);
        cache.printQueue();
        cache.get(2);
        cache.printQueue();
        cache.get(1);
        cache.printQueue();
        cache.set(5,5);
        cache.printQueue();
        cache.get(1);
        cache.printQueue();
        cache.get(2);
        cache.printQueue();
        cache.get(3);
        cache.printQueue();
        cache.get(4);
        cache.printQueue();
        cache.get(5);
        cache.printQueue();
    }
}
