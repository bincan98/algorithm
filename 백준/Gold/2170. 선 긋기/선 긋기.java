import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        });

        int answer = arr[0][1] - arr[0][0];
        int last = arr[0][1];
        for (int i = 0; i < N - 1; i++) {
            if (last <= arr[i+1][0]) {
                answer += (arr[i + 1][1] - arr[i + 1][0]);
                last = arr[i + 1][1];
            } else {
                if (last <= arr[i+1][1]) {
                    answer += arr[i + 1][1] - last;
                    last = arr[i + 1][1];
                }
            }
        }

        System.out.println(answer);

    } // end of main

} // end of class