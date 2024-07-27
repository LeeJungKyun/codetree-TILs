import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int a = 1;  // 첫 번째 항
        int b = n;  // 두 번째 항
        
        System.out.print(a + " " + b + " ");
        
        while (true) {
            int next = a + b;  // 전전항과 전항을 더한 수
            if (next > 999) {
                System.out.print(next);
                break;  // 999를 넘기면 종료
            }
            System.out.print(next + " ");
            a = b;  // 전전항을 전항으로
            b = next;  // 전항을 다음 항으로
        }
    }
}