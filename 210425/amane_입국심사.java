import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        // 심사대에서 걸리는 시간 정렬
        //Arrays.sort(times);
        
        long start = 0;
        long end = Long.MAX_VALUE;
        
        // 주어진 시간(중간값)
        long mid;
        
        // 주어진 시간내에 심사 받을 수 있는 사람들 누적합
        long sum = 0;
        
        while (start <= end){
            mid = (start + end) / 2;
            sum = 0;
            
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
                //System.out.println(sum);
                
                // 누적 합계의 사람이 기다리는 사람을 넘긴 경우 for문 중단
                if(sum >= n)
                    break;
            }
            
            // 제한 시간 내에 심사를 다 받지 못함
            if(n > sum)
                start = mid + 1;
            
            // 제한 시간 내에 다 받음
            // 시간 단축
            else{
                end = mid - 1;
                answer = Math.min(mid, answer);
            }
        }
        return answer;
    }
}
