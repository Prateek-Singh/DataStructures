package app.util;

import java.util.Arrays;
import java.util.List;

/**
 * Enum that represents various Data Structures that can be run
 * 
 * @author Prateek Singh
 */
public enum DSInstances {

    SUPER_STRUCTURE(1, "Super Structure(HashTable + LinkedList + Binary Search Tree)", app.superstructure.Main.class),
    SENTINEL_LINKED_LIST(2, "Sentinel Linked List", app.sentinellist.Main.class),
    BINARY_SEARCH_TREE(3, "Binary Search Tree", app.binarysearchtree.Main.class);

    private int id;
    private String name;
    private Class className;

    private DSInstances(int id, String name, Class className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public static List<DSInstances> getList() {
        return Arrays.asList(SUPER_STRUCTURE, SENTINEL_LINKED_LIST, BINARY_SEARCH_TREE);
    }
    
    public static Class getClass(int id) {
        return getList().stream().filter(cls -> cls.id == id).findFirst().get().className;       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }    
}