import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            
            if(arr[0].equals("Enter")){
                list.add("e " + arr[1]);
                map.put(arr[1], arr[2]);
                
            } else if (arr[0].equals("Leave")){
                list.add("l " + arr[1]);
                
            } else if(arr[0].equals("Change")){
                map.put(arr[1], arr[2]);
            }
            
        }
        
        String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            String[] arr = list.get(i).split(" ");
            
            if(arr[0].equals("e"))
                answer[i] = map.get(arr[1]) + "님이 들어왔습니다.";
            else
                answer[i] = map.get(arr[1]) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}
