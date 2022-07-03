class MyStack {
    static Queue<Integer> q1;
    static Queue<Integer> q2;
    int front=-1;
    public MyStack() {
        q1 = new ArrayDeque<Integer>();
        q2 = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
            front=x;
            q1.add(x);
        
    }
    
    public int pop() {
        while(q1.size()>1){
            front=q1.poll();
            q2.add(front);
        }
        int res=q1.poll();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return res;
    }
    
    public int top() {
      
        return front;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */