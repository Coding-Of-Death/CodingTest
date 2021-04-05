class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        
        // 전원이 체육복을 가지고 있다는 전제
        for(int i = 0; i < n; i++){
            arr[i] = 0;
        }
        
        // 전체 학생 중 체육복이 없는 학생
        for(int i = 0; i < lost.length; i++){
            arr[lost[i]-1]--;
        }
        
        // 전체 학생 중 체육복을 더 가지고 있는 학생
        // 없는 학생과 더 가지고 있는 학생의 번호가 겹칠 수 있으므로 ++
        for(int i = 0; i < reserve.length; i++){
            arr[reserve[i]-1]++;
        }

        for(int i = 0; i < n; i++){
            // 더 가지고 있는 학생일 경우
            if(arr[i] < 0){
                // 기준의 오른쪽 번호의 학생에게서 체육복을 빌림
                if(i != n-1 && arr[i+1] > 0){
                    arr[i]++;
                    arr[i+1]--;
                }
                
                // 기준의 왼쪽 번호의 학생에게서 체육복을 빌림
                else if(i != 0 && arr[i-1] > 0){
                    arr[i]++;
                    arr[i-1]--;
                }
            }
        }
        
        // 빌린 후 체육복을 가지고 있는 학생 수 세기
        for(int i = 0; i < n; i++){
            if(arr[i] >= 0)
                answer++;
        }
        
        return answer;
    }
}
