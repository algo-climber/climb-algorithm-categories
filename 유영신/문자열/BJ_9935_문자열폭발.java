package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935_문자열폭발 {
	static char[] arr;
	static Stack<Character> stack;
	static String st;
	static String bomb;
	static boolean correct; // 폭발 문자열인지 확인

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = br.readLine();
		bomb = br.readLine();

		stack = new Stack<>();

		for (int i = 0; i < st.length(); i++) {
			stack.add(st.charAt(i));
//			System.out.println(stack);
			correct = true;

			if (stack.size() >= bomb.length()) { // 폭발 문자열 길이만큼은 들어와야 확인.
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						correct = false;
						break; // 문자열 첫번째부터 확인. 다르다면 폭탄이 아님.
					}
				}

				if (correct) { // 폭탄이 맞다면 폭탄길이만큼 빼준다.
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
			
		}
		
		int stackSize = stack.size(); // pop할때마다 size가 작아지면, for문을 돌때 i범위가 달라지므로
									  // 고정
		
		if (!stack.isEmpty()) {
			for (int i = 0; i < stackSize; i++) {
				sb.append(stack.pop());
			}
		} else {
			System.out.println("FRULA");
		}

		System.out.println(sb.reverse());
	}

}

