import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] blocks = new int[N + 1];

        for (int i = 0; i < K; i++) {
            int Ai = sc.nextInt();
            int Bi = sc.nextInt();
            blocks[Ai - 1] += 1;
            if (Bi < N) {
                blocks[Bi] -= 1;
            }
        }

        sc.close();

        int[] finalBlocks = new int[N];
        finalBlocks[0] = blocks[0];
        for (int i = 1; i < N; i++) {
            finalBlocks[i] = finalBlocks[i - 1] + blocks[i];
        }

        Arrays.sort(finalBlocks);

        int middleValue = finalBlocks[N / 2];

        System.out.println(middleValue);
    }
}