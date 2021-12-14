import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        map = new HashMap<>();
        
        for(int i = 0; i < orders.length; i++){
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            
            StringBuilder tmp = new StringBuilder();
            
            for(int j = 0; j < course.length; j++){
                comb(ch, tmp, 0, 0, course[j]);
            }
        }
        
        for(int i = 0; i < course.length; i++){
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            
            int max = 0;
            
            for(Map.Entry<String, Integer> entry : set){
                if(entry.getKey().length() == course[i]){
                    max = Math.max(entry.getValue(), max);
                }
            }
            
            for(Map.Entry<String, Integer> entry : set){
                if(max > 1 && entry.getValue() == max && entry.getKey().length() == course[i]){
                    list.add(entry.getKey());
                    System.out.println(entry.getKey());
                }
            }

        }
        
        Collections.sort(list);    
        String[] answer = new String[list.size()];
            
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
            
        }
        return answer;
    }
    
    static void comb(char[] ch, StringBuilder tmp, int start, int n, int r){
        if(n == r){
            //System.out.println(tmp);
            map.put(tmp.toString(), map.getOrDefault(tmp.toString(), 0) + 1);
            return;
        }
        
        for(int i = start; i < ch.length; i++){
            tmp.append(ch[i]);
            comb(ch, tmp, i + 1, n + 1, r);
            tmp.delete(n, n + 1);
        }
    }
}
