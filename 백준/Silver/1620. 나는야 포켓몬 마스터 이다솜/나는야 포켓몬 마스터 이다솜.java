import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for (int i = 1; i < N+1; i++) {
			String s = br.readLine();
			map.put(i + "", s);
			map.put(s, i + "");
		}
		
		for (int i = 0; i < K; i++) {
			System.out.println(map.get(br.readLine()));
		}
		
	} // end of main
} // end of class