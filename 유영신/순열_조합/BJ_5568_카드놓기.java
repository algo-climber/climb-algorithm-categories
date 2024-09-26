package 순열_조합;

import java.io.*;
import java.util.*;

// 순열을 이용하여 가능한 모든 경우의 수를 탐색한 후, HashSet을 통해 중복된 값을 제거해주면 값이 나올 것 같다.
public class BJ_5568_카드놓기 {
	static int n, k;
	static HashSet<String> set; // 결과값들을 담을 set
	static int nums[], stack[];
	static boolean[] visited;
	static String result; // 결과값들
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		

		visited = new boolean[n];
		nums = new int[n];
		stack = new int[n];
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		set = new HashSet<>();
		
		permu(0);
		
//		System.out.println(set);
		System.out.println(set.size());
	}

	private static void permu(int idx) {
		// 기저조건
		if(idx == k) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k; i++) {
				sb.append(stack[i]);
			}
			set.add(sb.toString());
			return; 
		}
		
		// 재귀부분
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			stack[idx] = nums[i];
			permu(idx + 1);
			visited[i] = false;
		}
	}
}
