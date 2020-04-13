package app.superstructure;

/**
 * SuperContainer binds nodes and performs functions for internal structures.
 * HashTable, LinkedList and Binary Search Tree
 * 
 * @author Prateek Singh
 */
public class SuperContainer {

    private final static int SENTINEL_KEY = Integer.MIN_VALUE;
    private final static String EMPTY_STRING = "";

    // Used to create HashTable as per tableSize
    private int tableSize;
    // HashTable array to hold nodes
    private SuperNode[] hashTable;
    // SentinelHead to be used as head for LinkedList
    private SuperNode sentinelHead;
    // SentinelTail to be used as tail for LinkedList
    private SuperNode sentinelTail;
    // Root to represent root node of Binary Search Tree
    private SuperNode root;

    public SuperContainer(int tableSize) {
        this.tableSize = tableSize;

        // Initialize/Create HashTable
        hashTable = new SuperNode[tableSize];

        // Initialize/Create Sentinel Head and Tail
        sentinelHead = new SuperNode(SENTINEL_KEY, EMPTY_STRING);
        sentinelTail = new SuperNode(SENTINEL_KEY, EMPTY_STRING);

        // Point SentinelHead and Tail to each other to start with
        sentinelHead.setNextEntry(sentinelTail);
        sentinelTail.setPrevEntry(sentinelHead);

        // Start root with null for Binary Search Tree
        root = null;
    }

    public boolean put(int key, String value) {
        // Calculate Hash
        int hashedOffset = hashKey(key);

        // Check if key exist then don't proceed
        for (SuperNode current = hashTable[hashedOffset]; current != null; current = current.getCollissionEntry()) {
            if (key == current.getKey()) {
                return false;
            }
        }

        // Create the SuperNode with key and value
        SuperNode newNode = new SuperNode(key, value);

        // Set the collission entry to existing SuperNode/Null
        // Set the newNode as head of HashTable for the selected hashedOffSet
        newNode.setCollissionEntry(hashTable[hashedOffset]);
        hashTable[hashedOffset] = newNode;

        // Add newNode to LinkedList
        newNode.setNextEntry(sentinelTail);
        newNode.setPrevEntry(sentinelTail.getPrevEntry());
        sentinelTail.getPrevEntry().setNextEntry(newNode);
        sentinelTail.setPrevEntry(newNode);

        // Connect the newNode with Binary Search Tree root
        root = connectEntry(root, newNode);

        return true;
    }

    public boolean remove(int key) {
        // Calculate Hash
        int hashedOffset = hashKey(key);

        // prevNode is used to hold the previous Node for deletion from HashTable
        SuperNode prevNode = null;

        for (SuperNode current = hashTable[hashedOffset]; current != null; current = current.getCollissionEntry()) {
            // Check if key matches
            if (key == current.getKey()) {
                // If previous node is not pointing to null
                // And we have a value for current's collissionEntry
                // We need to set the previous node's collissionEntry to current's
                // collissionEntry
                if (prevNode != null && current.getCollissionEntry() != null) {
                    prevNode.setCollissionEntry(current.getCollissionEntry());
                } else if (prevNode == null) {
                    // If previous node is null we can set curren't collissionEntry
                    // To selected hashedoffset in HashTable
                    hashTable[hashedOffset] = current.getCollissionEntry();
                }
            } else {
                // Hold the reference of current as previous before continuing looping
                prevNode = current;
            }
        }

        // Iterate over the LinkedList and remove the node
        for (SuperNode current = sentinelHead.getNextEntry(); current != sentinelTail; current = current
                .getNextEntry()) {
            if (key == current.getKey()) {
                // Set Previous Node's next Entry to curren't Next Entry
                current.getPrevEntry().setNextEntry(current.getNextEntry());
                // Set Current Node's prev Entry to curren't Previous Entry
                current.getNextEntry().setPrevEntry(current.getPrevEntry());
            }
        }

        // Delete the node from Binary Search Tree
        root = deleteEntry(root, key);

        return true;
    }

