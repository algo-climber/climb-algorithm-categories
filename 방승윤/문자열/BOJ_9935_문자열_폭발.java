import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열_폭발 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> afterBomb = new Stack<>();
		
		one: for (int i = 0; i < str.length(); i++) {
			// 스택에 일단 넣고
			afterBomb.push(str.charAt(i));
			
			// 방금 넣은 글자가 bomb의 마지막 글자와 같다면
			if (afterBomb.size() >= bomb.length() && str.charAt(i) == bomb.charAt(bomb.length() - 1)) {
				for (int j = 1; j < bomb.length(); j++) {
					// 바로 앞에 들어가 있는 단어가 bomb과 같은지 확인하고 아니라면 continue를 이용해서 반복문 탈출
					if (afterBomb.get(afterBomb.size() - 1 - j) != bomb.charAt(bomb.length() - 1 - j)) {
						continue one;
					}
				}
				
				// bomb과 같다면 bomb의 길이만큼 스택에서 pop해주면 bomb 단어 제거
				for (int j = 0; j < bomb.length(); j++) {
					afterBomb.pop();
				}
			}
		}
		
		// foreach를 이용하여 글자 재조합
		for (char c : afterBomb) {
			sb.append(c);
		}
		
		System.out.println(afterBomb.size() != 0 ? sb : "FRULA");

	}

}