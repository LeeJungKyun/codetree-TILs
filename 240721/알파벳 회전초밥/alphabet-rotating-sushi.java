import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        scanner.close();

        // Function to calculate minimum repeats
        int result = minRepeats(A, B);
        System.out.println(result);
    }

    public static int minRepeats(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int count = 1; // Minimum one repeat is needed
        int indexA = 0; // Current index in string A
        int indexB = 0; // Current index in string B

        while (indexB < lenB) {
            if (A.charAt(indexA) == B.charAt(indexB)) {
                indexB++;
            }
            indexA++;

            // If we reach the end of A, we need another repeat
            if (indexA == lenA) {
                if (indexB < lenB) {
                    count++;
                    indexA = 0;
                }
            }
        }

        return count;
    }
}