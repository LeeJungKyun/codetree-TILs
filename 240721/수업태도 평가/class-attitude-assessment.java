import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 학생들의 초기 점수 설정
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Bessie", 0);
        scores.put("Elsie", 0);
        scores.put("Daisy", 0);
        scores.put("Gertie", 0);
        scores.put("Annabelle", 0);
        scores.put("Maggie", 0);
        scores.put("Henrietta", 0);

        // 점수 입력
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            scores.put(name, scores.get(name) + score);
        }
        scanner.close();

        // 점수를 리스트에 담아 정렬
        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(scores.entrySet());
        scoreList.sort(Map.Entry.comparingByValue());

        // 두 번째로 낮은 점수 찾기
        int minScore = scoreList.get(0).getValue();
        int secondMinScore = Integer.MAX_VALUE;
        String secondMinName = "";

        for (Map.Entry<String, Integer> entry : scoreList) {
            if (entry.getValue() > minScore) {
                if (entry.getValue() < secondMinScore) {
                    secondMinScore = entry.getValue();
                    secondMinName = entry.getKey();
                } else if (entry.getValue() == secondMinScore) {
                    secondMinName = "Tie";
                }
            }
        }

        // 출력
        if (secondMinName.isEmpty() || secondMinName.equals("Tie")) {
            System.out.println("Tie");
        } else {
            System.out.println(secondMinName);
        }
    }
}