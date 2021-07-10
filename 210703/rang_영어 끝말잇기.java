import java.util.*;


class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> check = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (check.contains(words[i]) || !isRelay(check, words[i]))
                return new int[] {i%n + 1, i/n + 1};
            check.add(words[i]);
        }

        return new int[] {0, 0};
    }
    
    boolean isRelay(ArrayList<String> list, String b) {
        if (list.isEmpty())
            return true;
        
        String a = list.get(list.size()-1);
        return a.charAt(a.length()-1) == b.charAt(0) ? true : false;
    }
}
