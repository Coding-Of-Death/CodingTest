import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        int val1 = 0;
        int val2 = 0;
        for(int i = 0; i< wires.length; i++){
            val1 = relationCnt(i, wires);
            val2 = n - val1;
            int total = Math.abs(val1 -val2);
            answer = Math. min(total, answer);
        }
        return answer;
    }
    
    public int relationCnt(int idx, int[][] wires){
        Queue<Integer> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        for(int[] data :wires){
            list.add(data);
        }
        int parent = list.get(idx)[0];
        queue.add(parent);
        list.remove(idx);
        int cnt = 0;
        
        while(!queue.isEmpty()){
            int temp = queue.remove();
            for(int i = 0; i<list.size(); i++){
                int[] arr = list.get(i);
                boolean flag = true;
                if(arr[1]==temp){
                    queue.add(arr[0]);
                    list.remove(arr);
                    flag = false;
                }
                if(arr[0]==temp){
                    queue.add(arr[1]);
                    list.remove(arr);
                    flag = false;
                }
                if(flag == false){
                    i--;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
