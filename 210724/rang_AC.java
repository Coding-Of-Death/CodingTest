import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		scan.nextLine();
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < T; i++) {
			String p = scan.nextLine();
			int n = scan.nextInt();
			scan.nextLine();
			String[] arr = scan.nextLine().split("\\[|,|\\]");
			sb.append(ac(p, arr)).append("\n");
		}
		System.out.println(sb);
		
		scan.close();
	}
	
	public static String ac(String p, String[] arr) {
		Deque<Integer> deq = new LinkedList<>();
		boolean reverse = false;
		
		for (String a : arr) {
			if (!a.equals(""))
				deq.offer(Integer.parseInt(a));
		}
		
		for (int i = 0; i < p.length(); i++) {
			switch(p.charAt(i)) {
				case 'R':
					reverse = !reverse;
					break;
				case 'D':
					if (deq.isEmpty()) {
						return "error";
					}
					
					if (reverse == true) {
						deq.pollLast();
					} else {
						deq.pollFirst();
					}
					break;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while (!deq.isEmpty()) {
			if (reverse == true) {
				sb.append(",").append(deq.pollLast());
			} else {
				sb.append(",").append(deq.pollFirst());
			}
		}
		return sb.length() == 0 ? "[]" :"[" + sb.substring(1) + "]";
	}
}
