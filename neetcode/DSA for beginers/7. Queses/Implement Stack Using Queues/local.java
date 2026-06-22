import java.util.*;

class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top()); // Expected: 2
        System.out.println(stack.pop()); // Expected: 2
        System.out.println(stack.empty()); // Expected: false
    }
}

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>(); 
    }

    public void push(int x) {
        queue.offer(x);
        
        int size = queue.size();

        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}