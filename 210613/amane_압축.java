import java.util.*;

class Solution {
    
    // 사전
    static HashMap<String, Integer> map;
    static ArrayList<Integer> list;
    static char[] arr;
    static int idx = 1;

    public int[] solution(String msg) {
        int[] answer = {};
        
        map = new HashMap<>();
        list = new ArrayList<>();
        
        // 기본 알파벳 인덱스 추가
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A' + i)), i+1);
        }
        
        // msg 배열화
        arr = msg.toCharArray();
        
        while(idx <= arr.length){
            String tmp = "";
            
            // W + C
            if(idx == arr.length)
                tmp = Character.toString(arr[idx-1]);
            else
                tmp = Character.toString(arr[idx-1]) + Character.toString(arr[idx]);
            
            findMsg(tmp);
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    
    static void findMsg(String tmp){
        idx++;
        if(map.containsKey(tmp)){
            if(idx < arr.length){
                findMsg(tmp + arr[idx]);
                
            } else{
                idx++;
                list.add(map.get(tmp));
            }
        } else{
            map.put(tmp, map.size() + 1);
            tmp = tmp.substring(0, tmp.length() - 1);
            list.add(map.get(tmp));
        }
    }
}
