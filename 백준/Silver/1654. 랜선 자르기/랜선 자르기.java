import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  private static int K, N;
  private static int[] arr;
  private static int max;
  private static long answer;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new int[K];
    for (int i = 0; i < K; i++) {
      int ele = Integer.parseInt(br.readLine());
      arr[i] = ele;
      max = Math.max(max, ele);
    } // 입력완료

    binarySearch(N, 1, max);

    System.out.println(answer);
  } // end of main

  private static void binarySearch(int targetN, long start, long end) {
    while (start <= end) {
      long mid = (((long) start + end) / 2);
      int result = 0;
      // 몇개의 랜선이 나오는지 구현해보기
      for (int i = 0; i < K; i++) {
        result += arr[i] / mid;
      }
      // 랜선이 목표치보다 많거나 같게 나오면 랜선의 길이를 올려서 다시해보기
      if (result >= targetN) {
        answer = mid;
        start = mid + 1;
      } else if (result < targetN) { // 랜선이 목표치보다 적다면 랜선의 길이를 줄여보기
        end = mid - 1;
      }
    }
  }
} // end of class