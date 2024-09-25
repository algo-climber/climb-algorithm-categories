import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/12865
*/

/*
[문제 정리]
- 2 초 / 512 MB

- N개의 물건
- 각 물건의 무게 W, 가치 V
- 제한 무게 K

- 배낭에 넣을 수 있는 물건의 최대 가치 구하기
*/

public class BOJ_12865_평범한_배낭 {
	
	static BufferedReader br;
	
	static int N; // 물건의 수 (1 <= N <= 100)
	static int K; // 제한 무게 (1 <= K <= 100,000)
	
	static int[] WEIGHT;
	static int[] VALUE;
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		WEIGHT = new int[N + 1];
		VALUE = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			WEIGHT[i + 1] = Integer.parseInt(input[0]);
			VALUE[i + 1] = Integer.parseInt(input[1]);
		}
		
		// -------------------------- input --------------------------
		
		dp = new int[N + 1][K + 1];
		
		for (int idx = 1; idx <= N; idx++) {
			for (int weight = 1; weight <= K; weight++) {
				
				if (WEIGHT[idx] <= weight) dp[idx][weight] = Math.max(dp[idx - 1][weight], dp[idx - 1][weight - WEIGHT[idx]] + VALUE[idx]);
				else dp[idx][weight] = dp[idx - 1][weight];
				
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
	
}