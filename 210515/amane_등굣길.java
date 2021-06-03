import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        
        
        // 웅덩이 표시
        for(int[] puddle : puddles){
            map[puddle[0]][puddle[1]] = -1;
        }
        
        
        map[1][1] = 1;
        
        for(int i  = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(map[i][j] == -1) {
                	map[i][j] = 0;
                	
                }
                
                else{
                    if(i == 1){
                        map[i][j] += map[i][j-1];
                    }
                    else {
                	    map[i][j] = (map[i-1][j] + map[i][j-1]);
                    }
                }
                
               // 리턴 시만 % 1000000007를 하면
               //테케 중 int를 넘어가는 것이 생길 수 있어서 효율성에서 실패가 뜸으로
               // 매번 계산할 때마다 % 1000000007 해야 함
                map[i][j] = map[i][j] % 1000000007;
                 
            }
            
        }
        return map[m][n];
    }
}
