import java.util.*;

class Solution {
    static int cnt = 0;
    static char[][] map;
    static boolean[][] check;
    static boolean FinalAnswer = true;
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        check = new boolean[m][n];
        
        for(int i = 0; i < board.length; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(FinalAnswer){
            FinalAnswer = false;
            removeBlock(m, n);
            countBlank(m, n);
            arrangeMap(m, n);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == ' ')
                    cnt++;
            }
        }
        
        return cnt;
    }
    
    static void removeBlock(int m, int n){
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};
        
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                if(map[i][j] == ' ') continue;
                
                boolean flag = false;
                for(int k = 0; k < 3; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    
                    if(x >= 0 && x < m && y >= 0 && y < n){
                        if(map[i][j] != map[x][y]){
                            flag = true;
                            break;
                        }
                    }
                }
                
                if(!flag){
                    FinalAnswer = true;
                    check[i][j] = true;
                    for(int k = 0; k < 3; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        check[x][y] = true;
                    }
                }
            }
        }
        
    }
    
    static void countBlank(int m, int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(check[i][j]){
                    map[i][j] = ' ';
                    //cnt++;
                }
            }
        }
    }
    
    static void arrangeMap(int m, int n){
        for(int i = 0; i < n; i++){
            String tmp = "";
            for(int j = 0; j < m; j++){
                tmp += map[j][i];
            }
            String tmp2 = "";
            //System.out.println(tmp);
            tmp2 = tmp.replaceAll(" ", "");
            //System.out.println(tmp2);
            
            //cnt = tmp.length() - tmp2.length();
            
            for(int j = 0; j < tmp2.length(); j++){
                map[m-1-j][i] = tmp2.charAt(tmp2.length()-1-j);
                check[m-1-j][i] = false;
            }
            
            if(m > tmp2.length()){
                int loop = m-tmp2.length();
                for(int j = loop-1; j >= 0; j--){
                    map[j][i] = ' ';
                    check[m-1-j][i] = false;
                }
            }
        }
    }
}
