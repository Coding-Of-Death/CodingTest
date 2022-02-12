import java.util.*;


class Solution {
    public String solution(int n, int k, String[] cmds) {
        Stack<Integer> remove = new Stack<Integer>();
        int tableSize = n;
        
        for(String cmd : cmds) {
            String[] c = cmd.split(" ");
            
            switch (c[0]) {
                case "D":
                    k += Integer.parseInt(c[1]);
                    break;
                case "U":
                    k -= Integer.parseInt(c[1]);
                    break;
                case "C":
                    remove.add(k);
                    tableSize--;
                    if (k == tableSize)
                        k--;
                    break;
                case "Z":
                    if (remove.pop() <= k)
                        k++;
                    tableSize++;
                    break;
            }
        }
        
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < tableSize; i++)
            answer.append("O");
        while(!remove.isEmpty())
            answer.insert(remove.pop().intValue(), "X");
        
        return answer.toString();
    }
}
