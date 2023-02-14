package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014 {
    public static int[] dist = new int[1000001];
    public static int[] dx;
    public static int F, S, G, U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 빌딩 전체 층 수
        S = Integer.parseInt(st.nextToken()); // 강호 위치 층 수
        G = Integer.parseInt(st.nextToken()); // 스타트링크 위치 층 수
        U = Integer.parseInt(st.nextToken()); // 위층 이동 수
        D = Integer.parseInt(st.nextToken()); // 아래층 이동 수

        dx = new int[]{U, -D};

        Arrays.fill(dist, -1);

        dist[S] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        while (!q.isEmpty() && dist[G] == -1) {
            int cur = q.poll();

//            if (dist[G] >= 0) {
//                System.out.println(dist[G]);
//                return;
//            }

            for (int dir = 0; dir < 2; dir++) {
                int nx = cur + dx[dir];

                if (nx < 1 || nx > F) continue;
                if (dist[nx] >= 0) continue;

                dist[nx] = dist[cur] + 1;
                q.add(nx);
            }
        }
//        System.out.println("use the stairs");

        if (dist[G] >= 0) {
            System.out.println(dist[G]);
        } else {
            System.out.println("use the stairs");
        }
    }

}
