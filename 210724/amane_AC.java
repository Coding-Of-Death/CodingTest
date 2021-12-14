import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        while(T --> 0){
            boolean error = false, reverse = false;
            Deque<String> d = new ArrayDeque<>();
            
            char[] func = sc.next().toCharArray();
            int n = sc.nextInt();
            
            String num = sc.next();
            num = num.substring(1, num.length() - 1);
            
            String[] nums = num.split(",");
            
            for(int i = 0; i < n; i++){
                d.add(nums[i]);
            }
            
            for(int i = 0; i < func.length; i++){
                if(func[i] == 'R')
                    reverse = !reverse;
                else{
                    if(n - 1 < 0){
                        error = true;
                        break;
                    }
                    
                    if(reverse){
                        d.pollLast();
                    } else{
                        d.poll();
                    }
                    n--;
                }
            }
            
            if(error)
                sb.append("error\n");
            else{
                sb.append('[');
                
                for(int i = 0; i < n; i++){
                    if(reverse)    sb.append(d.pollLast());
                    else           sb.append(d.poll());
                    
                    if(i != n - 1)    sb.append(",");
                }
                
                sb.append("]\n");
            }
            
        }
        System.out.print(sb);
    }
}
