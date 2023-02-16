package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780 {
    public static int N;
    public static int[][] board = new int[2200][2200];
    public static int[] cnt = new int[3];

    // 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
    // 2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고,
    // 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
    public static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void solve(int x, int y, int z) {
        if (check(x, y, z)) {
            cnt[board[x][y] + 1]++;
            return;
        }

        int n = z / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
        for (int n : cnt) {
            System.out.println(n);
        }
    }


    /*public static int N;
    public static int[][] board = new int[2200][2200];
    public static int[] cnt = new int[3];

    public static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solve(int x, int y, int z) {
        // base condition
        if (check(x, y, z)) {
            cnt[board[x][y] + 1] += 1;
            return;
        }

        // 재귀식
        int n = z / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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

        // 재귀함수
        solve(0, 0, N);
        for (int num : cnt) {
            System.out.println(num);
        }
    }*/
}
