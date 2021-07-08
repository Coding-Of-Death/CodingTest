import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> list = new ArrayList<>();
        String s = words[0];
        boolean flag = true;
        
        list.add(s);
        
        for(int i = 1; i < words.length; i++){
            if(list.indexOf(words[i]) == -1){
                //list.add(words[i]);
                if(words[i].charAt(0) == s.charAt(s.length() - 1)){
                    s = words[i];
                    list.add(s);
                    System.out.println(words[i]);
                    
                } else{
                    flag = false;
                }
                
                
            } else{
                flag = false;
            }
            
            if(!flag)
                break;
        }
        
        if(!flag){
            answer[0] = (list.size() % n) + 1;
            answer[1] = (list.size() / n) + 1;
        }

        return answer;
    }
}
