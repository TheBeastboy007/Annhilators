import java.util.*;

public class MinStepsToOne {
    static class State {
        int value, steps;
        State(int value, int steps) {
            this.value = value;
            this.steps = steps;
        }
    }

    public static int minStepsToOne(int n) {
        if (n == 1) return 0;

        Queue<State> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(new State(n, 0));
        visited.add(n);
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int num = current.value;
            int steps = current.steps;

            // If reached 1, return the steps taken
            if (num == 1) return steps;

            // Perform valid operations
            if (num % 2 == 0 && !visited.contains(num / 2)) {
                queue.offer(new State(num / 2, steps + 1));
                visited.add(num / 2);
            }
            if (num % 3 == 0 && !visited.contains(num / 3)) {
                queue.offer(new State(num / 3, steps + 1));
                visited.add(num / 3);
            }
            if (!String.valueOf(num).contains("5") && !visited.contains(num - 1) && num > 1) {
                queue.offer(new State(num - 1, steps + 1));
                visited.add(num - 1);
            }
        }
        
        return -1; // If reducing to 1 is not possible
    }

    public static void main(String[] args) {
        int n = 19; // Example input
        System.out.println("Minimum steps to reduce " + n + " to 1: " + minStepsToOne(n));
    }
}
