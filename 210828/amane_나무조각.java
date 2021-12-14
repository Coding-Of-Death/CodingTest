import java.util.*;

public class Main{
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int[] origin = {1, 2, 3, 4, 5};
        
        for(int i = 0; i < 5; i++) {
        	arr[i] = sc.nextInt();
        }
        
        while(true) {
        	if(Arrays.equals(arr, origin))
        		break;
        	
        	for(int i = 0; i < 4; i++) {
            	boolean flag = true;
            	StringBuilder sb = new StringBuilder();
            	
            	if(arr[i] > arr[i + 1]) {
            		flag = false;
            		
            		int tmp = arr[i];
            		arr[i] = arr[i + 1];
            		arr[i + 1] = tmp;
            	}
            	
            	if(!flag) {
            		for(int j = 0; j < 5; j++) {
            			sb.append(arr[j] + " ");
            		}
            		sb.append("\n");
            	}
            	
            	System.out.print(sb);
            }
        }
        
    }
}
