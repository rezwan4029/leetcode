// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int inDegree[] = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dst = prerequisites[i][0];
            ++inDegree[dst];
            List<Integer> adjacents = graph.getOrDefault(src, new ArrayList<>());
            adjacents.add(dst);
            graph.put(src, adjacents);
        }
      
        // we can use stack as well, just ordering will differ
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        int courseTaken = 0;
        int courseOrder[] = new int[numCourses];
        while(!q.isEmpty()) {
            int u = q.poll();
            courseOrder[courseTaken++] = u;
            if(graph.get(u) != null) {
                for(int v: graph.get(u)) {
                    inDegree[v]--;
                    if(inDegree[v] == 0) {
                        q.add(v);
                    }
                }
            }
        }
        
        if(courseTaken != numCourses) {
            return new int[]{};
        }
        
        return courseOrder;
    }
}
