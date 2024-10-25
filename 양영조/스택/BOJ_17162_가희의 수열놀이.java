import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17 {
	public static void main(String[] args) throws IOException {
		// 17162 가희의 수열놀이
		// 쿼리 1 : 맨 뒤에 추가.
		// 쿼리 2 : 맨 뒤의 원소 제거, 비어있다면 무시
		// 쿼리 3 : 조가희가 요구하는 쿼리에 대한 값을 계산.
		// 수열 arr의 맨 뒤에서부터 최소 몇 개의 수를 선택해야
		// 이들을 mod로 나누었을때 나머지가 0,...mod-1인 경우가 최소 한번 이상 나타날까??
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Q = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());

			if (query == 1) {
				// 쿼리 1: 숫자 추가
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			} else if (query == 2 && !list.isEmpty()) {
				// 쿼리 2: 마지막 숫자 제거
				list.remove(list.size() - 1);
			} else if (query == 3) {
				// 쿼리 3: 조건을 만족하는 최소 개수 찾기
				if (list.size() < mod) {
					sb.append(-1).append("\n");
					continue;
				}

				// 배열을 사용하여 나머지 카운트
				int[] count = new int[mod]; // 나머지 카운트를 위한 배열
				int distinctCount = 0; // 현재 나머지의 종류 수
				int minLength = Integer.MAX_VALUE; // 최소 길이 초기화
				int left = 0; // 슬라이딩 윈도우의 왼쪽 포인터

				// 오른쪽 포인터를 통해 수열 탐색
				for (int right = 0; right < list.size(); right++) {
					int remainder = list.get(right) % mod; // 현재 원소의 나머지

					// 현재 나머지가 처음 등장한 경우
					if (count[remainder] == 0) {
						distinctCount++; // 새로운 나머지 종류 증가
					}
					count[remainder]++; // 해당 나머지 카운트 증가

					// 모든 나머지가 포함될 때까지 왼쪽 포인터 이동
					while (distinctCount == mod) {
						// 현재 구간의 길이를 최소값과 비교
						minLength = Math.min(minLength, right - left + 1);
						int leftRemainder = list.get(left) % mod; // 왼쪽 포인터의 나머지
						count[leftRemainder]--; // 왼쪽 포인터의 나머지 카운트 감소

						// 왼쪽 포인터의 나머지가 더 이상 존재하지 않게 되면
						if (count[leftRemainder] == 0) {
							distinctCount--; // 나머지 종류 수 감소
						}
						left++; // 왼쪽 포인터 이동
					}
				}

				// 결과를 StringBuilder에 추가
				sb.append(minLength == Integer.MAX_VALUE ? -1 : minLength).append("\n");
			}
		}
		System.out.print(sb);
	}

}
