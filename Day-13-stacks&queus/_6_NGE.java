import java.util.*;

public class _6_NGE {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];      // result array to store next greater elements
        Stack<Integer> st = new Stack<>(); // stack to keep "candidates" for next greater

        // Traverse the array in reverse, but twice (2n - 1 → 0)
        // This simulates circular behavior.
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Remove all elements from stack that are <= current element
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            // Only fill result when we are in the first pass (i < n)
            // Second pass is only to handle circular cases
            if (i < n) {
                if (!st.isEmpty()) {
                    nge[i] = st.peek(); // top of stack is the next greater element
                } else {
                    nge[i] = -1; // no greater element found
                }
            }

            // Push current element into stack
            st.push(nums[i % n]);
        }
        return nge;
    }

    public static void main(String args[]) {
        int arr[] = {5, 7, 1, 2, 6, 0};

        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
