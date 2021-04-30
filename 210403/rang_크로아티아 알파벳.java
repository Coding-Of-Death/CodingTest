/*
croatia 문자열 배열에서 "dz="가 "z="보다 앞의 순서여야한다.
*/

public class Main {
	
	public static void main(String[] args) {
		String[] croatia = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine().trim();
        
        for(String word : croatia) {
					input = input.replace(word, "*");
        }
		
		int count = input.length();
		
		System.out.println(count);
	}
}
