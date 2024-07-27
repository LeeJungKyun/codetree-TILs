import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        int[] result = new int[x];
        findCombinations(result, x, y, 0, 1);
    }
    
    public static void findCombinations(int[] result, int x, int y, int index, int start) {
        if (index == x) {
            if (sum(result) == y) {
                for (int num : result) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }
        
        for (int i = start; i <= 6; i++) {
            result[index] = i;
            findCombinations(result, x, y, index + 1, 1);
        }
    }
    
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }
}