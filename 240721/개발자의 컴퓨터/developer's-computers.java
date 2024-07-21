import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int N = scanner.nextInt();
        int[] start = new int[N];
        int[] end = new int[N];
        int[] computers = new int[N];
        
        for (int i = 0; i < N; i++) {
            start[i] = scanner.nextInt();
            end[i] = scanner.nextInt();
            computers[i] = scanner.nextInt();
        }
        scanner.close();

        // Use a TreeMap to store the changes in the number of required computers
        TreeMap<Integer, Integer> events = new TreeMap<>();
        
        for (int i = 0; i < N; i++) {
            events.put(start[i], events.getOrDefault(start[i], 0) + computers[i]);
            events.put(end[i], events.getOrDefault(end[i], 0) - computers[i]);
        }

        int currentComputers = 0;
        int maxComputers = 0;

        // Traverse the events in sorted order to calculate the peak requirement
        for (int change : events.values()) {
            currentComputers += change;
            if (currentComputers > maxComputers) {
                maxComputers = currentComputers;
            }
        }

        // Print the result
        System.out.println(maxComputers);
    }
}