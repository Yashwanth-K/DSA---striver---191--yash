import java.util.Deque;
public class _4_QueueUsingStack {
    private Deque<Integer> input;
    private Deque<Integer> output;

    // Constructor
    public _4_QueueUsingStack() {
        input = new java.util.ArrayDeque<>();
        output = new java.util.ArrayDeque<>();
    }
    // Enqueue operation: O(1) time
    public void enqueue(int value){
        input.push(value);
    }
    // Dequeue operation: Amortized O(1) time
    public int dequeue(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        if(output.isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        return output.pop();
    }
    public int peek(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        if(output.isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        return output.peek();
    }

}
