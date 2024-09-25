import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 물품의 수 N, 버틸 수 있는 무게 K
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 무게와 가치를 담는 배열을 각각 선언 및 초기화
		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp배열 선언
		// 크기는 K까지 찾아야 하므로 K + 1
		//[개수][무게] 일때 최대값을 저장
		int[][] dp = new int[N + 1][K + 1];
		
		// 최소 무게 미만은 가능한 경우가 없으므로
		// 최소 무게부터 시작
		for(int i = 1; i <= N; i++){
			
			// 해당 개수이면서 w무게일 때 최대 가치를 찾는 반복문
			for(int w = 1; w <= K; w++) {
				
				// 새로 물건을 넣는다는 가정하에
				// 물건의 무게가 제한을 초과하지 않을 경우
				if(weight[i] <= w) {
					
					// 개수가 하나 적으면서 동일한 무게 제한인 dp와
					// 새로 넣어줄 물건의 가치 + 그 물건을 넣기전 dp 중 큰 값을 dp에 저장
					// 무게 제한을 넘지 않아야 하기에 w - weight
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w-weight[i]] + value[i]); 
					
				// 새로 넣으면 무게를 초과하게 될 경우
				// 개수가 하나 적을 때의 최대 가치를 저장
				}else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
