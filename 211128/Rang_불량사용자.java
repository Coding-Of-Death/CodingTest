import java.util.*;


class Solution {
    int answer = 0;
    ArrayList<HashSet> list = new ArrayList();
    boolean[] checked;
    
    public int solution(String[] user_id, String[] banned_id) {
        checked = new boolean[user_id.length];
        HashSet<String> set = new HashSet();
        
        dfs(0, banned_id.length, user_id, banned_id, set);
        
        return answer;
    }
    
    void dfs(int count, int end, String[] user_id, String[] banned_id, HashSet<String> set) {
        if (count == end) {
            if (!list.contains(set)) {
                answer++;
                list.add((HashSet)set.clone());
            }
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (user_id[i].length() == banned_id[count].length()) {
                if (!checked[i] && isCorrect(user_id[i], banned_id[count])) {
                    checked[i] = true;
                    set.add(user_id[i]);
                    dfs(count+1, end, user_id, banned_id, set);
                    checked[i] = false;
                    set.remove(user_id[i]);
                }
            }
        }
    }
    
    boolean isCorrect(String id, String banned_id) {
        for (int i = 0; i < id.length(); i++) {
            if (banned_id.charAt(i) != '*' && id.charAt(i) != banned_id.charAt(i))
                return false;
        }
        return true;
    }
}
