class Node {
    int val;
    Node next;
    int min;
    Node(int _v, int _m) {
        val = _v;
        min = _m;
    }
}

class MinStack {
    
    Node u;

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if(u == null) {
            u = new Node(x, x);
        } else {
            Node v = new Node(x, Math.min(x, u.min));
            v.next = u;
            u = v;
        }
    }
    
    public void pop() {
        if(u == null) return;
        u = u.next;
    }
    
    public int top() {
        return u.val;
    }
    
    public int getMin() {
        return u.min;
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
