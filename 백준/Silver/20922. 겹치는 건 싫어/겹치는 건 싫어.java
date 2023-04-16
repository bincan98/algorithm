import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  private static int N, K;
  private static int[] arr, check;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[N + 1];
    check = new int[100_001]; // 수를 넣어가면서 K가 넘었는지 체크할 배열

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < N+1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    } // 입력완료

    int answer = 0; // 정답
    // 초기값 넣기
    int start = 1;
    int end = 1;
    check[arr[end]]++;

    while (true) {
      if (check[arr[end]] <= K) { // 새로 넣은 수가 K개를 넘지 않았다면 
        answer = Math.max(answer, end - start + 1); // 정답에 현재 길이 넣어주기
        end++; // 엔드 포인터 증가시키기
        if (end > N) // 배열을 벗어났다면 종료
          break;
        else // 배열을 벗어나지 않았다면
          check[arr[end]]++; // 엔드 포인터의 개수 1 증가시키기
      } else { // 새로넣은 수가 K개를 넘었다면
        check[arr[start]]--; // 스타트 포인터의 개수 감소시키기
        start++; // 스타트 포인터 증가시키기
      }
    }

    System.out.println(answer);

  } // end of main
} // end of class