package app.sentinellist;

/**
 * Implementation of Sentinel Linked List with add/remove/display operations
 * 
 * @author Prateek Singh
 */
public class SentinelLinkedList<T> {
    //Create sentinel head and tail nodes
    Node<T> head;
    Node<T> tail;
    
    public SentinelLinkedList() {

        //Initialize with empty object
        head = new Node<>(new Object());
        tail = new Node<>(new Object());

        //Initially point sentinel head and tail to each other
        head.setNextEntry(tail);
        tail.setPrevEntry(head);
    }
  
    //For add we need to ensure that the element is added in between head and tail
    //So we create the newnode and then change the reference of next and prev nodes entries
    public boolean add(T value) {
        Node<T> newNode = new Node<>(value);    
        newNode.setPrevEntry(tail.getPrevEntry());
        newNode.setNextEntry(tail);   
        tail.getPrevEntry().setNextEntry(newNode);
        tail.setPrevEntry(newNode);     
        return true;
    }

    //For remove we can consider that the node is always between sentinel head and tail
    //So we just need to remove the node and set appropriate next and previous entries
    //So even after removal of node the sentinel linked list is maintained 
    //We check if type implements Comparable and use it's compareTo for removal of Node
    public boolean remove(T value) {
        for(Node<T> current = head.getNextEntry(); current != tail; current = current.getNextEntry()) {
           if (value instanceof Comparable && current.getValue() instanceof Comparable) {
                if (((Comparable) current.getValue()).compareTo(value) == 0) {
                    current.getPrevEntry().setNextEntry(current.getNextEntry());
                    current.getNextEntry().setPrevEntry(current.getPrevEntry());
                    return true;
                }
           }
        }
        return false;
    }

    //Display the Sentinel Linked List by going over nodes between head and tail
    public void display() {
        System.out.println("\nSentinel Linked List");
        System.out.print("[Head] => ");
        for(Node current = head.getNextEntry(); current != tail; current = current.getNextEntry()) {
            System.out.print(String.format("%s => ", current.getValue()));
        }        
        System.out.println("[Tail]");
    }
}