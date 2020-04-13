package app.sentinellist;

import app.util.Runner;

/**
 * Main class to run Sentinel Linked List
 * 
 * @author Prateek Singh
 */
public class Main implements Runner {
    public void run() {
        SentinelLinkedList<Integer> sentinelLinkedList = new SentinelLinkedList<>();
        sentinelLinkedList.add(8);
        sentinelLinkedList.add(6);
        sentinelLinkedList.add(4);
        sentinelLinkedList.add(7);
        sentinelLinkedList.add(3);
        sentinelLinkedList.display();
        sentinelLinkedList.remove(8);
        sentinelLinkedList.remove(6);
        sentinelLinkedList.remove(4);
        sentinelLinkedList.display();
        sentinelLinkedList.add(25);
        sentinelLinkedList.add(30);
        sentinelLinkedList.display();
        System.out.println();

        SentinelLinkedList<String> sentinelLinkedListStr = new SentinelLinkedList<>();
        sentinelLinkedListStr.add("Ritchie");
        sentinelLinkedListStr.add("Ken");
        sentinelLinkedListStr.add("Alan");
        sentinelLinkedListStr.add("James");
        sentinelLinkedListStr.add("Rich");
        sentinelLinkedListStr.display();
        sentinelLinkedListStr.remove("Ritchie");
        sentinelLinkedListStr.remove("Ken");
        sentinelLinkedListStr.remove("Alan");
        sentinelLinkedListStr.display();
        sentinelLinkedListStr.add("Tim");
        sentinelLinkedListStr.add("Ryan");
        sentinelLinkedListStr.display();
        System.out.println();

        SentinelLinkedList<Customer> cSentinelLinkedList = new SentinelLinkedList<>();
        cSentinelLinkedList.add(new Customer(1, "Apple"));
        cSentinelLinkedList.add(new Customer(2, "Microsoft"));
        cSentinelLinkedList.add(new Customer(3, "IBM"));
        cSentinelLinkedList.add(new Customer(4, "Mozilla"));
        cSentinelLinkedList.add(new Customer(5, "Oracle"));
        cSentinelLinkedList.display();
        cSentinelLinkedList.remove(new Customer(2, "Microsoft"));
        cSentinelLinkedList.remove(new Customer(3, "IBM"));        
        cSentinelLinkedList.display();
    }   
}