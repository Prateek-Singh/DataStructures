package app.binarysearchtree;

import app.util.Runner;

/**
 * Main class to run Binary Search Tree
 * 
 * @author Prateek Singh
 */
public class Main implements Runner{

    @Override
    public void run() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(8);
        binarySearchTree.add(25);
        binarySearchTree.add(2);
        binarySearchTree.add(34);
        binarySearchTree.add(17);
        binarySearchTree.display(false);
        binarySearchTree.display(true);
        binarySearchTree.remove(25);
        binarySearchTree.remove(2);
        binarySearchTree.display(false);
        binarySearchTree.display(true);
    }

}