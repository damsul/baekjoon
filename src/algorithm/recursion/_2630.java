package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
    public static int N;
    public static int[][] board = new int[130][130];
    public static int[] cnt = new int[2]; // 하얀색 : 0, 파랑색 : 1

    // 1780 문제와 비슷함
    // (1) 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
    // (2) (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고,
    // 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.

    // (1) 전체 종이가 모두 같은 색이 아니면
    // 가로 세로 중간 부분을 잘라서 네 개의 n/2 * n/2 색종이로 나눈다.
    // (2) 나누어진 종이 I, II, III, IV 각각에 대해서도 (1)과 같다면
    // , (1)의 과정을 반복해 똑같은 크기의 네 개의 색종이로 나눈다
    public static boolean check(int x, int y, int z) {
        for (int i = x; i < x + z; i++) {
            for (int j = y; j < y + z; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void solve(int x, int y, int z) {
        if (check(x,y,z)) {
            cnt[board[x][y]]++;
            return;
        }

        int n = z / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(x + i * n, y + j * n, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);
        for (int num : cnt) {
            System.out.println(num);
        }
    }

    // 다른 풀이
/*    public static void fn(int n , int y , int x ) {

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x+n; j++) {
                if(arr[i][j] != arr[y][x]) {
                    fn(n / 2 , y , x);
                    fn(n / 2 , y + n/2 , x);
                    fn(n / 2 , y , x + n/2);
                    fn(n / 2 , y + n/2 , x + n/2);

                    return;
                }
            }
        }

        if(arr[y][x] == 1) blue++;
        else white++;
    }*/
}
