class Solution {
    public int[] solution(int n) {
        
        int[][] tri = new int[n][n];
        
        int x = -1;
        int y = 0;
        int num = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0)  // 아래로
                    x++;
                else if(i % 3 == 1) // 오른쪽으로
                    y++;
                else{           // 대각선으로 
                    x--;
                    y--;
                }
                
                tri[x][y] = ++num;
            }
        }
        int[] answer = new int[num];
        
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(tri[i][j] == 0)  break;
                answer[k++] = tri[i][j];
                System.out.print(tri[i][j] + "\t");
            }
            System.out.println();
        }
        
        
        return answer;
    }
}
