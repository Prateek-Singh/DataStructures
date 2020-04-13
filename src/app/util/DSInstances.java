package app.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Enum that represents various Data Structures that can be run
 * 
 * @author Prateek Singh
 */
public enum DSInstances {

    SUPER_STRUCTURE(1, "Super Structure(HashTable + LinkedList + Binary Search Tree)", new app.superstructure.Main()),
    SENTINEL_LINKED_LIST(2, "Sentinel Linked List", new app.sentinellist.Main()),
    BINARY_SEARCH_TREE(3, "Binary Search Tree", new app.binarysearchtree.Main());

    private int id;
    private String name;
    private Runner dsInstance;

    private DSInstances(int id, String name, Runner dsInstance) {
        this.id = id;
        this.name = name;
        this.dsInstance = dsInstance;
    }

    public static List<DSInstances> getDSInstanceList() {
        return Arrays.asList(SUPER_STRUCTURE, SENTINEL_LINKED_LIST, BINARY_SEARCH_TREE);
    }
    
    public static Optional<DSInstances> getDsInstanceById(int id) {
        return Optional.ofNullable(getDSInstanceList()
                                    .stream()
                                    .filter(cls -> cls.id == id)
                                    .findFirst()
                                    .orElse(null));       
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Runner getDsInstance() {
        return dsInstance;
    }
}