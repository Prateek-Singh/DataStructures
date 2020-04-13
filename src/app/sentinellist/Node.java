package app.sentinellist;

/**
 * Node hold the value and reference to next and previous entries from Sentinel Linked List
 * 
 * @author Prateek Singh
 */
class Node<T> {
    private Node<T> prevEntry;
    private Node<T> nextEntry;
    private T value;

    public Node(Object value) {        ;
        this.value = (T) value;
    }

    public Node<T> getPrevEntry() {
        return prevEntry;
    }

    public void setPrevEntry(Node<T> prevEntry) {
        this.prevEntry = prevEntry;
    }

    public Node<T> getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(Node<T> nextEntry) {
        this.nextEntry = nextEntry;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }    
}