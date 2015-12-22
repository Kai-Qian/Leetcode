/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/
class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int len1 = queue1.size();
        for(int i = 0; i < len1; i++) {
            queue2.offer(queue1.poll());
        }
        for(int i = 0; i < len1 - 1; i++) {
            queue1.offer(queue2.poll());
        }
        queue2.clear();
    }

    // Get the top element.
    public int top() {
        int len1 = queue1.size();
        int tmp = 0;
        for(int i = 0; i < len1; i++) {
            tmp = queue1.poll();
            queue2.offer(tmp);
        }
        for(int i = 0; i < len1; i++) {
            queue1.offer(queue2.poll());
        }
        return tmp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue1.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}