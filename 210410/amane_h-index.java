import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 논문이 인용된 수를 정렬
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++){

            /******************************
            어떤 과학자가 발표한 논문 n편 중,
            h번 이상 인용된 논문이 h편 이상이고
            나머지 논문이 h번 이하 인용되었다면
            h의 최댓값이 이 과학자의 H-Index입니다.
            ********************************/

            // 구할 h의 최댓값            
            int idx = citations.length - i;
            
            /*
               citations	  return
            [3, 0, 6, 1, 5]	    3
            
            --> citations = [ 0, 1, 3, 5, 6 ]
            --> idx       = [ 5, 4, 3, 2, 1 ]      
            
            --> idx가 citations의 요소보다 작아지는 순간 = h-index
            --> return = 3
            
            */
            if(citations[i] >= idx){
                answer = idx;
                break;
            }
        }
        
        return answer;
    }
}
