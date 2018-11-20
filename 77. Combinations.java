// https://leetcode.com/problems/combinations/

class Solution {
    
    List<List<Integer>> ans;
    
    public void combination(int pos, int taken, int n, int k, List<Integer> now) {
        if(k == taken) {
            ans.add(now);
            return;
        }
        if(pos > n) return;
        if(taken + 1 <= k) {
            List<Integer>tmp = new ArrayList<>(now);
            tmp.add(pos);
            combination(pos + 1, taken + 1, n, k, tmp);
        }
        combination(pos + 1, taken, n, k, now);
        
    }
    
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        combination(1, 0, n, k, new ArrayList<>());
        return ans;
    }
    
}
