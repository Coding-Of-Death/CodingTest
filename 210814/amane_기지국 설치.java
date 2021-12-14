import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int idx = 0; // 원래 설치된 기지국 위치
        int pos = 1; // 설치예정 기지국 위치
        
        while(pos <= n){    // 처음부터 돌기
            // 설치예정 기지국 위치가 기존 기지국 범위 내라면 
            if(idx < stations.length && pos >= stations[idx] - w){
                pos = stations[idx] + w + 1;
                idx++;
            }
            
            // 범위 밖이라면 
            else{
                answer++;
                pos += w * 2 + 1;
            }
                
        }
        
        /*
        boolean[] check = new boolean[n];
        
        // 전파 범위
        for(int i = 0; i < stations.length; i++){
            check[stations[i] - 1] = true;
            for(int j = 1; j <= w; j++){
                if(stations[i] - 1 - j >= 0 && stations[i] - 1 - j < n){
                    check[stations[i] - 1 - j] = true;
                }
                
                if(stations[i] - 1 + j >= 0 && stations[i] - 1 + j < n){
                    check[stations[i] - 1 + j] = true;
                }
            }
        }
        
        // 설치
        int pos = 0;
        
        while(true){
            int cnt = 0;
            if(!check[pos]){
                answer++;
                for(int j = 1; j <= w; j++){
                    if(pos - j >= 0 && pos - j < n){
                        check[pos - j] = true;
                    }
                
                    if(pos + j >= 0 && pos + j < n){
                        check[pos + j] = true;
                    }
                }
                pos += w * 2 + 1;
            }
            
            for(int i = 0; i < n; i++){
                if(check[i])
                    cnt++;
            }
            
            if(cnt == n)
                break;
        }
        
        
        for(int i = 0; i < n; i++){
            if(check[i])
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }
        */
        
        return answer;
    }
}
