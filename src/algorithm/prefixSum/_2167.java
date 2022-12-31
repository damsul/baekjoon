package algorithm.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2167 {

    public static void main(String[] args) throws IOException {
        int n, m, k, i, j, x, y;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];
        int[][] psum = new int[n + 1][m + 1];

        for (int a = 1; a <= n; a++) {
            st = new StringTokenizer(br.readLine());

            for (int b = 1; b <= m; b++) {
                arr[a][b] = Integer.parseInt(st.nextToken());
                psum[a][b] = psum[a][b - 1] + psum[a - 1][b] - psum[a - 1][b - 1] + arr[a][b];
            }
        }

        st = new StringTokenizer(br.readLine());
        k =  Integer.parseInt(st.nextToken());

        for (int l = 0; l < k; l++) {
            st = new StringTokenizer(br.readLine());
            i =  Integer.parseInt(st.nextToken());
            j =  Integer.parseInt(st.nextToken());
            x =  Integer.parseInt(st.nextToken());
            y =  Integer.parseInt(st.nextToken());

            int sum = psum[x][y] - psum[x][j - 1] - psum[i - 1][y] + psum[i - 1][j - 1];
            System.out.println(sum);
        }
    }

}
