import java.util.*;


class Solution {
    ArrayList<Integer>   attriList  = new ArrayList<>();
    ArrayList<ArrayList> keyList    = new ArrayList<>();
    
    public int solution(String[][] relation) {
        
        for (int target = 1; target <= relation[0].length; target++) {
            dfs(0, target, relation);
        }
        
        return keyList.size();
    }
    
    void dfs(int curDep, int target, String[][] table) {
        if (curDep == target) {
            // 유일성 판별
            if (isUnique(table)) {
                // 최소성 판별
                boolean flag = true;
                
                for (int i = 0; i < keyList.size(); i++) {
                    if (attriList.containsAll(keyList.get(i))) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    keyList.add(new ArrayList<>(attriList));
                }
            }
            
            return;
        }
        
        // 속성 조합
        for (int i = 0; i <  table[0].length; i++) {
            if (!attriList.contains(i)) {
                attriList.add(i);
                dfs(curDep+1, target, table);
                attriList.remove(attriList.size() - 1);
            }
        }
    }
    
    boolean isUnique(String[][] table) {
        HashMap<String, Integer> check = new HashMap<>();
        
        for (int i = 0; i < table.length; i++) {
            String s = "";
            for (int j = 0; j < attriList.size(); j++) {
                s += table[i][attriList.get(j)];
            }
            check.put(s, check.getOrDefault(s, 0) + 1);
        }
        
        if (Collections.max(check.values()) > 1) {
            return false;
        }
        
        return true;
    }
}
