import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = 1;
        
        
        Arrays.sort(nums);
        
        for(int i = 1 ; i < nums.length; i++){
            
            if(nums[i-1]!=nums[i]){
                cnt++;
            }
            
        }
        answer = cnt > nums.length/2? nums.length/2 : cnt;
        
        return answer;
    }
}
