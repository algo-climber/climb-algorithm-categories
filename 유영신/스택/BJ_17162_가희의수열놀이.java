package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택이용. 스택의 값들이 mod로 나누었을때 나머지가 0 ~ (mod-1) 까지 하나이상 나타내기 위해 몇개의 수를 선택햐아하는지 출력
// 답이 존재하지 않을시 -1출력
// 입력값 1 -> 스택에 추가, 2 -> 제거, 3 -> 쿼리값 계산
// 최소 mod값 만큼은 스택에 추가 되어야 한다.

public class BJ_17162_가희의수열놀이 {
	static int Q, mod;
	static Stack<Integer> globalStack; // 전체 num을 담을 스택
	static Stack<Integer>[] modStack; // 나머지별로 몇번째로 add가 되었는지 담을 스택

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken());
		mod = Integer.parseInt(st.nextToken());
		globalStack = new Stack<>();

		modStack = new Stack[mod];
		for (int i = 0; i < mod; i++) {
			modStack[i] = new Stack<>();
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				int num = Integer.parseInt(st.nextToken());
				globalStack.add(num); // globalStack엔 num값 그대로 담고

				int modValue = num % mod;
				modStack[modValue].add(globalStack.size()); // 각각의 modStack에는 담을 당시의 globalStack의 size를 담는다.

			} else if (command == 2 && !globalStack.isEmpty()) {
				int num = globalStack.peek();

				int modValue = num % mod;
				if (!modStack[modValue].isEmpty()) {
					modStack[modValue].pop(); // pop 하기 전에 비어있는지 확인
				}

				globalStack.pop();
				
			} else if (command == 3) {
				check();
			}
		}

	}

	private static void check() {
		int minRequireSize = Integer.MAX_VALUE;

		for (int i = 0; i < mod; i++) {
			if (modStack[i].isEmpty()) { // 하나라도 비어있다면 조건을 만족하지 않으므로
				System.out.println(-1);
				return;
			}

			// modStack[i].peek() 중에 가장 작은 것이 시작지점 위치.
			minRequireSize = Math.min(minRequireSize, modStack[i].peek());
		}
		System.out.println(globalStack.size() - minRequireSize + 1);
	}
}
