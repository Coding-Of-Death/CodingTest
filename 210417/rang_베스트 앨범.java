import java.util.*;
import java.util.Map.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int first, second, max;
        
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Entry<String, Integer>> listMap = new ArrayList<>(map.entrySet());
        Collections.sort(listMap, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        for(Map.Entry<String, Integer> entry : listMap) {
            String gen = entry.getKey();
            
            max = Integer.MIN_VALUE;
            first = -1;
            for (int i = 0; i < genres.length; i++) {
                if (gen.equals(genres[i]) && plays[i] > max) {
                    max = plays[i];
                    first = i;
                }
            }
            if (first != -1) {
                result.add(first);
            }
            
            max = Integer.MIN_VALUE;
            second = -1;
            for (int i = 0; i < genres.length; i++) {
                if (i != first && gen.equals(genres[i]) && plays[i] > max) {
                    max = plays[i];
                    second = i;
                }
            }
            if (second != -1) {
                result.add(second);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
