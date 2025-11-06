// sort the stack using recurrsion and top ele shd be greater

import java.util.Stack;
public class _7_SortStack {
    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        sortStack(st);
        insertInSortedOrder(st, top);
    }
    private static void insertInSortedOrder(Stack<Integer> st, int element) {
        // Base case: If stack is empty or top element is less than or equal to the element
        if (st.isEmpty() || st.peek() <= element) {
            st.push(element);
            return;
        }
        // Remove the top element and recur
        int top = st.pop();
        insertInSortedOrder(st, element);
        // Put back the top element
        st.push(top);
    }
    
}