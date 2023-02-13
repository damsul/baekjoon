package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 {
    public static int[] dist = new int[100001]; // 거리 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 100000; i++) {
            dist[i] = -1;
        }
        dist[N] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while (dist[K] == -1 && !q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (nxt < 0 || nxt > 100000) {
                    continue;
                }
                if (dist[nxt] >= 0) {
                    continue;
                }
                dist[nxt] = dist[cur] + 1;
                q.add(nxt);
            }
        }

        System.out.println(dist[K]);

    }

}
