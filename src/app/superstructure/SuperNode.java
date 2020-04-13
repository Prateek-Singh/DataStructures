package app.superstructure;

/**
 * SuperNode to hold key and value. For our code key is int and value is String.
 * collissionEntry is used for HashTable. prevEntry and nextEntry for
 * LinkedList. rightEntry and leftEntry for Binary Search Tree.
 * 
 * @author Prateek Singh
 */
public class SuperNode {
    private int key;
    private String value;
    private SuperNode collissionEntry;
    private SuperNode prevEntry;
    private SuperNode nextEntry;
    private SuperNode leftEntry;
    private SuperNode rightEntry;

    public SuperNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.collissionEntry = null;
        this.prevEntry = null;
        this.nextEntry = null;
        this.leftEntry = null;
        this.rightEntry = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SuperNode getCollissionEntry() {
        return collissionEntry;
    }

    public void setCollissionEntry(SuperNode collissionEntry) {
        this.collissionEntry = collissionEntry;
    }

    public SuperNode getPrevEntry() {
        return prevEntry;
    }

    public void setPrevEntry(SuperNode prevEntry) {
        this.prevEntry = prevEntry;
    }

    public SuperNode getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(SuperNode nextEntry) {
        this.nextEntry = nextEntry;
    }

    public SuperNode getLeftEntry() {
        return leftEntry;
    }

    public void setLeftEntry(SuperNode leftEntry) {
        this.leftEntry = leftEntry;
    }

    public SuperNode getRightEntry() {
        return rightEntry;
    }

    public void setRightEntry(SuperNode rightEntry) {
        this.rightEntry = rightEntry;
    }
}