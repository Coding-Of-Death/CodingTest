import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        String MAXMINUS = "D 1";
        String MINMINUS = "D -1";
        String PREFIX_NUMBER = "I ";
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i< operations.length; i++){
            if(operations[i].contains(PREFIX_NUMBER)){
                Integer number = Integer.valueOf(operations[i].replace(PREFIX_NUMBER,""));
                list.add(number);
                list.sort(null);
            } else if(!list.isEmpty()&&operations[i].equals(MAXMINUS)){
                list.remove(list.size()-1);
            } else if(!list.isEmpty()&&operations[i].equals(MINMINUS)){
                list.remove(0);
            }
        }
        if(list.isEmpty()){
            answer = new int[]{0,0};
        }else{
            answer = new int[]{list.get(list.size()-1),list.get(0)};
        }
        
        
        return answer;
    }
}
