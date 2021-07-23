import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

class Printer {
	int prior;
	int loc;
	
	public Printer(int prior, int loc) {
		this.prior	= prior;
		this.loc	= loc;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		String s = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < testCase; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			s = br.readLine();
			st = new StringTokenizer(s);
			Queue<Printer> queue = new LinkedList<>();
			
			for (int j = 0; j < N; j++) {
				queue.add(new Printer(Integer.parseInt(st.nextToken()), j));
			}
			
			here : 
			while(!queue.isEmpty()) {
				Printer current = queue.poll();
				for (Printer q : queue) {
					if (current.prior < q.prior) {
						queue.offer(current);
						continue here;
					}
				}
				
				if (current.loc == M) {
					//System.out.println(N - queue.size());
					sb.append(N - queue.size()).append("\n");
					break;
				}
				// 하나의 max가 없이 모두 동등할 경우 처리방법을 custom하기 복잡함.
//				if (current >= queue.stream().max(Comparator.comparing(x -> x)).orElseThrow(NoSuchElementException::new)) {
//					if (M == 0) {
//						sb.append(current);
//						break;
//					}
//					M--;
//				} else {
//					if (M == 0) {
//						M += queue.size();
//					}
//					queue.add(current);
//				}
			}
		}
		System.out.println(sb);
	}

}
