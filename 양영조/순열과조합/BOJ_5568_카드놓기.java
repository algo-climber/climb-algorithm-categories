import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static int[] nums;
	static int[] ans;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> hash = new HashSet<>();
	public static void main(String[] args) throws IOException {
		// 카드 n장 1 ~ 99
		// k 장 선택, 가로로 나란히 정수를 만든다.
		// 만들수 있는 정수는 모두 몇가지?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		nums = new int[n];
		ans = new int[k];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		recur(0);
		sb.append(hash.size());
		System.out.println(sb);
	}

	static void recur(int idx) {
		if(idx == k) {
			String s = "";
		
			for(int i = 0; i < ans.length; i++) {
				s += ans[i];
			}
			hash.add(Integer.parseInt(s));
			return;
		}
		for(int i = 0; i < n; i++) {
			if(visited[i])continue;
			visited[i] = true;
			ans[idx] = nums[i];
			recur(idx + 1);
			ans[idx] = 0; 
			visited[i] = false;
		}
	}
}
