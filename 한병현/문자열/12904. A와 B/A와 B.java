import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기 문자
		String start = br.readLine();
		
		// 만드려는 문자
		String end = br.readLine();
		
		// end를 넣어줌
		StringBuilder sb = new StringBuilder(end);		
		
		// 삭제해 나가는 반복문
		// 초기 문자보다 길때까지 반복
		while(sb.length() > start.length()) {
			
			// 끝 문자가 A면 그냥 제거
			if(sb.charAt(sb.length() - 1) == 'A') {
				sb.deleteCharAt(sb.length() - 1);
			}
			
			// 끝 문자가 B면 제거 후 뒤집기
			else if(sb.charAt(sb.length() - 1) == 'B') {
				sb.deleteCharAt(sb.length() - 1);
				sb.reverse();
			}
		}
		
		// 작업 후 초기 문자와 같다면 가능함
		if((sb + "").equals(start)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
