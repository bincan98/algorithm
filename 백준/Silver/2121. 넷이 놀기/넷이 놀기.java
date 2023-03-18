import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  private static int N, A, B;
  private static int[][] arr;
  private static int answer;

  public static void main(String[] args) throws NumberFormatException, IOException {
    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    } // 입력완료

    // 정렬하기
    Arrays.sort(arr, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      } else {
        return o1[0] - o2[0];
      }
    });

    // 모든 점 탐색 (1번 점)
    for (int i = 0; i < N; i++) {
      // 2번점이 있다면
      if (binarySearch(arr[i][0] + A, arr[i][1]))
        // 3번점이 있다면
        if (binarySearch(arr[i][0], arr[i][1] + B))
          // 4번 점이 있다면
          if (binarySearch(arr[i][0] + A, arr[i][1] + B))
            // 직사각형이 완성
            answer++;
    }
    
    System.out.println(answer);

  }

  private static boolean binarySearch(int targetX, int targetY) {
    int start = 0;
    int end = N - 1;
    int mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      if (targetX == arr[mid][0]) { // 목표 x좌표와 같다면
        if (targetY == arr[mid][1]) { // 목표 y좌표와 같은지 보기
          return true;
        } else if (targetY > arr[mid][1]) { 
          start = mid + 1;
        } else if (targetY < arr[mid][1]) {
          end = mid - 1;
        }
      } else if (targetX > arr[mid][0]) {
        start = mid + 1;
      } else if(targetX < arr[mid][0]) {
        end = mid - 1;
      }
    }
    return false;
  } // end of main
} // end of class