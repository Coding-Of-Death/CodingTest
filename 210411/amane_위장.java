import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 옷을 분류할 hashmap 생성
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++){
            // 해시맵에 같은 종류의 옷이 있으면 옷 가짓수 + 1
            if(map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            
            // 같은 종류가 없으면 새로 추가
            else
                map.put(clothes[i][1], 1);
        }
        
        // keySet()은 해시맵에 있는 key값들을 확인하기 위한 함수
        // 경우의 수를 구하기 위해서 각각의 key값의 value에 +1을 한 후 곱하기
        // +1을 하는 이유 = 해당 key를 안 입는 경우도 있으니까
        for(String key : map.keySet()){
            answer *= map.get(key) + 1;
        }
        
        // 전체를 다 안 입은 경우도 있으니까 -1
        return answer - 1;
    }
}