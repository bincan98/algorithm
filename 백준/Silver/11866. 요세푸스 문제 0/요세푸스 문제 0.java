import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i < N+1; i++) {
			queue.add(i);
		}
		
		int[] answer = new int[N];
		int cnt = 0;
		while (!queue.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				queue.add(queue.poll());
			}
			answer[cnt++] = queue.poll();
		}
		
		String str = "<";
		for (int i = 0; i < answer.length; i++) {
			str = str.concat(answer[i] + ", ");
		}
		str = str.substring(0, str.length()-2);
		str = str.concat(">");
		
		System.out.println(str);
	} // end of main
} // end of class