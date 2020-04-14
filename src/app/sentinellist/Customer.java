package app.sentinellist;

//In order to remove it the type needs to implement Comparable
public class Customer implements Comparable<Customer> {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Customer otheCustomer) {        
        return id - otheCustomer.id;
    }
        
}