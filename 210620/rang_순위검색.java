import java.util.*;


class Solution {
    // 조건 문장을 key, 그에 해당하는 점수들의 리스트를 value
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        setInfo(info);
        setQuery(query, answer);
        
        return answer;
    }
    
    // Info를 hashmap에 넣은 뒤 크기순으로 점수를 정렬
    void setInfo(String[] info) {
        for (int i = 0; i < info.length; i++) {
            String[] temp = info[i].split(" ");
            dfs(temp, 0, "");
        }
        
        for (String s : map.keySet()) {
            ArrayList<Integer> list = map.get(s);
            Collections.sort(list);
        }
    }
    
   // Info의 정보와 "-"로 만들 수 있는 모든 조합 구하기
    void dfs(String[] arr, int depth, String s) {
        if (depth == 4) {
            if (map.containsKey(s))
                map.get(s).add(Integer.parseInt(arr[4]));
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(arr[4]));
                map.put(s, list);
            }
            
            return;
        }
        
        dfs(arr, depth+1, s + "-");
        dfs(arr, depth+1, s + arr[depth]);
    }
    
    // query 정보에서 and 등 불필요한 부분을 제외하고 map에 이용할 key와 value값 구하기
    void setQuery(String[] query, int[] answer) {
        for (int i = 0; i < query.length; i++) {
            String[] temp = query[i].split("( |and)+");
            
            String str = "";
            for (int j = 0; j < temp.length-1; j++) {
                str += temp[j];
            }
            answer[i] = counting(str, Integer.parseInt(temp[4]));
        }
    }
    
    // 매우 큰 수 이므로 이진탐색(이분탐색)
    int counting(String key, int target) {
        if (!map.containsKey(key))
            return 0;
        
        ArrayList<Integer> list = map.get(key);
        int left = 0, right = list.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return list.size() - left;
    }
}
