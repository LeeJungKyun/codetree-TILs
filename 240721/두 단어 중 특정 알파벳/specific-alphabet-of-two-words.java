import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        String[][] wordPairs = new String[N][2];
        for (int i = 0; i < N; i++) {
            wordPairs[i][0] = scanner.next();
            wordPairs[i][1] = scanner.next();
        }
        scanner.close();

        // 각 알파벳의 최대 등장 횟수를 저장할 배열
        int[] maxCounts = new int[26];

        // 각 단어 쌍에 대해 최대 등장 횟수를 계산
        for (int i = 0; i < N; i++) {
            int[] countA = getCounts(wordPairs[i][0]);
            int[] countB = getCounts(wordPairs[i][1]);

            for (int j = 0; j < 26; j++) {
                maxCounts[j] += Math.max(countA[j], countB[j]);
            }
        }

        // 결과 출력
        for (int count : maxCounts) {
            System.out.println(count);
        }
    }

    // 단어의 알파벳 등장 횟수를 계산하는 함수
    private static int[] getCounts(String word) {
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
        return counts;
    }
}