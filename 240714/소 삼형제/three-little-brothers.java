import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();  // 다음 줄로 넘어가기
        
        Map<String, Integer> combinationCount = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String[] cows = scanner.nextLine().split(" ");
            Arrays.sort(cows);  // 정렬하여 조합을 표준화
            String key = String.join(",", cows);  // 콤마로 구분된 문자열로 조합을 저장
            
            combinationCount.put(key, combinationCount.getOrDefault(key, 0) + 1);
        }
        
        scanner.close();
        
        // 최대 등장 횟수 찾기
        int maxCount = Collections.max(combinationCount.values());
        
        System.out.println(maxCount);
    }
}