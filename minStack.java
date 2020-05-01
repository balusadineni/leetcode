/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.
*/

class MinStack {
    
    Node head;
    
    class Node {
        int value;
        int minimum;
        Node next;
        
        Node() {}
        
        Node(int v, int m) 
        { 
            value = v;
            minimum = m;
            next = null; 
        } 
    }
    /** initialize your data structure here. */
    public MinStack() {
        head = new Node();
    }
    
    public void push(int x) {
        int min;
        
        if(head.next == null) {
            min = x;
        } else {
            min = Math.min(head.minimum, x);    
        }
        
        Node n = new Node(x, min);
        n.next = head;
        head = n;
    }
    
    public void pop() { 
        Node temp = head.next;
        head = temp;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.minimum;
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
