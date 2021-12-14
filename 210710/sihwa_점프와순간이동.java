import java.util.*;

public class Solution {
    public int solution(int n) {
       String binaryCode = Integer.toBinaryString(n);
        String[] arr = binaryCode.split("");
        int length = arr.length;
        int cnt = 0;
        
        for(int i = 0 ; i <length; i++){
            if(arr[i].equals("1")){
                cnt++;
            }
        }
        return cnt;
    }
}
