// next smaller element to right
import java.util.ArrayDeque;
import java.util.Deque;
public class _1_NextSmallerEle {
    public static int[] NSE(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            result[i] = st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return result;
    }
}