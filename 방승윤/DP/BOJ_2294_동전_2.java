import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전_2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// K의 범위를 인덱스로 표현할 수 있게 coin과 cnt 배열을 K + 1 사이즈로 만들어 준다.
		boolean[] coin = new boolean[K + 1];
		int[] cnt = new int[K + 1];

		// cnt에 담길 최댓값인 K보다 큰 K + 1을 넣어준다.
		Arrays.fill(cnt, K + 1);
		// cnt[0]에는 아무 동전으로도 표현할 수 없으므로 0으로 만들어준다.
		cnt[0] = 0;

		// 사용하는 동전의 금액에 해당하는 coin[num]을 true로 바꿔준다.
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num <= K) {
				coin[num] = true;
			}
		}

		for (int i = 1; i <= K; i++) {
			// coin[i]가 true라면 i원의 동전은 있다!
			if (coin[i]) {
				for (int j = i; j <= K; j++) {
					// cnt[j - i] : j원에서 i원의 동전을 하나 뺀 금액을 만드는 데 필요한 최소 동전 개수
					// cnt[j] : j원을 만드는 데 필요한 최소 동전 개수
					// cnt[j - i]에서 i원 동전 하나를 추가한 값과 cnt[j]를 비교해서 작은 값으로 초기화 
					cnt[j] = Math.min(cnt[j - i] + 1, cnt[j]);
				}
			}
		}

		// cnt[K] : K원을 만드는 데 필요한 최소 동전 개수
		// cnt[K]가 처음 초기화한 값 그대로라면 만들 수 없으므로 -1로 바꿔줌
		if (cnt[K] == K + 1) {
			cnt[K] = -1;
		}

		System.out.println(cnt[K]);

	}

}