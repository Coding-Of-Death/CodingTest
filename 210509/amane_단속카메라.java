import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                Integer a = o1[1];
                Integer b = o2[1];
                
                return a.compareTo(b);
            }
        });
        
       
        for(int[] route : routes){
            if(camera < route[0]){
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}
