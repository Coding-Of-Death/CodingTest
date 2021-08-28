import java.util.*;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String[][] jobs = trans(table);
        
        int[] scores = new int[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            for (int j = 0; j < languages.length; j++) {
                int rank = Arrays.asList(jobs[i]).indexOf(languages[j]);
                scores[i] += preference[j] * (rank > 0 ? 6 - rank : 0);
            }
        }
        
        int maxIdx = searchMax(scores, jobs);
        
        return jobs[maxIdx][0];
    }
    
    String[][] trans(String[] res) {
        String[][] result = new String[res.length][];
        
        for (int i = 0; i < res.length; i++) {
            result[i] = res[i].split(" ");
        }
        
        return result;
    }
    
    int searchMax(int[] scores, String[][] table) {
        int maxIdx = 0;
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[maxIdx])
                maxIdx = i;
            else if (scores[i] == scores[maxIdx])
                if (table[maxIdx][0].compareTo(table[i][0]) > 0)
                    maxIdx = i;
        }
        
        return maxIdx;
    }
}
