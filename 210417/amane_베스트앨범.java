import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < genres.length; i++){
            if(map.containsKey(genres[i]))
                map.put(genres[i], map.get(genres[i])+plays[i]);
            else
                map.put(genres[i], plays[i]);
        }
        
       
        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        ArrayList<Integer>result = new ArrayList<Integer>();
        
        for(int i = 0; i < keySetList.size(); i++){
            int first = 0;
            int second = 0;
            int max = 0;
            String temp = keySetList.get(i);
            
            for(int j = 0; j < plays.length; j++){
                if(temp.equals(genres[j])){
                    if(max < plays[j]){
                        max = plays[j];
                        first = j;
                    }
                }
            }
            
            result.add(first);
            max = 0;
            
            for(int j = 0; j < plays.length; j++){
                if(temp.equals(genres[j])){
                    if(j != first && max < plays[j]){
                        max = plays[j];
                        second = j;
                    }
                }
            }
            
            if(max != 0)    result.add(second);
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}