package DP;

import java.io.*;
import java.util.*;

// DP문제
public class BJ_12865_평범한배낭{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weightArr = new int[N+1];
		int[] valueArr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weightArr[i] = Integer.parseInt(st.nextToken());
			valueArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if(weightArr[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weightArr[i]] + valueArr[i]);
				} else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
