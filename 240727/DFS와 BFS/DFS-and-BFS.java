import java.util.*;

public class Main {
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 정점의 개수
        int m = scanner.nextInt(); // 간선의 개수
        int start = scanner.nextInt(); // 시작 정점 번호

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        sb = new StringBuilder();
        dfs(start);
        System.out.println(sb.toString().trim());

        Arrays.fill(visited, false);
        sb = new StringBuilder();
        bfs(start);
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");
            for (int neighbor : graph.get(v)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}