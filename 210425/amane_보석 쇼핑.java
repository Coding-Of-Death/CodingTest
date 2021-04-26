import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashSet<String> set = new HashSet<>();
        Queue<String> gems_q = new LinkedList<>();
        
        int len = gems.length;
        int left = 0;
        int start = 0;
        int right = gems.length;
        
        // 보석종류
        for(String s : gems){
           set.add(s);
        }
        
        // 비교
        for(int i = 0; i < len; i++){
            if(map.containsKey(gems[i]))
                map.put(gems[i], map.get(gems[i])+1);
            else
                map.put(gems[i], 1);
            
            gems_q.offer(gems[i]);
            
            while(!gems_q.isEmpty()){
                int tmp = map.get(gems_q.peek());
                
                if(tmp >= 2){
                    map.put(gems_q.peek(), map.get(gems_q.peek()) - 1);
                    gems_q.poll();
                    left++;
                } else
                    break;
            }
            
            if(map.size() == set.size() && right > gems_q.size()){
                right = gems_q.size();
                start = left;
            }
            
            
        }
        
        int[] answer = {start + 1, start + right};
        System.out.println(start);
        System.out.println(right);
        
        return answer;
    }
}
