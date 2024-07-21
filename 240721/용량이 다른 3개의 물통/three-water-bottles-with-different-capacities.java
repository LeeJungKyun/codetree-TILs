import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        long[] capacity = new long[3];
        long[] water = new long[3];
        
        for (int i = 0; i < 3; i++) {
            capacity[i] = scanner.nextLong();
            water[i] = scanner.nextLong();
        }
        scanner.close();

        // Perform 100 iterations of water transferring
        for (int i = 0; i < 100; i++) {
            transferWater(water, capacity, 0, 1); // 1 -> 2
            transferWater(water, capacity, 1, 2); // 2 -> 3
            transferWater(water, capacity, 2, 0); // 3 -> 1
        }
        
        System.out.println(water[1]);//0
        System.out.println(water[0]);//10
        System.out.println(water[2]);//2
        
    }

    private static void transferWater(long[] water, long[] capacity, int from, int to) {
        long transferAmount = Math.min(water[from], capacity[to] - water[to]);
        water[from] -= transferAmount;
        water[to] += transferAmount;
    }
}