/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

import java.util.*;

public class MinStack {
    private ArrayList<Integer> storage;
    private PriorityQueue<Integer> minQueue;
    /** initialize your data structure here. */
    public MinStack() {
        storage = new ArrayList<Integer>();
        minQueue = new PriorityQueue<>();
    }

    public void push(int x) {
        storage.add(x);
        minQueue.add(x);
    }

    public void pop() {
        int toRemove = storage.get(storage.size()-1);
        minQueue.remove(toRemove);
        storage.remove(storage.size()-1);
    }

    public int top() {
        return storage.get(storage.size()-1);
    }

    public int getMin() {
        return minQueue.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
