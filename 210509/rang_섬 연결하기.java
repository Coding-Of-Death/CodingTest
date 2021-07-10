import java.util.*;


class Solution {
    public int solution(int n, int[][] costs) {
        int[] parents = new int[n];
        int num = 0;
        int answer = 0;
        
        initParents(parents);
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        for (int i = 0; i < costs.length; i++) {
            if (union(costs[i][0], costs[i][1], parents)) {
                answer += costs[i][2];
                if (++num == n - 1) {
                    break;
                }
            }
        }
        
        return answer;
    }
    
    void initParents(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
    
    boolean union(int a, int b, int[] parents) {
        int rootA = find(a, parents);
        int rootB = find(b, parents);
        
        if (rootA == rootB) {
            return false;
        }
        
        if (rootA > rootB) {
            parents[rootA] = parents[rootB];
        } else {
            parents[rootB] = parents[rootA];
        }
        
        return true;
    }
    
    int find(int a, int[] parents) {
        if (parents[a] != a) {
			return find(parents[a], parents);
		}
		return parents[a];
    }
}
