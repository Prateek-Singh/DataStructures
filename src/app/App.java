package app;

import superstructure.Container;

public class App {
    public static void main(String[] args) throws Exception {
        Container container = new Container(10);
        container.put(1, "Ritchie");
        container.put(2, "Ken");
        container.put(11, "Bjarne");
        container.put(9, "Tim");
        container.put(81, "Rich");
        container.put(44, "James");
        container.put(64, "Joe");
        container.printHashTable();
        container.printInsertedNodesInOrder();
        container.printInsertedNodesInAscByKey();
        container.printInsertedNodesInDscByKey();
    }
}