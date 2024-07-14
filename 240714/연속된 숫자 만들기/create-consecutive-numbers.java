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
        
        int minMoves = 0;
        if (b - a == 1 && c - b == 1) {
            // 이미 연속된 위치에 있는 경우
            minMoves = 0;
        } else if (b - a <= 2 || c - b <= 2) {
            // 한 번의 이동으로 연속된 위치를 만들 수 있는 경우
            minMoves = 1;
        } else {
            // 두 번의 이동이 필요한 경우
            minMoves = 2;
        }
        
        int maxMoves = Math.max(b - a, c - b) - 1;
        
        System.out.println(minMoves);
        System.out.println(maxMoves);
        
        scanner.close();
    }
}