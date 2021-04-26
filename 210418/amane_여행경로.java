import java.util.*;

/*

테스트 1에서 통과 못했던 이유
way = way.substring(0, way.length()-4)를 해야 하는데
way.substring(0, way.length() - 4)만 해서
^p^

*/
class Solution {
    
    // 이동 가능한 모든 경로를 저장할 ArrayList
    static ArrayList<String> route = new ArrayList<>();
  
    // 이동하는 경로를 저장
    static String way = "";
  
    // 해당 티켓을 사용했는지 체크
    static boolean[] check;
    
    public String[] solution(String[][] tickets) {
        // 티켓을 전부 사용해야 하므로
        for(int i = 0; i < tickets.length; i++){
            check = new boolean[tickets.length];
            String begin = tickets[i][0];
            String end = tickets[i][1];
            
            // 인천에서 제일 먼저 출발해야 하므로
            if(begin.equals("ICN")){
                // 경로에 인천을 추가하고 해당 티켓을 사용했음을 체크
                // dfs로 다음 경로 추가
                way = begin + ",";
                check[i] = true;
                dfs(tickets, end, 1);
            }   
        }
        
        // 모든 경로를 정렬
        Collections.sort(route);
      
        // 가장 짧은 경로가 0번째 경로이므로
        // 0번째 route의 값을 가져와 ,를 기준으로 split하여 리턴
        return route.get(0).split(",");
    }
    
    static void dfs(String[][] tickets, String end, int count){
        // 여행 경로에 도착지를 더함
        way += end + ",";
       
        
        // 티켓을 다 사용했다면 지금까지의 여행 경로를 route에 추가 후
        // 함수 종료
        if(count == tickets.length){
            route.add(way);      
            return;
        }
            
        // 티켓의 길이만큼 반복
        for(int i = 0; i < tickets.length; i++){
            // 다음 출발지와 도착지 정보 대입
            String NScr = tickets[i][0];
            String NDst = tickets[i][1];
            
            // 현재 출발지가 이전 도착지와 일치하고 아직 사용하지 않은 티켓인 경우 수행
            if(NScr.equals(end) && !check[i]){
                // 사용했음을 체크
                check[i] = true;
                dfs(tickets, NDst, count+1);
              
                // 다른 경로를 확인하기 위해서 false로 변경
                check[i] = false;
                // 해당 경로를 way에서 빼기 위해 ,를 포함한 4글자를 경로에서 
                way = way.substring(0, way.length() - 4);
            }
        }
    }
}
