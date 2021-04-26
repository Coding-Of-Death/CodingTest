/* 큐를 사용한 코드 */

import java.util.*;

public class Main{
    static Queue<Integer> q;
    static int num = 0;
    
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        q = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            String str = sc.next();
            switch(str){
                case "push":
                	num = sc.nextInt();
                    q.offer(num);
                    break;
                    
                case "pop":
                	if(q.size() == 0)
                		sb.append(-1).append('\n');
                    else
                    	sb.append(q.poll()).append('\n');
                    break;
                    
                case "size":
                	sb.append(q.size()).append('\n');
                    break;
                    
                case "empty":
                	if(q.size() == 0)
                		sb.append(1).append('\n');
                    else
                    	sb.append(0).append('\n');
                    break;
                    
                case "front":
                	if(q.size() == 0)
                		sb.append(-1).append('\n');
                    else
                    	sb.append(q.peek()).append('\n');
                    break;
                    
                case "back":
                	if(q.size() == 0)
                		sb.append(-1).append('\n');
                    else
                    	sb.append(num).append('\n');
                    break;    
            }
        }
        System.out.println(sb);
    }
}
