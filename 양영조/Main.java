import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> nums = new Stack<>();
		Stack<Integer> tmp = new Stack<>();
		int[] target = new int[N];
		// 1. 1 ~ N 까지의 수를 스택에 쌓아가는데
		// 2. stack 통해서, 만들기위한 주어진 입력값이 나오면
		// push 이후 바로 pop을 해야 똑같은 수열이 생김
		int idx = 0;
		for (int i = 0; i < N; i++) {
			target[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			nums.push(i + 1);
			sb.append("+").append("\n");
			while (target[idx] == nums.peek()) {
				nums.pop();
				idx++;
				sb.append("-").append("\n");
				if(nums.isEmpty())break;
			}
		}
		
		if (!nums.isEmpty()) {
			sb.delete(0, sb.length());
			sb.append("NO");
		}
		
		System.out.println(sb);
	}
}
