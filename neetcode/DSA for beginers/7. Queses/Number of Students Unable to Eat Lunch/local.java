import java.util.*;

class Main {
    public static void main(String[] args) {
        // int[] students = { 1,1,1,0,0,1 };
        // int[] sandwiches = { 1,0,0,0,1,1 };
        int[] students = { 1, 1, 0, 0 };
        int[] sandwiches = { 0, 1, 0, 1 };

        Solution solution = new Solution();
        int result = solution.countStudents(students, sandwiches);

        System.out.println(result); // Expected: 0
    }
}

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue_studens = new LinkedList<>();
        Queue<Integer> queue_sandwiches = new LinkedList<>();
        int rejected = 0;

        for (int student : students) {
            queue_studens.offer(student);
        }

        for (int sandwich : sandwiches)
            queue_sandwiches.offer(sandwich);

        while (!queue_studens.isEmpty() && rejected < queue_studens.size()) {
            if (queue_sandwiches.peek().equals(queue_studens.peek())) {
                queue_studens.poll();
                queue_sandwiches.poll();
                rejected = 0;
            }
            else {
                queue_studens.offer(queue_studens.poll());
                rejected++;
            }
        }

        return queue_studens.size();
    }
}