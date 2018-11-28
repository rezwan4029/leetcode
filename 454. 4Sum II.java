// https://leetcode.com/problems/4sum-ii/

class Solution {
    
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        HashMap<Integer, Integer> s1 = new HashMap<>();
        HashMap<Integer, Integer> s2 = new HashMap<>();
        
        for(int i = 0 ; i < A.length; i++)
            for(int j = 0; j < B.length; j++) {
                int x = A[i] + B[j];
                s1.put(x, s1.getOrDefault(x, 0) + 1);
            }
        
        for(int i = 0 ; i < C.length; i++)
            for(int j = 0; j < D.length; j++) {
                int x = C[i] + D[j];
                s2.put(x, s2.getOrDefault(x, 0) + 1);
            }
        
        int ans = 0;
        
        for(Map.Entry<Integer, Integer> entry : s2.entrySet()) {
            ans += s1.getOrDefault(-entry.getKey(), 0) * entry.getValue() ;
        }
        
        return ans;  
    }
    
}
