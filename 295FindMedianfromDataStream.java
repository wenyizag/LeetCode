    //Solution 1
    /** 思路大家都懂，一个min heap，一个max heap，min存储大数，max存储小数，但是有些细节问题
        第一是，addNum一定要先加在某个heap里面，在从此heap里面选出一个最小或者最大的加入另一个heap，举例：
        min:{4,5,6} max{3,2,1}，我固定先加在min里面，现加入8，则min{4，5，6，8}，然后把min的最小的放在max里，
        变成max{4,3,2,1}， min{5, 6, 8}
        第二是，要均衡两个heap的size，确保中位数一定在peek的位置。我们可以规定max的体积比min最多大1，
        如果两个size相等，返回 (min.peek + max.peek)/2.0，注意这里是2.0哦，不然自动给你转成整型损失精度
    */
    /** initialize your data structure here. */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue();
        //新学到的一个点，Collections.reverseOrder()，我之前自己重写的Comparator
        max = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        //一定要先加入某个heap，再把此heap的peek值poll出来给另一个heap。
        //当然可以不这么写，那就用if else判断num该加入大数还是小数，然后均衡size
        min.add(num);
        max.add(min.poll());
        //确保size均衡
        if(max.size() - min.size() > 1){
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if(min.size() == max.size()){
            return (min.peek() + max.peek())/2.0;
        }else 
            return max.peek();
    }