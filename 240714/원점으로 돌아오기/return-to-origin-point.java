import java.util.*;

public class Main {
    private static int count = 0;
    private static List<Point> points;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        points = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }
        scanner.close();

        visited = new boolean[N];
        
        // Start from the origin (0, 0)
        dfs(0, 0, 0);

        System.out.println(count);
    }

    private static void dfs(int x, int y, int visitedCount) {
        if (visitedCount == points.size()) {
            // Check if we can return to the origin
            if (x == 0 || y == 0) {
                count++;
            }
            return;
        }

        for (int i = 0; i < points.size(); i++) {
            if (!visited[i]) {
                Point p = points.get(i);
                if (x == p.x || y == p.y) {
                    visited[i] = true;
                    dfs(p.x, p.y, visitedCount + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}