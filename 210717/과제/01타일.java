import java.util.*;

public class Main{
    static int[] arr;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        arr = new int[1000001];
        
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i = 3; i <= n; i++){
            arr[i] = -1;
        }
        
        System.out.println(find(n));
        
    }
    
    static int find(int n){
        if(arr[n] == -1){
            arr[n] = (find(n - 1) + find(n - 2)) % 15746;
        }
        
        return arr[n];
    }
}
