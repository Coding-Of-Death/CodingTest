import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int size = Math.max(n, k) * 2 + 1;
        
        int[] dp = new int[size];
        
        Queue<int[]> q = new LinkedList<>();
        
        // 처음 수빈이 있는 자리를 널음
        q.offer(new int[]{n, 0});
        dp[n] = 0;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int a = tmp[0];     // 위치
            int b = tmp[1];     // 시간
            
            if(dp[a] != 0)
                continue;
            
            dp[a] = b;
            
            if(a == k)
                break;
            
            if(a * 2 < size)
                q.offer(new int[]{a * 2, b + 1});
            
            if(a - 1 >= 0)
                q.offer(new int[]{a - 1, b + 1});
            
            if(a + 1 < size)
                q.offer(new int[]{a + 1, b + 1});
            
        }
        
        System.out.println(dp[k]);
        
    }
}
