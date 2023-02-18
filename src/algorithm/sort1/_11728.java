package algorithm.sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11728 {
    public static int N, M;
    public static int[] a = new int[1000001];
    public static int[] b = new int[1000001];
    public static int[] c = new int[2000001];
    public static int aIdx, bIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // a 배열 크기
        M = Integer.parseInt(st.nextToken()); // b 배열 크기

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // a 배열 입력
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) { // b 배열 입력
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N + M; i++) {
            if (aIdx == N) c[i] = b[bIdx++];
            else if (bIdx == M) c[i] = a[aIdx++];
            else if (a[aIdx] <= b[bIdx]) c[i] = a[aIdx++];
            else c[i] = b[bIdx++];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(c[i]).append(" ");
        }
        System.out.println(sb);
    }
}
