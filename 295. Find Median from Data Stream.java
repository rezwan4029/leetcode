// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {
    
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
        // use maxheap on left side just to know to peek item but all left elements would be lower than right side elements
        this.left = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return -1 * x.compareTo(y);
            }
        });
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == 0 || left.peek() > num) {
            left.add(num);
        } else {
            right.add(num);
        }
        rebalanceHeaps(left, right);
    }
    
    private void rebalanceHeaps(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        PriorityQueue<Integer> small = left.size() > right.size() ? right : left;
        PriorityQueue<Integer> large = left.size() > right.size() ? left : right;
        
        if(large.size() - small.size() == 2) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        PriorityQueue<Integer> small = left.size() > right.size() ? right : left;
        PriorityQueue<Integer> large = left.size() > right.size() ? left : right;
        // if we have equal partition use max of left side and min of right side to get median
        if(small.size() == large.size()) {
            return 1.* (small.peek() + large.peek()) / 2.;
        } else {
            return large.peek();
        }
    }
}
