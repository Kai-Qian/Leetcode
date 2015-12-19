/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        int len1 = s1.size();
        for (int i = 0; i < len1; i++) {
            s2.push(s1.pop());
        }
        s2.pop();
        int len2 = s2.size();
        for (int i = 0; i < len2; i++) {
            s1.push(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        int len1 = s1.size();
        for (int i = 0; i < len1; i++) {//can not directly use s1.size() because the size will change with the push and pop operations
            System.out.println(i);
            s2.push(s1.pop());
        }
        int tmp = s2.peek();
        int len2 = s2.size();
        for (int i = 0; i < len2; i++) {
            s1.push(s2.pop());
        }
        return tmp;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (s1.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}