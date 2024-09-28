import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동전의 개수 n, 원하는 가격 k
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 동전을 담을 배열
		int[] coins = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coins);
		
		// 사용할 dp배열
		// 0을 제외하고 k까지 이므로 k + 1
		int[] dp = new int[k + 1];
		
		// 최솟값을 구하기 위해 배열을 전부 최댓값으로 초기화
		for(int i = 1; i <= k; i++) {
			dp[i] = 100001;
		}
		
		// dp 인덱스가 가리키는 것은 만드려는 가격
		// 해당 인덱스에 담길 값은 최소 동전 개수
		for(int i = 1; i <= n; i++) {
			
			for(int j = coins[i]; j <= k; j++) {
				
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);						
				
			}
			
		}
		if(dp[k] == 100001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
	}
}