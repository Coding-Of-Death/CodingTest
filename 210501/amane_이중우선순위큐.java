import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        int size = 0;
        
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++){
            if(operations[i].charAt(0) == 'I'){
                int num = Integer.parseInt(operations[i].substring(2));
                pq_max.offer(num);
                pq_min.offer(num);
                
            }
            else if(!pq_max.isEmpty()){
                if(operations[i].charAt(2) == '-'){
                    int tmp = pq_min.poll();
                    deleteNum(pq_max, tmp);
                    System.out.println(tmp);
                }
                else{
                    int tmp = pq_max.poll();
                    deleteNum(pq_min, tmp);
                    System.out.println(tmp);
                }
            }
        }
        
        if(pq_max.size() != 0){
            answer[0] = pq_max.peek();
            answer[1] = pq_min.peek();
        }
        else{
            answer[0] = 0;
            answer[1] = 0;
        }
        
        return answer;
    }
    
    static void deleteNum(Queue<Integer> q, int num){
        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp == num) break;
            list.add(tmp);
                                
        }
        q.addAll(list);
    }
}