import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  private static int N;
  private static int[] arr;
  private static int max;
  private static int answer;

  public static void main(String[] args) throws NumberFormatException, IOException {
    N = Integer.parseInt(br.readLine());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int ele = Integer.parseInt(st.nextToken());
      arr[i] = ele;
      // end로 쓸 max값 저장해두기
      max = Math.max(max, ele);
    }

    binarySearch(1, max);

    System.out.println(answer);
  } // end of main

  private static void binarySearch(int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      boolean isPossible = false; // mid*mid 정사각형을 만드는게 가능한지
      int cnt = 0; // mid짜리 막대 개수 세기
      for (int i = 0; i < N; i++) {
        if (arr[i] >= mid) { // mid 이상이라면 cnt 1 추가
          cnt++;
        } else { // 한번이라도 만족하지 못하면 초기화하기
          cnt = 0;
        }
        if (cnt >= mid) { // 정사각형이 완성된 경우
          isPossible = true;
          break;
        }
      }
      if (isPossible) { // 정사각형 만들기가 가능하다면
        answer = mid; // 값을 저장해두고
        start = mid + 1; // 더 큰값 해보기
      } else { // 정사각형 만들기가 불가능하다면
        end = mid - 1; // 더 작은 값 해보기
      }
    }
  }
} // end of class