import java.util.*;

public class Main{
    static int[] stack;
    static int size = 0;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        stack = new int[n];
        
        for(int i = 0; i < n; i++){
            String order = sc.next();
            if(order.equals("push")){
                push(sc.nextInt());
            }
            else if (order.equals("pop"))    sb.append(pop()).append('\n');
            else if (order.equals("size"))   sb.append(size()).append('\n');
            else if (order.equals("empty"))  sb.append(empty()).append('\n');
            else if (order.equals("top"))    sb.append(top()).append('\n');
        }
        System.out.println(sb);
    }
    
    // push() --> stack에 size번째에 m 저장
    //		        저장 후 size + 1
    static void push(int m){
        stack[size] = m;
        size++;
    }
    
    // pop() --> size가 0이면 스택이 비어있다는 것이므로 -1 리턴
    //		       아니면 size - 1에 마지막으로 저장한 값이 있으므로 size - 1번째 값을 리턴
    //		       리턴 전에 해당 주소 값을 0으로 바꿔주고 size - 1
    static int pop(){
        if(size == 0) return -1;
        else{
            int result = stack[size-1];
            stack[size-1] = 0;
            size--;
            return result;
        }
    }
    
    // size() --> size값 리턴
    static int size(){
        return size;
    }
    
    // empty() --> size가 0이면 스택이 비어있다는 의미이므로 1 리턴
    //		         아니면 스택이 비어있지 않으므로 0 리턴
    static int empty(){
        if(size == 0) return 1;
        else return 0;
    }
    
    // top() --> size가 0이면 스택이 비어있는 것이므로 -1리턴
    //           아니면 가장 위에 있는 값, 가장 처음 저장한 값인 size - 1번째 값 리턴
    static int top(){
        if(size == 0) return -1;
        else return stack[size-1];
    }
}
