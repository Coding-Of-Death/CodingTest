/*
남은 작업량을 각각의 진행속도로 나누어 남은 날짜를 큐에 넣는 것이 더 좋은 방법이었다.
*/

import java.util.*;

class Job {
    int progress;
    int speed;
    
    Job(int progress, int speed) {
        this.progress   = progress;
        this.speed      = speed;
    }
    
    // 하루당 작업의 진행도를 증가시키는 메소드
    void plusProgress() {
        progress += speed;
    }
}

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Job> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.offer(new Job(progresses[i], speeds[i]));
        }
        
        while(!queue.isEmpty()) {
            for (Job job : queue) {
                job.plusProgress();
            }
            
            int count = 0;
            while (!queue.isEmpty() && queue.peek().progress >= 100) {
                queue.poll();
                count++;
            }
            
            if (count > 0) {
                answer.add(count);
            }
        }
        
        return answer;
    }
}
