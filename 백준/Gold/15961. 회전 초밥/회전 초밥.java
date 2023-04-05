import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, d, k, c;
	private static int[] arr;
	private static int[] kind;
	private static int cnt;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N + k];
		kind = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			int ele = Integer.parseInt(br.readLine());
			arr[i] = ele;
		} // 입력완료
		
		for (int i = N, j = 0; i < N+k; j++, i++) {
			arr[i] = arr[j];
		} // 회전을 고려해서 더넣어주기
		
		// 첫번째 수열 초밥 개수 구하기
		TreeSet<Integer> set = new TreeSet<>(); 
		for (int i = 0; i < k; i++) {
			kind[arr[i]]++;
			set.add(arr[i]);
		}
		cnt = set.size();
		
		// 쿠폰 초밥이 없었다면 cnt에 1 추가해서 더해주기
		if(kind[c] == 0) answer = Math.max(answer, cnt+1);
		
		for (int i = k; i < N+k; i++) { // 두번쨰 수열부터 마지막까지 전부해주기
			// 전 수열의 제일 앞 초밥을 빼주면서 양수에서 0이 되었는지 체크하기 (지금 0이라면 그전에 1이었다는 의미)
			// 0이 되었다면 개수 빼주기
			if(--kind[arr[i-k]] == 0) cnt--;
			// 수열에 초밥을 추가해주면서 0에서 양수가 되었는지 체크하기 (지금 1이라면 그전은 0이었다는 의미
			// 양수가 되었다면 개수 추가해주기
			if(++kind[arr[i]] == 1) cnt++;
			// 쿠폰 초밥이 없었다면 cnt에 1 추가해서 더해주기
			if(kind[c] == 0) answer = Math.max(answer, cnt+1);
			else answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class