import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Item {
    int val;
    int idx;

    public Item(int val, int idx) {
        this.val = val;
        this.idx = idx; 
    }
}

class StockSpannerOptimal {
    private Stack<Item> stk;
    private int idx;

    public StockSpannerOptimal() {
        this.stk = new Stack<>();
        this.idx = -1;
    }
    
    public int next(int price) {
        idx++;
        int span;

        while (!stk.empty() && stk.peek().val <= price) {
            stk.pop();
        }

        if (stk.empty()) {
            span = idx + 1;

        } else {
            Item top = stk.peek();
            span = idx - top.idx;
        }

        stk.push(new Item(price, idx));
        return span;
    }
}

class StockSpannerBrute {
    private List<Integer> days;

    public StockSpannerBrute() {
        this.days = new ArrayList<>();
    }

    public int next(int price) {
        days.add(price);
        int span = 1;

        for (int i = days.size() - 2; i >= 0; i--) {
            if (days.get(i) <= price) {
                span++;
            } else {
                break;
            }
        }

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */