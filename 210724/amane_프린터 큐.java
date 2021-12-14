import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T --> 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            
            LinkedList<int[]> q = new LinkedList<>();
            
            for(int i = 0; i < n; i++){
                q.offer(new int[] {i, sc.nextInt()});
            }
            
            while(!q.isEmpty()){
                int[] tmp = q.poll();
                boolean isMax = true;
                
                for(int[] queue: q){
                    if(queue[1] > tmp[1]){
                        isMax = false;
                    }
                }
                
                if(isMax){
                    count++;
                    if(tmp[0] == m)    break;
                } else{
                    q.offer(tmp);
                }
            }
            System.out.println(count);
        }
    }
}
