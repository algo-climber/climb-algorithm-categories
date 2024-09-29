import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_5568_카드_놓기 {
	
	static int N, K;
	static int[] cards;
	// 중복 제거를 위해 HashSet으로 만듦
	static HashSet<String> nums;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		cards = new int[N];
		nums = new HashSet<>();

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}
		
		makeNum(0, "");
		
		// 만들어진 정수를 중복 제거하고 nums에 저장했기 때문에 사이즈를 출력하면 정답
		System.out.println(nums.size());

	}

	static void makeNum(int idx, String num) {
		
		// K장의 카드로 만든 정수를 추가
		if (idx == K) {
			// HashSet이기 때문에 자동으로 중복 제거
			nums.add(num);
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			// 100 이상이면 이미 뽑은 카드
			if (cards[i] < 100) {
				// 뽑히면 100을 더해줌
				cards[i] += 100;
				makeNum(idx + 1, num + cards[i] % 100);
				// 선택 안됐으니 100을 빼줌
				cards[i] -= 100;
			}
		}
		
	}

}