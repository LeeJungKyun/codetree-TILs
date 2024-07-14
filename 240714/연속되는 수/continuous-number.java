import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        System.out.println(findMaxConsecutiveAfterRemoval(numbers));
    }
    
    private static int findMaxConsecutiveAfterRemoval(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // 각 숫자의 빈도수를 계산
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int maxConsecutive = 0;
        
        // 각 숫자를 제거할 때 최대 연속된 동일 숫자의 수를 계산
        for (int removeKey : frequencyMap.keySet()) {
            int currentConsecutive = 0;
            int maxCurrentConsecutive = 0;
            int previous = Integer.MIN_VALUE;
            
            for (int num : numbers) {
                if (num == removeKey) continue;
                
                if (num == previous) {
                    currentConsecutive++;
                } else {
                    currentConsecutive = 1;
                }
                
                maxCurrentConsecutive = Math.max(maxCurrentConsecutive, currentConsecutive);
                previous = num;
            }
            
            maxConsecutive = Math.max(maxConsecutive, maxCurrentConsecutive);
        }
        
        return maxConsecutive;
    }
}