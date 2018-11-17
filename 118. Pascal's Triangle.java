// https://leetcode.com/problems/pascals-triangle/

class Solution {

    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(numRows == 0) {
            return res;
        }
        
        res.add(Arrays.asList(1));
        
        if(numRows == 1) {
            return res;
        }
        
        res.add(Arrays.asList(1,1));
        
        if(numRows == 2) {
            return res;
        }
        
        for(int i = 2; i < numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for(int j = 0 ; j < i + 1; j++) cur.add(0);
            cur.set(0, 1);
            cur.set(i, 1);
            for(int j = 1; j < i ; j++) {
                cur.set(j, res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            res.add(cur);
        }
        return res;
    }
}
