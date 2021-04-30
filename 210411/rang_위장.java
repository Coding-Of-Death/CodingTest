import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cMap = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            cMap.put(clothes[i][1], cMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우)
        for (int val : cMap.values()){
            answer *= (val + 1);
        }

        // 모두 다 안입는 경우는 존재하지 않으므로 -1
        return answer-1;
    }
}
