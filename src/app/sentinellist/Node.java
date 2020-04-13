package app.sentinellist;

/**
 * Node hold the value and reference to next and previous entries from Sentinel Linked List
 * 
 * @author Prateek Singh
 */
class Node {
    private Node prevEntry;
    private Node nextEntry;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getPrevEntry() {
        return prevEntry;
    }

    public void setPrevEntry(Node prevEntry) {
        this.prevEntry = prevEntry;
    }

    public Node getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(Node nextEntry) {
        this.nextEntry = nextEntry;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }    
}