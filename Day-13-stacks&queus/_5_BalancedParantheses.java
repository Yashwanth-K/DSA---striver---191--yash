// package Day-13-stacks&queus;
import java.util.*;
public class _5_BalancedParantheses {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false; // if we encounter a closing bracket but stack is empty
                char ch = st.pop(); 
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty(); // if stack is empty, all parentheses are balanced
    }

 public static void main (String[] args) {
		
		String s="()[{}()]";
		if(isValid(s)==true)
		System.out.println("True");
		else
		System.out.println("False");
	}
}