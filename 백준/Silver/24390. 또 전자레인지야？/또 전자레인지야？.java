import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), ":");

        int target = 0;
        target += Integer.parseInt(st.nextToken()) * 60;
        target += Integer.parseInt(st.nextToken());

        System.out.println(bfs(target));

    } // end of main

    private static int bfs(int target) {
        int[] dx = new int[] {10, 60, 600};

        int[][] time = new int[3601][2];

        for (int i = 0; i < 3601; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new ArrayDeque<>();

        time[0][0] = 0;
        q.add(new int[] {0, 0});

        time[30][1] = 1;
        q.add(new int[] {30, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[1] == 0) {
                if (time[cur[0]][1] > time[cur[0]][0] + 1) {
                    time[cur[0]][1] = time[cur[0]][0] + 1;
                    q.add(new int[] {cur[0], 1});
                }
            } else {
                if (cur[0] + 30 > 3600) continue;
                if (time[cur[0] + 30][1] > time[cur[0]][1] + 1) {
                    time[cur[0] + 30][1] = time[cur[0]][1] + 1;
                    q.add(new int[] {cur[0] + 30, 1});
                }
            }
            for (int nxt: dx) {
                if (cur[0] + nxt > 3600) continue;
                if (time[cur[0] + nxt][cur[1]] > time[cur[0]][cur[1]] + 1) {
                    time[cur[0] + nxt][cur[1]] = time[cur[0]][cur[1]] + 1;
                    q.add(new int[] {cur[0] + nxt, cur[1]});
                }
            }
        }

        return time[target][1];
    }

} // end of class