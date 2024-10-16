import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 입력받을 문자열의 개수
        StringBuilder sb = new StringBuilder();   // 결과를 저장할 StringBuilder
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();  // 각 문자열 입력 받기
            sb.append(checkPalindrome(str)).append("\n");  // 회문 검사 결과를 StringBuilder에 추가
        }
        System.out.print(sb);  // 최종 결과 출력
    }

    static int checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;  // 문자열의 양 끝에서 시작

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                // 문자가 다른 경우, 유사회문 검사 실행
                if (isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1)) {
                    return 1;  // 유사회문인 경우
                } else {
                    return 2;  // 회문도 유사회문도 아닌 경우
                }
            }
            left++;
            right--;  // 양쪽에서 중앙으로 이동
        }
        return 0;  // 완전한 회문인 경우
    }

    static boolean isPalindrome(String str, int left, int right) {
        // 주어진 범위 내에서 회문 여부를 확인하는 메소드
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;  // 문자가 다르면 회문이 아님
            }
            left++;
            right--;  // 양쪽에서 중앙으로 이동
        }
        return true;  // 모든 문자가 대칭이면 회문
    }
}