    private SuperNode deleteEntry(SuperNode root, int key) {
        // Check if root is null then return it
        if (root == null) {
            return root;
        }

        // Check if key is to be removed from right side recursively
        if (key > root.getKey()) {
            root.setRightEntry(deleteEntry(root.getRightEntry(), key));
        } else if (key < root.getKey()) {
            // Check if key is to be removed from left side recursively
            root.setLeftEntry(deleteEntry(root.getLeftEntry(), key));
        } else {
            // If this is the node and if it has both right and left node
            // First we need to ensure that we still maintain a Binary Search Tree after
            // removal of node
            // So we move to right and then fetch the deepest left node to be set as current
            // node
            // And also rotate the entries for right
            if (root.getLeftEntry() != null && root.getRightEntry() != null) {
                SuperNode newRoot = minimumKeyNode(root.getRightEntry());
                root.setKey(newRoot.getKey());
                root.setValue(newRoot.getValue());
                root.setRightEntry(deleteEntry(root.getRightEntry(), newRoot.getKey()));
            } else if (root.getLeftEntry() != null) {
                // If it only has left node we need to set it as root
                root = root.getLeftEntry();
            } else if (root.getRightEntry() != null) {
                // If it only has right node we need to set it as root
                root = root.getRightEntry();
            } else
                // If it is leaf node we can mark it null
                root = null;
        }
        return root;
    }

    // Recursively fetch minimum key from left
    private SuperNode minimumKeyNode(SuperNode node) {
        if (node.getLeftEntry() == null) {
            return node;
        } else {
            return minimumKeyNode(node.getLeftEntry());
        }
    }

    public void printHashTable() {
        System.out.println("\nHashTable");
        for (int index = 0; hashTable.length > index; index++) {
            // Iterate over each index of HashTable
            System.out.print(String.format("%s : ", index));
            // Iterate over each node if it has collissionEntry and print key and value
            for (SuperNode node = hashTable[index]; node != null; node = node.getCollissionEntry()) {
                System.out.print(String.format("[%s : %s]", node.getKey(), node.getValue()));
            }
            System.out.println();
        }
    }

    public void printInsertedNodesInOrder() {
        System.out.print("\nLinkedList\n[Head] => ");
        // Iterate over each node from the LinkedList and print key and value
        for (SuperNode node = sentinelHead.getNextEntry(); node != sentinelTail; node = node.getNextEntry()) {
            System.out.print(String.format("[%s : %s] => ", node.getKey(), node.getValue()));
        }
        System.out.println("[Tail]");

    }

    public void printInsertedNodesInAscByKey() {
        System.out.println("\nBinary Search Tree Ascending");
        // Print Binary Search Tree in Ascending Order based on Key from root
        printInAscOrder(root);
        System.out.println();
    }

    private void printInAscOrder(SuperNode root) {
        if (root != null) {
            // Print the keys and values in L => N => R order recursively
            printInAscOrder(root.getLeftEntry());
            System.out.print(String.format("[%s : %s] ", root.getKey(), root.getValue()));
            printInAscOrder(root.getRightEntry());
        }
    }

    public void printInsertedNodesInDscByKey() {
        System.out.println("\nBinary Search Tree Descending");
        // Print Binary Search Tree in Descending Order based on Key from root
        printInDscOrder(root);
        System.out.println();
    }

    private void printInDscOrder(SuperNode root) {
        if (root != null) {
            // Print the keys and values in R => N => L order recursively
            printInDscOrder(root.getRightEntry());
            System.out.print(String.format("[%s : %s] ", root.getKey(), root.getValue()));
            printInDscOrder(root.getLeftEntry());
        }
    }

    private SuperNode connectEntry(SuperNode root, SuperNode newNode) {
        // If root is null then return newNode as root
        if (root == null) {
            return newNode;
        }

        // Check if the newNode needs to be placed on the right recurisvely
        if (newNode.getKey() > root.getKey()) {
            root.setRightEntry(connectEntry(root.getRightEntry(), newNode));
        } else {
            // newNode needs to be placed on the left recurisvely
            root.setLeftEntry(connectEntry(root.getLeftEntry(), newNode));
        }

        return root;
    }

    private int hashKey(int key) {
        // Simpliefied implementation of Hash
        return Math.abs(key) % tableSize;
    }
}