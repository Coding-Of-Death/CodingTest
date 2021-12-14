import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        
        LinkedList<Integer> d = new LinkedList<>();
        
        for(int i = 1; i <= n; i++){
            d.offer(i);
        }
        
        for(int i = 0; i < m; i++){
            int idx = d.indexOf(sc.nextInt());
            
            // 2번 수행 or 3번 수행 결정
            int half;
            
            if(d.size() % 2 == 0)
                half = d.size() / 2 - 1;
            else
                half = d.size() / 2;
            
            // 2번 수행
            if(idx <= half){
                for(int j = 0; j < idx; j++){
                    int tmp = d.pollFirst();
                    d.offerLast(tmp);
                    count++;
                }
            }
            // 3번 수행
            else{
                for(int j = 0; j < d.size() - idx; j++){
                    int tmp = d.pollLast();
                    d.offerFirst(tmp);
                    count++;
                }
            }
            // 1번 수행
            d.pollFirst();
        }
        System.out.println(count);
    }
}
