import java.util.*;

public class Main {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int N = scanner.nextInt();
        int[] desiredSalaries = new int[N];
        int[] maxSalaries = new int[N];
        
        for (int i = 0; i < N; i++) {
            desiredSalaries[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            maxSalaries[i] = scanner.nextInt();
        }
        scanner.close();

        // Calculate number of valid assignments
        calculateAssignments(N, desiredSalaries, maxSalaries);
        System.out.println(count);
    }

    private static void calculateAssignments(int N, int[] desiredSalaries, int[] maxSalaries) {
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        backtrack(0, N, desiredSalaries, maxSalaries, visited);
    }

    private static void backtrack(int devIndex, int N, int[] desiredSalaries, int[] maxSalaries, boolean[] visited) {
        if (devIndex == N) {
            count++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i] && desiredSalaries[devIndex] <= maxSalaries[i]) {
                visited[i] = true;
                backtrack(devIndex + 1, N, desiredSalaries, maxSalaries, visited);
                visited[i] = false;
            }
        }
    }
}