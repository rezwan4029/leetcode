class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>(
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return freq.get(a).compareTo(freq.get(b));
                }
            }
        );
        
        // K Log N
        for(Integer v: freq.keySet()) {
            q.add(v);
            if(q.size() > k) {
                q.poll();
            }
        }
        
        int ans[] = new int[k];
        while(!q.isEmpty()) {
            ans[--k] = q.poll();
        }
        return ans;
    }
}
