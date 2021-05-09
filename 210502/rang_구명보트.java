import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        
        Arrays.sort(people);
        
        int sum = 0, right = 0, left = people.length -1;
        while (right <= left) {
            sum = people[left--];
            
            if (people[right] + sum <= limit) {
                right++;
            }
            
            boat++;
            sum = 0;
        }
        
        return boat;
    }
}
