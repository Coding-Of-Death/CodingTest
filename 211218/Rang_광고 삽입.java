class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int[] time = new int[360000];
        
        for (String log : logs) {
            String[] temp = log.split("-");
            
            int start = calcTime(temp[0]);
            int end   = calcTime(temp[1]);
            
            for (int i = start; i < end; i++)
                time[i]++;
        }
        
        int adv   = calcTime(adv_time);
        int total = calcTime(play_time);
        
        int startIdx = 0;
        long sum = 0, max = 0;
        int left = 0, right = adv;
        
        for (int i = left; i < right; i++) {
            sum += time[i];
        }
        max = sum;
        
        while (right <= total) {
            sum -= time[left++];
            sum += time[right++];
            
            if (sum > max) {
                startIdx = left;
                max = sum;
            }
        }
        
        return transFormat(startIdx);
    }
    
    int calcTime(String time) {
        String[] hms = time.split(":");
        
        return Integer.parseInt(hms[0])*3600  
                    + Integer.parseInt(hms[1])*60 + Integer.parseInt(hms[2]);
    }
    
    String transFormat(int time) {
        int hour = time / 3600;
        time %= 3600;
        int min = time / 60;
        time %= 60;
        
        return (hour < 10 ? "0" + hour : hour) 
                + ":" + (min < 10 ? "0" + min : min)
                + ":" + (time < 10 ? "0" + time : time);
    }
}
