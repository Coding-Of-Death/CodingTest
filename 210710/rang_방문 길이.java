import java.util.*;


class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        
        int x = 0, y = 0, preX, preY;
        for (int i = 0; i < dirs.length(); i++) {
            preX = x;
            preY = y;
            switch(dirs.charAt(i)) {
                case 'U':
                    if (y < 5)  y++;
                    break;
                case 'D':
                    if (y > -5) y--;
                    break;
                case 'R':
                    if (x < 5)  x++;
                    break;
                case 'L':
                    if (x > -5) x--;
                    break;
            }
            
            if (preX == x && preY == y)
                continue;
            
            String route1 = preX + ", " + preY + " -> " + x + ", " + y;
            String route2 = x + ", " + y + " -> " + preX + ", " + preY;
            if (!set.contains(route1)) {
                set.add(route1);
                set.add(route2);
                answer++;
            }
        }
        
        return answer;
    }
}
