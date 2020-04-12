package app;

import superstructure.SuperContainer;

/**
 * Main class to run SuperContainer
 * 
 * @author Prateek Singh
 */

public class App {
    public static void main(String[] args) throws Exception {
        // Create SuperContainer and populate with nodes
        SuperContainer supercontainer = new SuperContainer(10);

        supercontainer.put(1, "Ritchie"); // collission with 11 and 81
        supercontainer.put(2, "Ken");
        supercontainer.put(11, "Bjarne"); // collission with 1 and 81
        supercontainer.put(9, "Tim");
        supercontainer.put(81, "Rich"); // collission with 1 and 11
        supercontainer.put(44, "James"); // collission with 64
        supercontainer.put(64, "Joe"); // collission with 44

        // Print the SuperContainer as HashTable
        supercontainer.printHashTable();

        // Print the SuperContainer as LinkedList
        supercontainer.printInsertedNodesInOrder();

        // Print the SuperContainer as Binary Search Tree in Ascending Order
        supercontainer.printInsertedNodesInAscByKey();

        // Print the SuperContainer as Binary Search Tree in Descending Order
        supercontainer.printInsertedNodesInDscByKey();

        // Remove few nodes
        supercontainer.remove(81);
        supercontainer.remove(11);

        System.out.println("\nPrint after removing few keys");

        // Print the SuperContainer as HashTable
        supercontainer.printHashTable();

        // Print the SuperContainer as LinkedList
        supercontainer.printInsertedNodesInOrder();

        // Print the SuperContainer as Binary Search Tree in Ascending Order
        supercontainer.printInsertedNodesInAscByKey();

        // Print the SuperContainer as Binary Search Tree in Descending Order
        supercontainer.printInsertedNodesInDscByKey();
    }
}