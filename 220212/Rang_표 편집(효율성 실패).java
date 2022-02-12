import java.util.*;


class Solution {
    public String solution(int n, int k, String[] cmds) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        
        for (int i = 0; i < n; i++)
            list.add(i);
        
        int x;
        for (String cmd : cmds) {
            String[] c = cmd.split(" ");
            switch (c[0]) {
                case "U":
                    x = Integer.parseInt(c[1]);
                    k = k - x + (k < x ? n : 0);
                    break;
                case "D":
                    x = Integer.parseInt(c[1]);
                    k = k + x - (k + x >= n ? n : 0);
                    break;
                case "C":
                    stack.add(list.remove(k));
                    stack.add(k);
                    if (k == list.size())
                        k--;
                    break;
                case "Z":
                    x = stack.pop();
                    int data = stack.pop();
                    list.add(x, data);
                    
                    if (k >= x) {
                        k++;
                    }
                    break;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx < list.size() && list.get(idx) == i) {
                answer.append("O");
                idx++;
            } else {
                answer.append("X");
            }
        }
        
        return answer.toString();
    }
}
