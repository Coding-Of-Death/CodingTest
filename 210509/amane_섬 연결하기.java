import java.util.*;

class Solution {
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        // 가중치를 기준으로 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                Integer first = o1[2];
                Integer second = o2[2];
                
                return first.compareTo(second);
            }
        });
        
        // 처음 각각의 부모는 자기자신
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++){
            
            int first = find(parent, costs[i][0]);
            int second = find(parent, costs[i][1]);
            
            // 부모가 다르면 최소값을 기준으로 섬 연결하기
            // 어차피 가중치가 최소값부터 정렬되어 있으므로 연결 후, 연결 비용을 더한다
            if(first != second){
                parent[second] = first;
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    // 섬의 부모가 자기자신이면 자기자신을 리턴하고
    // 아니면 부모를 재귀함수로 찾아가기
    public static int find(int[] parent, int c){
        if(parent[c] == c){
            return c;
            
        } else{
            return parent[c] = find(parent, parent[c]);
        }
    }
}
