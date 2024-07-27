import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[][] triangle = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            triangle[i][0] = 2; // 각 행의 시작 열은 2
            triangle[i][i] = 2; // 각 행의 끝 열은 2
            
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}