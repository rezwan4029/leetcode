class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.freq < b.freq ? 1 : -1;
            }
        });
        
        count.forEach((x, y) -> {
            q.add(new Node(x, y));
        });
        
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty() && k > 0) {
            ans.add(q.poll().val);
            k--;
        }

        return ans;
    }
}

class Node {
    
    int val;
    int freq;
    
    Node(int _v, int _f) {
        this.val = _v;
        this.freq = _f;
    }
    
    public String toString() {
        return String.format("(val = %d, count = %d)", val, freq);
    }
}
