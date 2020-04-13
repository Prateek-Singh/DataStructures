package app.binarysearchtree;

/**
 * Node that holds the value and refrence to left and right entries.
 * 
 * @author Prateek Singh
 */
public class Node {
    private Node rightEntry;
    private Node leftEntry;
    private int value;

    public Node(int value) {
        this.value = value;
        this.rightEntry = null;
        this.leftEntry = null;
    }

    public Node getRightEntry() {
        return rightEntry;
    }

    public void setRightEntry(Node rightEntry) {
        this.rightEntry = rightEntry;
    }

    public Node getLeftEntry() {
        return leftEntry;
    }

    public void setLeftEntry(Node leftEntry) {
        this.leftEntry = leftEntry;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }    
}