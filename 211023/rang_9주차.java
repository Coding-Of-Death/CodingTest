import java.util.*;


class Solution {
    int[][] arr;
    int nodeCount;
    
    public int solution(int n, int[][] wires) {
        arr = new int[n+1][n+1];
        nodeCount = n;
        
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            
            arr[u][++arr[u][0]] = v;
            arr[v][++arr[v][0]] = u;
        }
        
        int startNode = wires[0][0];
        
        int answer = 100, result = 0;
        for (int[] wire : wires) {
            result = bfs(startNode, wire);
            answer = Math.min(answer, result);
        }
        
        return answer;
    }
    
    int bfs(int start, int[] cuttedWire) {
        boolean[] used = new boolean[nodeCount+1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        int size = 1;
        used[start] = true;
        
        while(!queue.isEmpty()) {
            int nowNode = queue.remove();
            
            for (int i = 1; i <= arr[nowNode][0]; i++) {
                int nextNode = arr[nowNode][i];
                
                if (used[nextNode]) continue;
                if (nowNode == cuttedWire[0] && nextNode == cuttedWire[1])  continue;
                if (nowNode == cuttedWire[1] && nextNode == cuttedWire[0])  continue;
                
                used[nextNode] = true;
                queue.add(nextNode);
                size++;
            }
        }
        
        int subSize = nodeCount - size;
        return Math.abs(subSize - size);
    }
}
