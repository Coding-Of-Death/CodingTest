import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String[] origin = {"C#", "D#", "F#", "G#","A#"};
        String[] repl = {"c", "d", "f", "g", "a"};
        
        String[][] list = new String[musicinfos.length][3];
        
        
        int maxTime = 0;
        
        // 음 정보 구분
        for(int i = 0; i < origin.length; i++){
            m = m.replace(origin[i], repl[i]);
        }
        
        
        // 음악정보 나누기
        for(int i = 0; i < musicinfos.length; i++){
            String[] infos = musicinfos[i].split(",");
            
            for(int j = 0; j < origin.length; j++){
                infos[3] = infos[3].replace(origin[j], repl[j]);
            }
            
            int playTime = getTime(infos[0], infos[1]);
            String code = "";
            
            for(int j = 0; j < playTime; j++){
                code += infos[3].charAt(j % infos[3].length());
            }
            
            if(code.contains(m)){
                if(maxTime < code.length()){
                    maxTime = code.length();
                    answer = infos[2];
                }
            }
            
        }
        
        
        return answer;
    }
    
    static int getTime(String t1, String t2){
        String[] at1 = t1.split(":");
        String[] at2 = t2.split(":");
        
        int pt1 = Integer.parseInt(at1[0]) * 60 + Integer.parseInt(at1[1]);
        int pt2 = Integer.parseInt(at2[0]) * 60 + Integer.parseInt(at2[1]);
        
        return Math.abs(pt2 - pt1);
    }
}
