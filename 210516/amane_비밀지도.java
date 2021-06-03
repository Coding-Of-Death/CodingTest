import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        ArrayList<String> map1 = new ArrayList<>();
        ArrayList<String> map2 = new ArrayList<>();
        
        String a1 = "";
        
        for(int i = 0; i < arr1.length; i++){
            a1 = Integer.toBinaryString(arr1[i]);    
            String w1 = "";
        
            // 길이가 괜찮은지 확인
            boolean flag = true;
            
            for(int j = 0; j < a1.length(); j++){
                if(a1.charAt(j) == '1')
                    w1 += "w";
                else
                    w1 += "b";
            }
            
            if(w1.length() != n){
                String s = "";
                for(int j = 0; j < n-w1.length(); j++)
                    s += "b";
                
                w1 = s + w1;
            }
            
            map1.add(w1);
        }
        
        for(int i = 0; i < arr2.length; i++){
            a1 = Integer.toBinaryString(arr2[i]);    
            String w1 = "";
        
            // 길이가 괜찮은지 확인
            boolean flag = true;
            for(int j = 0; j < a1.length(); j++){
                if(a1.charAt(j) == '1')
                    w1 += "w";
                else
                    w1 += "b";
            }
            
            if(w1.length() != n){
                String s = "";
                for(int j = 0; j < n-w1.length(); j++)
                    s += "b";
                
                w1 = s + w1;
            }
            
            map2.add(w1);
        }
        
        for(int i = 0; i < map1.size(); i++){
            String s1 = map1.get(i);
            String s2 = map2.get(i);
            String result = "";
            
            for(int j = 0; j < s1.length(); j++){
                if(s1.charAt(j) == 'b' && s2.charAt(j) == 'b')
                    result += " ";
                else
                    result += "#";
            }
            answer[i] = result;
        }
        
        
        return answer;
    }
}
