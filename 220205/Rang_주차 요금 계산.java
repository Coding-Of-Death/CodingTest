import java.util.*;


class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String record : records) {
            String[] rec = record.split(" ");
            
            if (map.containsKey(rec[1])) {
                map.get(rec[1]).add(rec[0]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(rec[0]);
                map.put(rec[1], list);
            }
        }
        
        List<String> keyList = new ArrayList<>(map.keySet());
        int[] time = new int[keyList.size()];
        Collections.sort(keyList);
        
        for (int i = 0; i < keyList.size(); i++) {
            ArrayList<String> recList = map.get(keyList.get(i));
            
            int end = 0;
            if (recList.size() % 2 == 0) {
                end = recList.size();
            } else {
                end = recList.size() - 1;
            }
            
            for (int j = 0; j < end; j += 2) {
                time[i] += calcTime(recList.get(j), recList.get(j+1));
            }
            
            if (recList.size() % 2  != 0) {
                time[i] += calcTime(recList.get(end), "23:59");
            }
        }
        
        int[] answer = new int[time.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = calcFee(time[i], fees);
        }
        
        return answer;
    }
    
    
    int calcTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        
        int min = Integer.parseInt(e[1]) - Integer.parseInt(s[1]);
        int hour = Integer.parseInt(e[0]) - Integer.parseInt(s[0]);
        
        return hour*60 + min;
    }
    
    int calcFee(int time, int[] fees) {
        int result = fees[1];
        
        time -= fees[0];
        
        while (time > 0) {
            time -= fees[2];
            result += fees[3];
        }
        
        return result;
    }
}
