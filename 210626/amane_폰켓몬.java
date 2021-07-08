import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums){
            set.add(i);
        }
        
        if(set.size() > answer)
            return answer;
        
        return set.size();
    }
}
