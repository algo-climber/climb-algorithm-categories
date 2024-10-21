import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main14 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// BOJ_1931 회의실 배정
		// 한 개의 회으실을 시간이 겹치지 않게 가장 많이 이용할 수 있는 횟수를 구하라.
		// 회의의 시작과 끝이 같을수도 있다.
		// 회의의 종료와 동시에 다음 회의를 시작할 수 있다.
		// 회의의 끝나는 시간을 오름차순으로 정렬하고
		// 가장 빨리 끝나는 회의를 기준으로 가장 가까운 시작시간을 가진 회의를 한다.
		// 회의 종료 -> 가장 가까운 회의 시작 시간 -> 회의 종료 -> 가장 가까운 회의 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 만약 두번째 인덱스가 같을 경우 첫번째 인덱스가 낮은것이 먼저.
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		int cnt = 0;
		int end = 0;
		// 끝나는 시간에서 다음 시작시간이 현재 끝나는 시간과 같거나 큰거랑
		for (int i = 0; i < N; i++) {
			if (arr[i][0] >= end) {
				end = arr[i][1];
				cnt++;
			}
		}
//		for (int[] i : arr) {
//			System.out.println(Arrays.toString(i));
//		}
		System.out.println(cnt);
	}
}
