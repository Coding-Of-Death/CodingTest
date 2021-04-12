import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        // 정렬이 자동으로 되는 너무나 좋은 우선순위 큐 생성
        PriorityQueue<Integer> list = new PriorityQueue<>();
        
        
        for (int j = 0; j < scoville.length; j++){
            // 스코빌지수를 우선순위 큐에 넣기
            list.offer(scoville[j]);
        }
        
        int tmp = 0;
        
        while(list.peek() < K){
            // 큐의 크기가 2보다 작을 경우
            // = 음식을 전부 섞었지만 스코빌지수가 아직 원하는 수치에 도달하지 않은 것이므로
            // -1을 리턴
            if(list.size() < 2){
                return -1;
            }
            
            // 가장 작은 두 음식을 큐에서 빼내기
            int num1 = list.poll();
            int num2 = list.poll();
            
            // 음식을 섞어서 스코빌지수 계산
            tmp = num1 + num2 * 2;
            
            // 계산한 스코빌지수를 다시 우선순위 큐에 삽입
            list.offer(tmp);
            count++;
        }
        
        return count;
    }
}
