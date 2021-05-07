import java.util.*;
public class Main{
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();
        int K = sc.nextInt() - 1;
        int idx = K;
        sb.append("<");
        for(int i=1;i<=N;i++) queue.add(i);
        
        while(queue.size()!=1){
            sb.append(queue.get(idx).toString()+", ");
            queue.remove(idx);
            idx = (idx +K)%queue.size();
        }
        sb.append(queue.pop().toString()+">");
        System.out.println(sb);
    }
}
