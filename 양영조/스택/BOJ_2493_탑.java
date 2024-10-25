import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main21 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 인덱스와 높이를 같이 저장하여 이용
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				// peek한 높이가 주어진 높이보다 높으면 인데스를 뽑아라
				if (stack.peek()[1] > height) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			// 비어있으면 0을 출력
			if (stack.isEmpty()) {
				sb.append("0").append(" ");
			}

			stack.push(new int[] { i, height });
		}

		System.out.println(sb);
	}
}