import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int result;
    static boolean[][] visited;
    static int[] dx = {1, -1, -1, 1};
    static int[] dy = {1, 1, -1, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int w = 1; w < n; w++) {
                    for (int h = 1; h < n; h++) {
                        result = Math.max(result, dfs(i, j, w, h));
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static int dfs(int x, int y, int w, int h) {
        int[] size = {w, h, w, h};
        int total = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < size[i]; j++) {
                x += dx[i];
                y += dy[i];

                if (x < 0 || x >= n || y < 0 || y >= n) {
                    return 0;
                }
                total += arr[x][y];
            }
        }
        return total;
    }
}
