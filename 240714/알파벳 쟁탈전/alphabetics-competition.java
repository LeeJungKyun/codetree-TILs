import java.util.*;

public class Main {
    private static int N;
    private static int K;
    private static List<Condition> conditions;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        K = scanner.nextInt();
        conditions = new ArrayList<>();
        
        for (int i = 0; i < K; i++) {
            char c = scanner.next().charAt(0);
            int a = scanner.nextInt() - 1; // 인덱스를 0부터 시작하도록 조정
            int b = scanner.nextInt() - 1; // 인덱스를 0부터 시작하도록 조정
            conditions.add(new Condition(c, a, b));
        }
        
        scanner.close();
        
        char[] students = new char[N];
        assignCharacters(students, 0);
        
        System.out.println(count);
    }
    
    private static void assignCharacters(char[] students, int index) {
        if (index == N) {
            if (isValid(students)) {
                count++;
            }
            return;
        }
        
        for (char ch : new char[] {'A', 'B', 'C'}) {
            students[index] = ch;
            assignCharacters(students, index + 1);
        }
    }
    
    private static boolean isValid(char[] students) {
        for (Condition condition : conditions) {
            if (condition.type == 'S' && students[condition.a] != students[condition.b]) {
                return false;
            }
            if (condition.type == 'D' && students[condition.a] == students[condition.b]) {
                return false;
            }
        }
        return true;
    }
    
    private static class Condition {
        char type;
        int a, b;
        
        Condition(char type, int a, int b) {
            this.type = type;
            this.a = a;
            this.b = b;
        }
    }
}