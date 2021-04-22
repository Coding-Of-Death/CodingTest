import java.util.*;

class Solution {
    // 모든 edge를 지나는 문제
    boolean[] usedTickets;
    LinkedList<String> visited = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        usedTickets = new boolean[tickets.length];
        String result = "ICN";
        
        bfs("ICN", tickets, 0, result);
        
        Collections.sort(visited);
        String[] answer = visited.get(0).split(" ");
        
        return answer;
    }
    
    void bfs(String start, String[][] tickets, int count, String result) {
        if (count == tickets.length) {
            visited.add(result);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!usedTickets[i] && tickets[i][0].equals(start)) {
                usedTickets[i] = true;
                bfs(tickets[i][1], tickets, count+1, result + " " + tickets[i][1]);
                usedTickets[i] = false;
            }
        }
    }
}
