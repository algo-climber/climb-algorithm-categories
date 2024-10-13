import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17609_회문 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			int cntR = 0;
			int cntL = 0;

			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) == str.charAt(str.length() - 1 - i - cntR)) {
					continue;
				} else {
					cntR++;
					if (cntR == 2) {
						break;
					}
					if (str.charAt(i) == str.charAt(str.length() - 1 - i - cntR)) {
						continue;
					} else {
						cntR++;
						if (cntR == 2) {
							break;
						}
					}
				}

				
			}

			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i + cntL) == str.charAt(str.length() - 1 - i)) {
					continue;
				} else {
					cntL++;
					if (cntL == 2) {
						break;
					}
					if (str.charAt(i + cntL) == str.charAt(str.length() - 1 - i)) {
						continue;
					} else {
						cntL++;
						if (cntL == 2) {
							break;
						}
					}
				}

			}

			sb.append(Math.min(cntR, cntL)).append("\n");
		}

		System.out.println(sb);

	}

}