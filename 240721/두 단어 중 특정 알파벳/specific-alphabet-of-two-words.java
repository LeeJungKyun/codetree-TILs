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

        // 가능한 모든 조합을 생성하고 각 조합에 대해 알파벳 등장 횟수를 계산
        generateCombinations(wordPairs, N, maxCounts);

        // 결과 출력
        for (int count : maxCounts) {
            System.out.println(count);
        }
    }

    // 가능한 모든 조합을 생성하여 각 알파벳의 최대 등장 횟수를 계산하는 함수
    private static void generateCombinations(String[][] wordPairs, int N, int[] maxCounts) {
        int[] currentCounts = new int[26];
        generateCombinationsUtil(wordPairs, N, 0, currentCounts, maxCounts);
    }

    // 재귀적으로 조합을 생성하여 알파벳 등장 횟수를 계산하는 함수
    private static void generateCombinationsUtil(String[][] wordPairs, int N, int index, int[] currentCounts, int[] maxCounts) {
        if (index == N) {
            // 현재 조합의 알파벳 등장 횟수를 최대 등장 횟수와 비교하여 갱신
            for (int i = 0; i < 26; i++) {
                maxCounts[i] = Math.max(maxCounts[i], currentCounts[i]);
            }
            return;
        }

        // 첫 번째 단어를 선택하는 경우
        addWordCounts(wordPairs[index][0], currentCounts);
        generateCombinationsUtil(wordPairs, N, index + 1, currentCounts, maxCounts);
        subtractWordCounts(wordPairs[index][0], currentCounts);

        // 두 번째 단어를 선택하는 경우
        addWordCounts(wordPairs[index][1], currentCounts);
        generateCombinationsUtil(wordPairs, N, index + 1, currentCounts, maxCounts);
        subtractWordCounts(wordPairs[index][1], currentCounts);
    }

    // 단어의 알파벳 등장 횟수를 currentCounts 배열에 추가하는 함수
    private static void addWordCounts(String word, int[] counts) {
        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
    }

    // 단어의 알파벳 등장 횟수를 currentCounts 배열에서 빼는 함수
    private static void subtractWordCounts(String word, int[] counts) {
        for (char c : word.toCharArray()) {
            counts[c - 'a']--;
        }
    }
}