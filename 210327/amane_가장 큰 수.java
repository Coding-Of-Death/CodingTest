import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            num[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(num, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return ((s2 + s1).compareTo(s1 + s2));
            }
        });
        
        if(num[0].equals("0"))
            return "0";
        
        for(int i = 0; i < numbers.length; i++)
            answer += num[i];
        
        return answer;
    }
}