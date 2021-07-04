// https://leetcode.com/problems/course-schedule-iii/

// Time complexity : O(nlogn)
// Space complexity : O(n)

class Solution {
    public int scheduleCourse(int[][] courses) {
        List<Course> items = new ArrayList<>();
        for(int i = 0; i < courses.length; i++) {
            items.add(new Course(courses[i]));
        }
        
        Collections.sort(items, new Comparator<>(){
            public int compare(Course a, Course b) {
                return a.endTime.compareTo(b.endTime);
            }
        });
        
        PriorityQueue<Course> q = new PriorityQueue<>(new Comparator<>(){
            public int compare(Course a, Course b) {
                return b.duration.compareTo(a.duration);
            }
        });
        
        int currentTime = 0;
        
        for(Course course: items) {
            if(currentTime + course.duration <= course.endTime) {
                q.add(course);
                currentTime += course.duration;
            } else if(!q.isEmpty() && q.peek().duration > course.duration) {
                currentTime -= q.poll().duration; // Remove the previous task
                currentTime += course.duration; // Do this task
                q.add(course);
            }
        }
        
        return q.size();
    }
    
    class Course {
        Integer duration;
        Integer endTime;
        Course(int a[]) {
            this.duration = a[0];
            this.endTime = a[1];
        }
        
        public String toString() {
            return String.format("(duration = %d, endAt= %d)", duration, endTime);
        }
        
    }
}
