import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static List<Integer>[] edge;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edge = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edge[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edge[u].add(v);
            edge[v].add(u);
        }

        visited = new boolean[N + 1];
        int cnt_component = 0;
        int cnt_cycle = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                cnt_cycle += bfs(i);
                cnt_component += 1;
            }
        } // end of for i

        System.out.println(cnt_component + cnt_cycle - 1);
        
    } // end of main

    private static int bfs(int start) {
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        q.offer(-1);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int prev = q.poll();
            for (int nxt: edge[cur]) {
                if (nxt == prev) continue;
                if (!visited[nxt]) {
                    q.offer(nxt);
                    q.offer(cur);
                    visited[nxt] = true;
                } else {
                    cnt += 1;
                }
            }
        }

        return cnt / 2;
    } // end of bfs
} // end of class