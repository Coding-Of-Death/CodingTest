import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        int num = 0;
        
        int[] headNum   = new int[numbers.length];
        int[][] order   = new int[numbers.length][2];
        
        for (int i = 0; i < numbers.length; i++) {            
            if      (numbers[i] / 100  >= 1)  num = numbers[i] / 100;
            else if (numbers[i] / 10   >= 1)  num = numbers[i] / 10;
            else    num = numbers[i];
            
            headNum[i] = num;
            order[i][0] = num;
            order[i][1] = i;
        }
        
        Arrays.sort(headNum);
        
        for (int i = headNum.length - 1; i >= 0; i--) {
            if (i > 0 && order[i][0] == order[i - 1][0]) {
                String con1 = 
                    "" + numbers[order[i][1]] + numbers[order[i - 1][1]];
                String con2 = 
                    "" + numbers[order[i - 1][1]] + numbers[order[i][1]];
                
                num = Math.max(Integer.parsInt(con1), Integer.parsInt(con2));
            } else {
                num = numbers[order[i][1]];
            }
            
            answer += num;
        }
        
        return answer;
    }
}
