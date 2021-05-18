import java.util.*;


class Fail implements Comparable<Fail>{
    int stage;
    double failRate;
    
    
    Fail(int stage, double failRate) {
        this.stage = stage;
        this.failRate = failRate;
    }
    
    
    @Override
    public int compareTo(Fail o) {
        if (failRate == o.failRate) {
            return stage - o.stage;
        }
        // int형은 소수자리 계산을 저장하지 못한다.
        // Double형으로 해야 소수점 최대로 비교가능
        return Double.compare(o.failRate, failRate);
    }
}


class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Fail> list = new LinkedList<>();
        
        for(int stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }
        
        int sum = stages.length;
        for (int i = 1; i <= N; i++) {
            if (sum == 0)   list.add(new Fail(i, 0));
            else            list.add(new Fail(i, (double)map.getOrDefault(i, 0) / sum));
            
            sum -= map.getOrDefault(i, 0);
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stage;
        }
        
        return answer;
    }
}
