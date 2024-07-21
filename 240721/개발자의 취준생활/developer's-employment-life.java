import java.util.*;

public class Main {

    private static int[][] memo;
    private static int count;

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

        // Initialize memoization table
        memo = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);
        }

        // Calculate number of valid assignments
        count = calculateAssignments(0, N, desiredSalaries, maxSalaries, 0);
        System.out.println(count);
    }

    private static int calculateAssignments(int devIndex, int N, int[] desiredSalaries, int[] maxSalaries, int mask) {
        if (devIndex == N) {
            return 1;
        }

        if (memo[devIndex][mask] != -1) {
            return memo[devIndex][mask];
        }

        int totalWays = 0;

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0 && desiredSalaries[devIndex] <= maxSalaries[i]) {
                totalWays += calculateAssignments(devIndex + 1, N, desiredSalaries, maxSalaries, mask | (1 << i));
            }
        }

        memo[devIndex][mask] = totalWays;
        return totalWays;
    }
}