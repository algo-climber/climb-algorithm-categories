import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
[문제 링크]
- https://www.acmicpc.net/problem/5568
*/

/*
[문제 정리]
- 1 초 / 256 MB

- n장의 카드
- 각 카드 숫자의 범위는 1 이상 99 이하

- k장의 카드 선택하여, 정수 생성

- 만들 수 있는 정수의 가지수 구하기

- 같은 숫자가 적힌 카드가 여러 개 존재할 수 있음.
*/

public class BOJ_5568_카드_놓기 {
	
	static BufferedReader br;
	
	static int N; // 카드의 개수 (4 <= N <= 10)
	static int K; // 선택할 카드의 개수 (2 <= K <= 4)
	
	static int[] CARDS;
	
	static int[] selectedCards;
	
	static Set<String> numbers; // 만들어진 숫자
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		CARDS = new int[N];
		
		for (int i = 0; i < N; i++) {
			CARDS[i] = Integer.parseInt(br.readLine());
		}
		
		// --------------------- input ---------------------
		
		Arrays.sort(CARDS);
		
		selectedCards = new int[K];
		numbers = new HashSet<>();
		
		makeNumber(0, 0);
		
		System.out.println(numbers.size());
		
	}
	
	
	// idx: selectedCards 배열의 인덱스
	// count: 선택한 카드의 수
	static void makeNumber(int idx, int visited) {
		
		// 기저 조건
		if (idx == K) {		
			convertNum();
			
			return;
		}
		
		// 재귀 부분
		int prev = -1;
		
		for (int i = 0; i < N; i++) {
			
			if ((visited & (1 << i)) != 0 || prev == CARDS[i]) continue;
			
			prev = CARDS[i];
			
			selectedCards[idx] = CARDS[i];
			makeNumber(idx + 1, visited | 1 << i);
			
		}
		
	}
	
	static void convertNum() {
		
		String num = "";
		
		for (int elem: selectedCards) {
			num += elem;
		}
		
		numbers.add(num);
		
	}
	
}