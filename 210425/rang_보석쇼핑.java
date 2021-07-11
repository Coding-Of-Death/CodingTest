//https://bbangson.tistory.com/72
import java.util.*;


class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int[] answer = new int[2];
        int start = 0;
        int min = gems.length + 1;

        for (String gem : gems)
            set.add(gem);

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            queue.offer(gems[i]);

            while(!queue.isEmpty()) {
                if (map.get(queue.peek()) > 1) {
                    String gem = queue.poll();
                    map.put(gem, map.get(gem)-1);
                    start++;
                } else {
                    break;
                }
            }

            if (map.size() == set.size() && min > queue.size()) {
                answer[0] = start + 1;
                answer[1] = start + queue.size();
                min = queue.size();
            }
        }

        return answer;
    }
}
