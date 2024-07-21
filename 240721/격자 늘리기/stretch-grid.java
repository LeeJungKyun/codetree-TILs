import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();  // 버퍼 비우기

        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }
        scanner.close();

        // 격자를 K배 확장하여 출력
        for (int i = 0; i < N; i++) {
            for (int ki = 0; ki < K; ki++) {
                for (int j = 0; j < M; j++) {
                    for (int kj = 0; kj < K; kj++) {
                        System.out.print(grid[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
}