import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class programmers_92334 {

	public static void main(String[] args){

		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = { "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" };

		System.out.println(Arrays.toString(solution(id_list, report, 2)));

	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		int[] cnt = new int[id_list.length];

		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		list = Arrays.asList(id_list);

		for(String s : report){
			// 이미 신고함
			if(map.containsKey(s))
				continue;

			// 신고 안해서 신고 count
			map.put(s, 1);
			String[] tmp = s.split(" ");

			//System.out.println(tmp[1] + "\t" + list.indexOf(tmp[1]));
			// 신고당한 횟수 count
			cnt[list.indexOf(tmp[1])]++;

		}

		for(String s : map.keySet()){
			String[] tmp = s.split(" ");
			if(cnt[list.indexOf(tmp[1])] >= k)
				answer[list.indexOf(tmp[0])]++;
		}

		return answer;
	}
}
