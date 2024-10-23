package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 회문이면 0, 유사회문이면 1, 그 외는 2를 출력
public class BJ_17609_회문 {
	static int result;
	static String st;
	static int countL, countR;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = br.readLine();
			result = 0;
			countL = 0;
			countR = 0;
			checkPalindrome(st);

			System.out.println(result);
		}

	}

	private static void checkPalindrome(String st) {

		// 회문인지 먼저 확인
		for (int i = 0; i < st.length() / 2; i++) {
			if (st.charAt(i) != st.charAt(st.length() - 1 - i)) {
				result = 2;
				break;
			} else {
				result = 0;
			}
		}

		// 회문이 아닌것들 중에서 유사 회문 확인
		if (result == 2) {
			checkLeft();
			checkRight();

			if (countL == 1 || countR == 1) {
				result = 1;
			}
		}
	}

	private static void checkLeft() {
		int left = 0;
		int right = st.length() - 1;

		// 왼쪽 지워보기
		while (left < right) {
			if (st.charAt(left) != st.charAt(right)) {
				left++;
				countL++;

				if (countL > 1)
					break;
			} else {
				left++;
				right--;
			}
		}
//		System.out.println("countL = " + countL);

	}

	private static void checkRight() {
		int left = 0;
		int right = st.length() - 1;

		// 오른쪽 지워보기
		while (left < right) {
			if (st.charAt(left) != st.charAt(right)) {
				right--;
				countR++;

				if (countR > 1)
					break;
			} else {
				left++;
				right--;
			}
		}
//		System.out.println("countR = " + countR);
	}
}

//loop2: for (int i = 0; i < charArr.size(); i++) {
//char ch = charArr.remove(i);
//
//loop1: for (int j = 0; j < charArr.size() / 2; j++) {
//	if (charArr.get(j) != charArr.get(charArr.size() - j - 1)) {
//		break loop1;
//	} else {
//		result = 1;
//		break loop2;
//	}
//}
//
//if (0 <= i && i < charArr.size() - 1) {
//	charArr.add(i, ch);
//}
//}
