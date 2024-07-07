import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.close();

        int maxCount = getMaxNoCarryNumbers(numbers);
        System.out.println(maxCount);
    }

    private static int getMaxNoCarryNumbers(int[] numbers) {
        int n = numbers.length;
        int maxCount = 0;

        for (int subset = 1; subset < (1 << n); subset++) {
            if (isNoCarrySubset(numbers, subset)) {
                maxCount = Math.max(maxCount, Integer.bitCount(subset));
            }
        }

        return maxCount;
    }

    private static boolean isNoCarrySubset(int[] numbers, int subset) {
        int sum = 0;
        int index = 0;

        while (subset > 0) {
            if ((subset & 1) == 1) {
                if (!canAddWithoutCarry(sum, numbers[index])) {
                    return false;
                }
                sum += numbers[index];
            }
            subset >>= 1;
            index++;
        }

        return true;
    }

    private static boolean canAddWithoutCarry(int a, int b) {
        while (a > 0 && b > 0) {
            if ((a % 10 + b % 10) >= 10) {
                return false;
            }
            a /= 10;
            b /= 10;
        }
        return true;
    }
}