import java.util.*;


class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        //LinkedList<String> result = new LinkedList<>();
        
        
        for (int i = 0; i < record.length; i++) {
            String[] log = record[i].split(" ");
            
            switch(log[0]) {
                case "Enter" :
                    userMap.put(log[1], log[2]);
                    list.add(log[1] + "님이 들어왔습니다.");
                    break;
                case "Leave" :
                    list.add(log[1] + "님이 나갔습니다.");
                    break;
                case "Change" :
                    userMap.put(log[1], log[2]);
                    break;
            }
        }
        
        String[] answer = new String[list.size()];
        int i = 0;
        for (String s : list) {
            int indexID = s.indexOf("님");
            String id = s.substring(0, indexID);
            answer[i++] = s.replace(id, userMap.get(id));
        }
        
        
        return answer;
    }
}
