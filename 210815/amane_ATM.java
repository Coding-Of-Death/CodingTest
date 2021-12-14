import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int[] result = new int[n];
        result[0] = arr[0];
        int sum = arr[0];
        
        for(int i = 1; i < n; i++) {
        	result[i] = result[i - 1] + arr[i];
        	sum += result[i];
        }
        
        System.out.println(sum);
        
    }
}
