package superstructure;

public class Node {
    private int key;
    private String value;
    private Node collissionEntry;
    private Node prevEntry;
    private Node nextEntry;
    private Node leftEntry;
    private Node rightEntry;

    public Node(int key, String value) {
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

    public Node getCollissionEntry() {
        return collissionEntry;
    }

    public void setCollissionEntry(Node collissionEntry) {
        this.collissionEntry = collissionEntry;
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

    public Node getLeftEntry() {
        return leftEntry;
    }

    public void setLeftEntry(Node leftEntry) {
        this.leftEntry = leftEntry;
    }

    public Node getRightEntry() {
        return rightEntry;
    }

    public void setRightEntry(Node rightEntry) {
        this.rightEntry = rightEntry;
    }
}