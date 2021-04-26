import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르 별 노래가 재생된 수를 저장할 해시맵
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        // 장르 별 노래가 재생된 횟수 count
        for(int i = 0; i < genres.length; i++){
            if(map.containsKey(genres[i]))
                map.put(genres[i], map.get(genres[i])+plays[i]);
            else
                map.put(genres[i], plays[i]);
        }
        
        // 장르의 keySet
        List<String> keySetList = new ArrayList<>(map.keySet());
        
        // 장르의 keySet으로 장르별 노래의 재생횟수를 정렬
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        
        // 장르 별로 가장 많이 재생된 노래의 고유번호를 저장할 ArrayList
        ArrayList<Integer>result = new ArrayList<Integer>();
        
        // 장르의 수만큼 반복
        for(int i = 0; i < keySetList.size(); i++){
            int first = 0;
            int second = 0;
            int max = 0;
            String temp = keySetList.get(i);
            
            // 장르별 가장 많이 재생한 노래는 꼭 하나는 존재하므로
            // 가장 많이 재생한 곡의 고유번호 탐색
            for(int j = 0; j < plays.length; j++){
                if(temp.equals(genres[j])){
                    if(max < plays[j]){
                        max = plays[j];
                        first = j;
                    }
                }
            }
            
            // 고유번호 삽입
            result.add(first);
            max = 0;
            
            // 같은 장르의 그 다음으로 많이 재생된 노래의 고유번호 탐색
            // first의 고유번호와 같으면 안되므로
            for(int j = 0; j < plays.length; j++){
                if(temp.equals(genres[j])){
                    // j가 first의 고유번호와 같지 않고, 가장 많이 재생된 노래 탐색
                    if(j != first && max < plays[j]){
                        max = plays[j];
                        second = j;
                    }
                }
            }
            
            // 있다면 고유번호 삽입
            if(max != 0)    result.add(second);
        }
        
        // result ArrayList에 삽입한 번호들을 int배열에 
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}
