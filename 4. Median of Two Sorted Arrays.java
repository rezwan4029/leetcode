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
