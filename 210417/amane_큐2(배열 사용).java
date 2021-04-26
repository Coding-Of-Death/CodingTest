/* 배열을 이용한 코드 */

import java.util.*;

public class Main{
    static int[] q;
  
    // size는 다음에 집어 넣을 위치
    static int size = 0;
    // now는 가장 앞을 가리키는 위치
    static int now = 0;
    
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        q = new int[N];
        
        for(int i = 0; i < N; i++){
            String str = sc.next();
            switch(str){
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;    
            }
        }
        System.out.println(sb);
    }
    
    // 배열에 size번째에 n 저장
    static void push(int n){
        q[size] = n;
        size++;
    }
    
    // 가장 앞에 있는 now번째 값을 리턴
    // now번째를 꺼내고 now + 1로 다음으로 앞에 있는 값의 위치 이동
    static int pop(){
        if(size-now == 0)
            return -1;
        else{
            int result = q[now];
            q[now] = 0;
            //size++;
            now++;
            return result;
        }
    }
    
    // 현재 큐의 크기 = 넣어야 할 위치(size) - 가장 앞에 있는 값의 위치(now)
    static int size(){
        return size-now;
    }
    
    // 큐의 크기가 0이면 1 리턴
    // 아니면 0 리턴
    static int empty(){
        if(size-now == 0) return 1;
        else return 0;
    }
    
    // 큐의 크기가 0이라면 -1 리턴
    // 아니라면 now번째 값 리턴
    static int front(){
        if(size-now == 0) return -1;
        else return q[now];
    }
    
    // 큐의 크기가 0이라면 -1 리턴
    // 아니라면 size - 1번째 값 리턴
    static int back(){
        if(size-now == 0) return -1;
        else return q[size-1];
    }
}
