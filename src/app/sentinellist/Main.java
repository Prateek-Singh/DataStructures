package app.sentinellist;

import app.util.Runner;

/**
 * Main class to run Sentinel Linked List
 * 
 * @author Prateek Singh
 */
public class Main implements Runner {
    public void run() {
        SentinelLinkedList sentinelLinkedList = new SentinelLinkedList();
        sentinelLinkedList.add(8);
        sentinelLinkedList.add(6);
        sentinelLinkedList.add(4);
        sentinelLinkedList.add(7);
        sentinelLinkedList.add(3);
        sentinelLinkedList.display();
        sentinelLinkedList.remove(8);
        sentinelLinkedList.remove(6);
        sentinelLinkedList.remove(4);
        sentinelLinkedList.remove(7);
        sentinelLinkedList.remove(3);
        sentinelLinkedList.display();
        sentinelLinkedList.add(25);
        sentinelLinkedList.add(30);
        sentinelLinkedList.display();
        System.out.println();
    }   
}