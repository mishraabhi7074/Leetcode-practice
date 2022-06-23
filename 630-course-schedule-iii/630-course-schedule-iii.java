class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0, total =0; i<courses.length ; i++) {
            pq.add(courses[i][0]);
            if(total + courses[i][0] > courses[i][1]) {
                total -= pq.peek();
                pq.remove();
            }
            total += courses[i][0];
        }
        return pq.size();
    }
}