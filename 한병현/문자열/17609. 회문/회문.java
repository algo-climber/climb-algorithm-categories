import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 문자열의 개수
		int T = Integer.parseInt(br.readLine());
		
		// T만큼 반복하여 진행
		for(int tc = 1; tc <= T; tc++){
			
			// 문자열을 입력
			String line = br.readLine();
						
			// 메서드를 사용하여 결과값 저장
			int result = search(line, 0, line.length() - 1, false);
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	// 회문을 판별할 메서드
	static int search(String temp, int f, int e, boolean check) {
		
		while(f < e) {

			// 시작과 끝이 같다면 좁혀가면서 반복
			if(temp.charAt(f) == temp.charAt(e)) {
				f++;
				e--;
			}
			
			// 다른게 나온다면 재귀
			else {
				
				// 이미 한 번 옮겼으면 종료
				if(check) {
					return 2;					
				}
				
				// 재귀에서 더 작은 값으로 가능한 것을 출력
				int result1 = search(temp, f + 1, e, true);
				int result2 = search(temp, f, e - 1, true);
				
				return Math.min(result1, result2);
			}
		}
		
		if(check) return 1;
		else return 0;
	}
}
