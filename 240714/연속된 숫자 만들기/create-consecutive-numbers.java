import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] positions = new int[3];
        for (int i = 0; i < 3; i++) {
            positions[i] = scanner.nextInt();
        }
        
        Arrays.sort(positions);
        
        int a = positions[0];
        int b = positions[1];
        int c = positions[2];
        
        // 최소 이동 횟수 계산
        int minMoves = 0;
        if (b - a == 1 && c - b == 1) {
            minMoves = 0;
        } else if (b - a <= 2 || c - b <= 2) {
            minMoves = 1;
        } else {
            minMoves = 2;
        }
        
        // 최대 이동 횟수 계산
        int maxMoves = (c - b - 1) + (b - a - 1);
        
        System.out.println(minMoves);
        System.out.println(maxMoves);
        
        scanner.close();
    }
}