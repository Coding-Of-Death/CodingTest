// 세마인님 코드 참조

import java.util.*;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[leave.length];
        LinkedList<Integer> room = new LinkedList<>();
        
        int idx = 0, i = 0;
        // 나가는 사람 기준으로 (입장이 퇴장의 필수조건이기 때문에)
        while (i < leave.length) {
            // 방에 i번째 사람이 존재함.
            if (room.contains(leave[i])) {
                // 방에서 i번째 사람 퇴장, 이 때 방에 같이 있던 사람들은 반드시 만난 사람이니 정답 배열에 추가, i++
                room.remove((Integer) leave[i]);
                answer[leave[i++]-1] += room.size();
                // i번째 사람이 나갈 때 방에 있던 사람들 모두 반드시 i번째 사람과 만난 것으로 정답 배열에 +1 추가.
                for (int j = 0; j < room.size(); j++)
                    answer[room.get(j)-1]++;
            } else {
                // 방에 i번째 퇴장하는 사람이 존재하지 않는다면 입장할 때까지 앞 순서의 사람들 입장
                while (enter[idx] != leave[i]) {
                    room.add(enter[idx++]);
                }
                // 방에 i번째 퇴장하는 사람이 입장
                room.add(enter[idx++]);
            }
        }
        return answer;
    }
}
