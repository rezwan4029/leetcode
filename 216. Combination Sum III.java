// https://leetcode.com/problems/combination-sum-iii

class Solution {
    
    // Soution - 1
    List<List<Integer>> ans = new ArrayList<>();
    void solve(int cur, int taken, int sum, int k, int n, List<Integer> list) {
        
        if(cur == 10) {
            if(sum == n && taken == k) ans.add(new ArrayList<>(list));
            return;
        }
        if(taken == k) {
            if(sum == n) ans.add(new ArrayList<>(list));
            return;
        }
        if( taken + 1 <= k) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(cur);
            solve(cur + 1, taken + 1, sum + cur, k, n, temp);
        }
        solve(cur + 1, taken, sum, k, n, list);
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(1, 0, 0, k, n, new ArrayList<>());
        return ans;
    }
    
    // Solution - 2
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int mask = 1 ; mask < (1 << 9) ; mask++) {
            int sum = 0, cnt = 0;
            List<Integer> cur = new ArrayList<>();
            for(int i = 0 ; i < 9; i++) {
                if((mask & 1 << i) != 0) {
                    cnt++;
                    if(cnt > k || sum > n) break;
                    sum += (i+1);
                    cur.add(i+1);
                }
            }
            if(cnt == k && sum == n) ans.add(cur);
        }
        return ans;
    }
    
}

