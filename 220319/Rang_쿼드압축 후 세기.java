class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        divide(arr, 0, 0, arr.length, arr.length);
        return answer;
    }
    
    void divide(int[][] arr, int lx, int ly, int rx, int ry) {
        if (!check(arr, lx, ly, rx, ry)) {
            int mx = (lx + rx) / 2;
            int my = (ly + ry) / 2;
            
            divide(arr, lx, ly, mx, my);
            divide(arr, lx, my, mx, ry);
            divide(arr, mx, ly, rx, my);
            divide(arr, mx, my, rx, ry);
        }
    }
    
    boolean check(int[][] arr, int lx, int ly, int rx, int ry) {
        int num = arr[lx][ly];
        
        for (int i = lx; i < rx; i++) {
            for (int j = ly; j < ry; j++) {
                if (num != arr[i][j])
                    return false;
            }
        }
        answer[num]++;
        return true;
    }
}
