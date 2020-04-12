package superstructure;

public class Container {
    private int tableSize;
    private Node[] hashTable;
    private Node sentinelHead;
    private Node sentinelTail;
    private Node root;

    public Container(int tableSize) {
        this.tableSize = tableSize;

        hashTable = new Node[tableSize];

        sentinelHead = new Node(-1, "Sentinel Head");
        sentinelTail = new Node(-1, "Sentinel Tail");

        sentinelHead.setNextEntry(sentinelTail);
        sentinelTail.setPrevEntry(sentinelHead);

        root = null;
    }

    public boolean put(int key, String value) {
        int hashedOffset = hashKey(key);

        for (Node current = hashTable[hashedOffset]; current != null; current = current.getCollissionEntry()) {
            if (key == current.getKey()) {
                return false;
            }
        }

        Node newNode = new Node(key, value);

        newNode.setCollissionEntry(hashTable[hashedOffset]);
        hashTable[hashedOffset] = newNode;

        newNode.setNextEntry(sentinelTail);
        newNode.setPrevEntry(sentinelTail.getPrevEntry());
        sentinelTail.getPrevEntry().setNextEntry(newNode);
        sentinelTail.setPrevEntry(newNode);

        root = connectEntry(root, newNode);

        return true;
    }

    public void printHashTable() {
        System.out.println("HashTable");
        for (int index = 0; hashTable.length > index; index++) {
            System.out.print(String.format("%s : ", index));
            for (Node node = hashTable[index]; node != null; node = node.getCollissionEntry()) {
                System.out.print(String.format("[%s : %s]", node.getKey(), node.getValue()));
            }
            System.out.println();
        }
    }

    public void printInsertedNodesInOrder() {
        System.out.print("LinkedList\n[Head] => ");
        for (Node node = sentinelHead.getNextEntry(); node != sentinelTail; node = node.getNextEntry()) {
            System.out.print(String.format("[%s : %s] => ", node.getKey(), node.getValue()));
        }
        System.out.println("[Tail]");

    }

    public void printInsertedNodesInAscByKey() {
        System.out.println("BinaryTree Asc");
        printInAscOrder(root);
        System.out.println();
    }

    private void printInAscOrder(Node root) {
        if (root != null) {
            printInAscOrder(root.getLeftEntry());
            System.out.print(String.format("[%s : %s] ", root.getKey(), root.getValue()));
            printInAscOrder(root.getRightEntry());
        }
    }

    public void printInsertedNodesInDscByKey() {
        System.out.println("BinaryTree Dsc");
        printInDscOrder(root);
        System.out.println();
    }

    private void printInDscOrder(Node root) {
        if (root != null) {
            printInDscOrder(root.getRightEntry());
            System.out.print(String.format("[%s : %s] ", root.getKey(), root.getValue()));
            printInDscOrder(root.getLeftEntry());
        }
    }

    private Node connectEntry(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.getKey() > root.getKey()) {
            root.setRightEntry(connectEntry(root.getRightEntry(), newNode));
        } else {
            root.setLeftEntry(connectEntry(root.getLeftEntry(), newNode));
        }

        return root;
    }

    private int hashKey(int key) {
        return Math.abs(key) % tableSize;
    }
}