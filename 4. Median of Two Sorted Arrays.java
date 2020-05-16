// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        int merge[] = mergeSortedArray(nums1, nums2, n, m);
        if(len % 2 == 0) {
            return (merge[len / 2] +  merge[len / 2 - 1]) / 2.;
        }
        return 1.* merge[len / 2];
    }
    
    int [] mergeSortedArray(int nums1[], int nums2[], int n, int m) {
        int len = n + m;
        int merge[] = new int[m + n];
        n--; m--;
        while(len > 0 ) {
            if(n < 0) merge[len - 1] = nums2[m--];
            else if(m < 0) merge[len - 1] = nums1[n--];
            else if(nums1[n] > nums2[m]) {
                merge[len - 1] = nums1[n--];
            } else {
                 merge[len - 1] = nums2[m--];
            }
            len--;
        }
        return merge;
    }
}


class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return y.compareTo(x);
            }
        });
        
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for(int x: nums1) {
            if(left.size() == 0 || left.peek() > x) {
                left.add(x);
            } else {
                right.add(x);
            }
            rebalanceQueues(left, right);
        }
        for(int x: nums2) {
            if(left.size() == 0 || left.peek() > x) {
                left.add(x);
            } else {
                right.add(x);
            }
            rebalanceQueues(left, right);
        }
        
        if(left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.;
        }
        return 1. * left.size() > right.size() ? left.peek() : right.peek();
    }
    
    void rebalanceQueues(PriorityQueue<Integer> x, PriorityQueue<Integer> y) {
        PriorityQueue<Integer> small = x.size() > y.size() ? y : x;
        PriorityQueue<Integer> large = x.size() > y.size() ? x : y;
        if(large.size() - small.size() == 2) {
            small.add(large.poll());
        }
    }
    
}
