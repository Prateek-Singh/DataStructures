package app.binarysearchtree;

/**
 * Implementation of Binary Search Tree with add/remove/display operations
 * 
 * @author Prateek Singh
 */
public class BinarySearchTree {
    //Root of Binary Serach Tree
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    //Add newNode and connect it to root recursively
    public boolean add(int value) {
        Node newNode = new Node(value);
        root = connectEntry(root, newNode);
        return true;
    }

    //We check if it is the first node then it will become root
    //if not then we need to recurse and set it to either root's left or right entries
    private Node connectEntry(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.getValue() > root.getValue()) {
            root.setRightEntry(connectEntry(root.getRightEntry(), newNode));
        } else {
            root.setLeftEntry(connectEntry(root.getLeftEntry(), newNode));
        }
        return root;
    }

    //Display the Binary Tree in either Ascending(L -> N -> R) or Descending(R -> N -> L) order
    public void display(boolean inDescendingOrder) {
        if (inDescendingOrder) {
            System.out.println("Binary Search Tree in Descending Order");
            displayInDescendingOrder(root);
            System.out.println();
        } else {
            System.out.println("Binary Search Tree in Ascending Order");
            displayInAscendingOrder(root);
            System.out.println();
        }
    }

    //Display the Binary Tree in Descending(R -> N -> L) order
    private void displayInDescendingOrder(Node root) {
        if (root != null) {
            displayInDescendingOrder(root.getRightEntry());
            System.out.print(String.format("%d ", root.getValue()));
            displayInDescendingOrder(root.getLeftEntry());
        }
    }

    //Display the Binary Tree in either Ascending(L -> N -> R) order
    private void displayInAscendingOrder(Node root) {
        if (root != null) {
            displayInAscendingOrder(root.getLeftEntry());
            System.out.print(String.format("%d ", root.getValue()));
            displayInAscendingOrder(root.getRightEntry());
        }
    }

    //Remove the value node from Binary Search Tree recurisevly
	public boolean remove(int value) {
        if (root != null) {
            root = deleteEntry(root, value);
            return true;
        }
        return false;
	}

    //First we check if node is null we simply return null
    //If not we check if the value is on the right side or left side of node
    //Once we find the node we check for below three checks
    private Node deleteEntry(Node node, int value) {
        if (node == null) {
            return null;
        } 

        if (value > node.getValue()) {
            node.setRightEntry(deleteEntry(node.getRightEntry(), value));
        } else if (value < node.getValue()) {
            node.setLeftEntry(deleteEntry(node.getLeftEntry(), value));
        } else {
            //If it is leaf node i.e. no right and left child exist we set it null
            if (node.getLeftEntry() == null && node.getRightEntry() == null) {
                node = null;
            } else if (node.getLeftEntry() != null && node.getRightEntry() == null) {
                //If it constains only left child and no right child we replace it with left enrtry
                node = node.getLeftEntry();
            } else if (node.getLeftEntry() == null && node.getRightEntry() != null) {
                //If it constains only right child and no left child we replace it with right enrtry
                node = node.getRightEntry();
            } else {
                //If it contains both right and left child we first need to find successor
                //To find successor we move to right child first and then recursively traverse till deepest left child
                //We switch node with successor and also update its right entries recursively
                Node successor = getSuccessor(node.getRightEntry());
                node.setValue(successor.getValue());
                node.setRightEntry(deleteEntry(node.getRightEntry(), node.getValue()));
            }
        }
        return node;
    }

    //Recursively find deepest child leaf which would be new successor
    private Node getSuccessor(Node node) {
        if (node.getLeftEntry() == null) {
            return node;
        } else {
            return getSuccessor(node.getLeftEntry());
        }
    }
}