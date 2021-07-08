import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(true){
            if(n < 3){
                list.add(n);
                break;
                
            }
            list.add(n % 3);
            n /= 3;
        }
        
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
            answer += list.get(i) * Math.pow(3, list.size() - i - 1);
        }
        
        return answer;
    }
}
