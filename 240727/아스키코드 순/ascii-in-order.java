import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        String minString = null;
        
        for (int i = 0; i < n; i++) {
            String currentString = scanner.nextLine();
            if (minString == null || currentString.compareTo(minString) < 0) {
                minString = currentString;
            }
        }
        
        System.out.println(minString);
    }
}