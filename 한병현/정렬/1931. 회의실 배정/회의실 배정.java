import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 회의의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 회의 시간을 담을 2차원 배열을 선언 및 초기화
		int[][] time = new int[N][2];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 앞쪽이 시작시간, 뒤쪽이 끝나는 시간
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//Arrays.sort는 1차원 배열에서만 잘 작동
		//2차원 배열을 정렬하기 위해서는 별도의 Comparator를 제공해줘야 함
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				
				// 끝나는 시간이 가장 이른것이 유리하므로
				// 끝시간을 기준으로 정렬하기
				// 끝시간이 같다면 시작시간이 작은것을 먼저 정렬
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				
				// 보통의 경우
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		// 0번 회의는 한다는 가정하에 카운팅을 1로 초기화
		// 현재 진행중인 회의를 담을 변수
		int cnt = 1;
		int start = time[0][0];
		int end = time[0][1];
		
		// 반복을 하면서 끝나는 시간이후에 이어 나갈 수 있는 회의를 카운팅
		for(int i = 1; i < N; i++) {
			
			// 현재 인덱스의 시작 시간이 이전 인덱스의 끝 시간보다 작다면 건너뜀
			if(time[i][0] < end) {
				continue;
			}
			
			// 이어질 수 있다면
			// 진행중인 회의로 초기화
			else {
				start = time[i][0];
				end = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
