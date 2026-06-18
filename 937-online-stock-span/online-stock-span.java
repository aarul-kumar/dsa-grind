class StockSpanner {
    Stack<Integer> s;
    Stack<Integer> span;

    public StockSpanner() {
        s = new Stack<>();
        span = new Stack<>();
    }
    
    public int next(int price) {
        if(s.isEmpty()) {
            s.push(price);
            span.push(1);
            return span.peek();
        } else {
            if(price<s.peek()) {
                s.push(price);
                span.push(1);
                return 1;
            } else {
                int currSpan = 1;
                while(!s.isEmpty() && price>=s.peek()) {
                    s.pop();
                    currSpan += span.pop();
                }
                s.push(price);
                span.push(currSpan);
                return currSpan;
            }
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */