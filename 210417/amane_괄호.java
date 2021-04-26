import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = "";
        
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++){
        
        	// 괄호 '('를 넣을 큐 생성
            // 원래는 스택으로 해야 하지만 여기서는 소괄호만 사용하므로 큐도 괜찮을 듯
            Queue<Character> q = new LinkedList<>();
            
            str = sc.next();
            boolean flag = true;
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                
                // 여는 소괄호를 큐에 추가
                if(ch == '(')
                    q.offer('(');
                    
                // 닫는 소괄호의 경우
                else if (ch == ')'){
                    // 이전에 여는 소괄호가 있을 경우 큐는 비어있지 않으므로
                    // 큐에서 '('를 하나 제거
                    if(!q.isEmpty())
                        q.poll();
                    
                    // 큐가 비어있거나 첫번째로 들어온 문자가 ')'일 경우
                    // 짝이 안 맞다는 뜻이므로
                    else{
                    	// flag를 false로 변경 후 for문을 빠져나온다
                        flag = false;
                        break;
                    }
                }
            }
            
            // 큐가 비어있고 짝이 다 맞는 경우 YES 출력
            if(q.isEmpty() && flag == true)
                System.out.println("YES");
                
            // 큐가 비어있지 않거나 짝이 안 맞는 경우 (flag가 false인 경우) NO 출력
            else
                System.out.println("NO");
        }
        
    }
}
