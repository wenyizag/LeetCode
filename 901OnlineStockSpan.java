//solution 1
class StockSpanner {
    public int[] stock;
    public int[] span;
    public int index;
    public StockSpanner() {
        stock = new int[10000];
        span = new int[10000];
        index = 0;
    }
    
    public int next(int price) {
        //calculate the span
        int pre = index-1;
        span[index] = 1;
        stock[index] = price;
        while(pre >= 0 && stock[pre] <= price){
            span[index] += span[pre];
            pre -= span[pre];
        }
        
        //increase the index
        index++;
        return span[index-1];
    }
}

//solution 2
    class Item{
        public int price;
        public int span;
        public Item(int price, int span){
            this.price = price;
            this.span = span;
        }
    }
    Stack<Item> s = new Stack<>();
    
    public int next(int price) {
        int span = 1;
        while(!s.isEmpty() && s.peek().price <= price){
            span += s.pop().span;
        }
        s.push(new Item(price, span));
        return s.peek().span;
    }