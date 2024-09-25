package DP;

import java.io.*;
import java.util.*;

// DP를 이용한 문제풀이.
// n값을 입력받고, 각각의 동전의 가치들을 이용해 문제를 풀이한다.
// 가치가 같은 동전이 여러번 주어질 수 있고, 동전의 최소개수 출력. 불가능한 경우 -1 출력.
public class BJ_2294_동전2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001); // k보다 큰 값으로 초기화.
		dp[0] = 0; // 0원은 못만든다!
				
		for (int i = 0; i < arr.length; i++) { // 입력된 동전들을 하나씩 고려해줄건데,
			for (int j = arr[i]; j <= k; j++) { // 목표금액(k)까지 최소 동전 개수 갱신.
				dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);
			}
		}
		if(dp[k] == 10001) System.out.println(-1);
		else System.out.println(dp[k]);
		
	}
}
