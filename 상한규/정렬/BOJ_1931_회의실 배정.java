import java.io.*;
import java.util.*;

public class Main {
	static class Times {
		int start;
		int end;
		
		public Times(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return start + " " + end;
		}
	}
	
	public static void main(String[] args) throws Exception {		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int result = 0;
	    int current = 0;
	    Times[] array = new Times[N];
	    Times[] resultArray = new Times[N];
	    
	    for(int i = 0; i < N; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int startTime = Integer.parseInt(st.nextToken());
	    	int endTime = Integer.parseInt(st.nextToken());
	    	
	    	Times time = new Times(startTime, endTime);
	    	array[i] = time;
	    }
	    Arrays.sort(array, (t1, t2) -> t1.end - t2.end != 0 ? t1.end - t2.end : t1.start - t2.start);
	    
	    for(int i = 0; i < N; i++) {
	    	if(array[i].start >= current) {
	    		current = array[i].end;
	    		resultArray[result] = array[i];
	    		result++;
	    	}
	    }
	    System.out.println(result);
	}
}