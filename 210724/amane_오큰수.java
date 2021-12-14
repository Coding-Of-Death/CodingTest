import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] result = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        
        stack.push(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                result[stack.pop()] = nums[i];
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        
        for(int i = 0; i < n; i++){
            sb.append(result[i] + " ");
        }
        System.out.print(sb);
    }
}
