import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNums = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
        	strNums[i] = "" + numbers[i];
        }
        
        /*
        Comparator 객체를 사용해야할 때
        - 정렬 대상 클래스의 코드를 직접 수정할 수 없는 경우
        - 정렬하고자 하는 객체에 이미 존재하고 있는 정렬 기준과 다른 정렬 기준으로 정렬을 하고 싶을 때
        
        a.compareTo(b) : 
            1.  compareTo() 메서드를 통해 인자로 넘어온 같은 타입의 다른 객체와 대소 비교가 가능
            2. 앞에서부터 비교하다 다른 문자열이 나오면 'a-b' 순서로 해당 문자의 아스키코드 값을 뺀 결과(int)를 리턴
            3. 메서드를 호출하는 객체가 인자로 넘어온 객체보다 작을 경우에는 음수를 리턴하고, 크기가 동일하다면 0, 클 경우에는 양수를 리턴(4번에서 순서가 중요한 이유!)
            4. a, b 순서로 있을 때 (b+a).compareTo(a+b) 을 했을 경우 'b+a'가 더 크다면 자리를 바꿔주면 된다.
        */
        Arrays.sort(strNums, new Comparator<String>() {
        	@Override
        	public int compare(String num1, String num2) {
        		return (num2 + num1).compareTo(num1 + num2);
        	}
        });
        // 람다식 표현
        //Arrays.sort(strNums, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));
        
        if (strNums[0].equals("0")) {
        	return "0";
        }
        
        for (String str : strNums) {
        	answer += str;
        }
        
        
        return answer;
    }
}
