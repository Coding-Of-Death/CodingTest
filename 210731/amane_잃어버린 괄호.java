import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] minus = sc.nextLine().split("-");
        int sum = Integer.MAX_VALUE;
        
        for(int i = 0; i < minus.length; i++){
            int tmp = 0;
            
            String[] plus = minus[i].split("\\+");
            
            for(int j = 0; j < plus.length; j++)
                tmp += Integer.parseInt(plus[j]);
            
            if(sum == Integer.MAX_VALUE)
                sum = tmp;
            else
                sum -= tmp;
        }
        
        System.out.println(sum);
        
    }
}
