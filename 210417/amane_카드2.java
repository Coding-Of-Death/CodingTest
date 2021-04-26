import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        boolean flag = true;
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        
        // 카드 정리
        for (int i = 1; i <= N; i++)
            q.offer(i);
        
        while(q.size() > 1){
        // 카드를 버림
            if(flag) {
            	q.poll();
            	flag = false;
            }
            
            // 카드를 제일 아래로 옮김
            else {
            	q.offer(q.poll());
            	flag = true;
            }
        }
        
        // 마지막에 남은 카드 번호 출력
        System.out.println(q.poll());
    }
}
