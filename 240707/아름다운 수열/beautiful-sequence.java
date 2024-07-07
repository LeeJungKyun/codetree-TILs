import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] B = new int[M];

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        sc.close();

        List<Integer> results = findBeautifulSubsequences(A, B);
        System.out.println(results.size());
        for (int index : results) {
            System.out.println(index);
        }
    }

    private static List<Integer> findBeautifulSubsequences(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        int N = A.length;
        int M = B.length;

        Arrays.sort(B);

        for (int i = 0; i <= N - M; i++) {
            int[] subArray = Arrays.copyOfRange(A, i, i + M);
            Arrays.sort(subArray);

            if (isBeautiful(subArray, B)) {
                result.add(i + 1);
            }
        }

        return result;
    }

    private static boolean isBeautiful(int[] subArray, int[] B) {
        int diff = subArray[0] - B[0];
        for (int i = 1; i < B.length; i++) {
            if (subArray[i] - B[i] != diff) {
                return false;
            }
        }
        return true;
    }
}