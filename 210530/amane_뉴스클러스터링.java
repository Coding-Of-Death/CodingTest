import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int re = 0;
        
        LinkedList<String> s1 = new LinkedList<>();
        LinkedList<String> s2 = new LinkedList<>();
        
        LinkedList<String> retainSet = new LinkedList<>();
        LinkedList<String> addAllSet = new LinkedList<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            String tmp = str1.substring(i, i+2).toLowerCase();
            
            if(tmp.matches("^[a-zA-Z]*$")){
                s1.add(tmp);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            String tmp = str2.substring(i, i+2).toLowerCase();
            
            if(tmp.matches("^[a-zA-Z]*$")){
                //System.out.println(tmp);
                s2.add(tmp);
            }
        }
        
        addAllSet = (s1.size() > s2.size()) ? s1 : s2;
        retainSet = (addAllSet == s1) ? s2 : s1;
        
        for(Iterator<String> it = retainSet.iterator(); it.hasNext();) {
            String str = it.next();
            if(addAllSet.contains(str)) {
                addAllSet.remove(str);
                it.remove();
                re++;
            }
        }
        
        int union = addAllSet.size() + retainSet.size() + re;
        
        double tmp = 0;
        
        if(retainSet.size() == 0 && addAllSet.size() == 0)
            answer = 65536;
        else{
            tmp = (double) re / (double) union;
            
            System.out.println(tmp);
            answer =  (int) (tmp * 65536);
            System.out.println(answer);
            
        }
            
        
        return answer;
    }
}
