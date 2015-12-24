/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
//用ArrayList实现
class MinStack {
    ArrayList<Integer> ms = new ArrayList<Integer>();
    int minIndex = 0;
    public void push(int x) {
        if(ms.isEmpty()) {
            ms.add(x);
            minIndex = 0;
        } else {
            ms.add(x);
            if(x < ms.get(minIndex)) {
                minIndex = ms.indexOf(x);
            }
        }
    }

    public void pop() {
        if(ms.size() == 1) {
            minIndex = -1;
            ms.remove(0);
            return;
        }
        if(minIndex == ms.size() - 1) {
            ms.remove(ms.size() - 1);
            minIndex = 0;
            for(int i = 0; i < ms.size(); i++) {
                if(ms.get(i) < ms.get(minIndex)) {
                   minIndex = i; 
                }
            }
        } else {
            ms.remove(ms.size() - 1);
        }
    }

    public int top() {
        return ms.get(ms.size() - 1);
    }

    public int getMin() {
        return ms.get(minIndex);
    }
}
