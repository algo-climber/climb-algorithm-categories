package 정렬;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.Comparator;
	import java.util.StringTokenizer;

	public class BJ_1931_회의실배정 {
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;

			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][2];

			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] != o2[1]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}
			});

			int count = 1;
			int tmp = arr[0][1];

			for (int i = 1; i < N; i++) {
				if (tmp <= arr[i][0]) {
					tmp = arr[i][1];
//					System.out.println(tmp);
					count++;
				}
			}

			System.out.println(count);
		}
	}
