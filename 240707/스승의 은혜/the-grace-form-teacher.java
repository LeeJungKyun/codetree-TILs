import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long B = sc.nextLong();

        int[] P = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            S[i] = sc.nextInt();
        }

        sc.close();

        System.out.println(maxGifts(N, B, P, S));
    }

    private static int maxGifts(int N, long B, int[] P, int[] S) {
        int maxGifts = 0;
        
        for (int i = 0; i < N; i++) {
            long[] costs = new long[N];
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    costs[j] = (P[j] / 2) + S[j];
                } else {
                    costs[j] = P[j] + S[j];
                }
            }

            Arrays.sort(costs);

            long totalCost = 0;
            int count = 0;
            for (long cost : costs) {
                if (totalCost + cost <= B) {
                    totalCost += cost;
                    count++;
                } else {
                    break;
                }
            }

            maxGifts = Math.max(maxGifts, count);
        }

        return maxGifts;
    }
}