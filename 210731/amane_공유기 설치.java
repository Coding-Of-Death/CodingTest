import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int c = sc.nextInt();
        
        long[] dist = new long[n];
        
        for(int i = 0; i < n; i++){
            dist[i] = sc.nextLong();
        }
        
        Arrays.sort(dist);
        
        long left = 1;
        long right = dist[n - 1] - dist[0];
        long ans = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long prev = dist[0];
            int count = 1;
            
            for(int i = 0; i < n; i++){
                long d = dist[i] - prev;
                if(d >= mid){
                    count++;
                    prev = dist[i];
                }
            }
            
            if(count >= c){
                left = mid + 1;
                ans = mid;
            } else{
                right = mid - 1;
            }
        }
        
        System.out.println(ans);
        
        
    }
}
