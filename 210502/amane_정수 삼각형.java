import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        
        for(int i = triangle.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        
        for(int i = triangle.length-1; i >= 0; i--){
            for(int j = 0; j < i; j++)
                System.out.print(triangle[i][j] + "\t\t");
            System.out.println();
        }
        
        answer = triangle[0][0];
      
        return answer;
    }
}
