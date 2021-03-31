import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int now = 0;        //현재 다리 위에 올라간 무게
        
        //지나가는 트럭
        Queue<Integer> truck = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++){
            while(true){
                
                //다리 위에 트럭이 안 지나가고 있을 경우에는
                //일단 다리 위에 트럭을 올리고 시작
                //지나가는 횟수를 추가하고 일단 빠져나오기
                
                if(truck.isEmpty()){
                    truck.offer(truck_weights[i]);
                    now += truck_weights[i];
                    answer++;
                    break;
                }
                
                //큐의 크기가 다리 길이와 같다?
                //그렇다는 건 다리를 다 건넜다는 거니까
                //다리위의 무게에서 첫번째꺼를 빼내고
                //큐에서도 없애기
                
                else if(truck.size() == bridge_length){
                    now -= truck.poll();
                }
                
                //시간은 계속 흐르니까 +1
                //아직 트럭이 건너는 중인데
                //근데 다리 위에 있는 트럭들의 무게가
                //다리가 버틸 수 있는 무게보다 크면 더이상 트럭이 올라가면 안됨
                //그러니까 0을 넣어서 트럭이 지나가기만을 기다리자
                
                //아직 다리에 트럭이 더 올라갈 수 있으면
                //다리 위에 다른 트럭을 올리자
                //올라갔으니까 현재 무게에 올라간 트럭 무게를 더하고
                //빠져나오기
                else{
                    answer++;
                    if(now + truck_weights[i] > weight){
                        truck.offer(0);
                        
                    } else{
                        truck.offer(truck_weights[i]);
                        now += truck_weights[i];
                        break;
                    }
                }
            }
        }
        //다리 길이만큼의 시간은 디폴트로 가야함
        return answer + bridge_length;
    }
}