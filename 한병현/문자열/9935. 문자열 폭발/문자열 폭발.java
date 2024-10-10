import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 초기 문자열
		String line = br.readLine();
		
		// 폭발 문자열
		String bomb = br.readLine();
		
		// 사용할 스택과 임시저장할 스택을 선언
		Stack<Character> stack = new Stack<>();
		
		// 문자열 길이만큼 반복
		for(int i = 0; i < line.length(); i++) {
			
			// 우선 문자를 삽입
			stack.push(line.charAt(i));
			
			// 만약 현재 삽입된 문자가 폭발 문자열의 마지막 문자와 같다면 확인
			// 다르다면 그대로 진행
			// 스택 사이즈가 폭탄보다 클 때 진행
			if(stack.size() >= bomb.length()) {
				
				if(stack.peek() == bomb.charAt(bomb.length() - 1)) {
					
					int idx = stack.size() - 1;
					
					// 폭탄 문자열 길이만큼 반복
					for(int j = bomb.length() - 1; j >= 0; j--) {
						
						// 꺼낸 문자와 폭탄 문자 인덱스가 같다면 꺼내서 임시 스택에 저장
						if(stack.get(idx) == bomb.charAt(j)) {
							
							// 끝까지 같다면
							if(j == 0) {
								for(int k = 0; k < bomb.length(); k++) {
									stack.pop();
								}
							}
							
							else {
								idx--;
								continue;
							}
						}
						
						// 다르다면 종료
						else {
							break;
						}
					}
				}
			}
		}
		
		// 스택이 비어있다면 FRULA를 출력
		if(stack.size() == 0) {
			sb.append("FRULA");
		}
		
		// 아니라면 문자열로 변환하여 출력
		else {
			for(int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		System.out.println(sb);
	}
}
