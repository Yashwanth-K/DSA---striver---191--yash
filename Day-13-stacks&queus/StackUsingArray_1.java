import java.util.ArrayList;

public class StackUsingArray_1 {
    private ArrayList<Integer> list;

    // Constructor
    public StackUsingArray_1() {
        list = new ArrayList<>()  
    }

    // Stack-like operations
    public void push(Integer element) {
        list.add(element); // Adds to the end (like Python's append)
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.remove(list.size() - 1); // Removes and returns last element
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(list.size() - 1); // Returns last element without removing
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}