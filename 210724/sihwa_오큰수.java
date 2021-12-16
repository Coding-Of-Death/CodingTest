import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        int[] number = new int[k];
        
        for(int i = 0 ; i < k ; i++){
            number[i] = sc.nextInt();
        }
        
        for(int i = 0 ; i < k; i++){
            while(!stack.isEmpty()&& number[stack.peek()]< number[i]){
                number[stack.pop()] = number[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            number[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < k; i++){
            sb.append(number[i]).append(' ');
        }
        System.out.println(sb);
        }
        
    }
