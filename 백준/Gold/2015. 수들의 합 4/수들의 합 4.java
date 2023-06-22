import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 누적합 그냥 하면?

1부터 j 까지의 누적합 중 k 인것을 알 수 있다

그리고 1 부터 i 까지의 누적합을 다 빼보면?
N^2로 시간 초과다

딕셔너리를 써서 그전의 누적합을 키로 개수를 값으로 해서 갯수를 체크해두자

이번 누적합 - 지난 누적합 = K 가 되야 하므로

이번 누적합 - K 가 키인 값을 answer에 더해주자

이때 defaultdict를 쓰면 키 체크를 하지 않고 편하게 짤 수 있다
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		// 누적합을 저장할 배열
		long[] prefix_sum = new long[N+1];
		
		// 입력과 동시에 누적합 만들기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			prefix_sum[i] = prefix_sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 딕셔너리 만들기
		Map<Long, Long> dict = new HashMap<>();
		
		long answer = 0;
		for (int i = 1; i < N+1; i++) {
			// 아무것도 빼지 않고 가능한 경우 체크해보기
			if (prefix_sum[i] == K) {
				answer++;
			}
			// (이번 누적합 - K)가 키인 값 더해주기 (없다면 0을 더하기)
			answer += dict.getOrDefault(prefix_sum[i] - K, 0L);
			// 이번 누적합을 딕셔너리에 넣어주기 (이미 있다면 카운트 1 더해주기, 없다면 0 넣기)
			long arr=  dict.getOrDefault(prefix_sum[i], 0L) + 1;
			dict.put(prefix_sum[i], dict.getOrDefault(prefix_sum[i], 0L) + 1);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class