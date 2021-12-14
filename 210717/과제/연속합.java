import java.util.*;

public class Main{
    
    static int[] num;
    static Integer[] sum;
    static int max;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        num = new int[n];
        sum = new Integer[n];
        
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        
        sum[0] = num[0];
        max = sum[0];
        
        recur(n - 1);
        
        System.out.println(max);
        
        
    }
    
    static int recur(int n){
        if(sum[n] == null){
            sum[n] = Math.max(recur(n - 1) + num[n], num[n]);
            max = Math.max(sum[n], max);
        }
        
        
        
        return sum[n];
        
    }
}
