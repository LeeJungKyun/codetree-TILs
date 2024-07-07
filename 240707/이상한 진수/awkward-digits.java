import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();

        long N = findN(a, b);
        System.out.println(N);
    }

    private static long findN(String a, String b) {
        Set<Long> possibleNFromA = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            char[] modifiedA = a.toCharArray();
            modifiedA[i] = (a.charAt(i) == '0') ? '1' : '0';
            possibleNFromA.add(Long.parseLong(new String(modifiedA), 2));
        }

        for (int i = 0; i < b.length(); i++) {
            char[] modifiedB = b.toCharArray();
            for (char c : new char[] {'0', '1', '2'}) {
                if (b.charAt(i) != c) {
                    modifiedB[i] = c;
                    long candidateN = Long.parseLong(new String(modifiedB), 3);
                    if (possibleNFromA.contains(candidateN)) {
                        return candidateN;
                    }
                }
            }
        }

        return -1;
    }
}