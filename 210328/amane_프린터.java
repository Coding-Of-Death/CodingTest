import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Print> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Print(i, priorities[i]));
        }
        
        while(!q.isEmpty()){
            boolean bigger = false;
            int first = q.peek().prior;
            
            for(int i = 0; i < priorities.length; i++){
                if(first < priorities[i]){
                    bigger = true;
                    break;
                }
            }
            
            if(bigger){
                q.offer(q.poll());
            } else{
                if(q.poll().loc == location)
                    answer = priorities.length - q.size();
            }
        }
        
        
        return answer;
    }
    
    public class Print{
        int loc;
        int prior;
        
        public Print(int loc, int prior){
            this.loc = loc;
            this.prior = prior;
        }
    }
}