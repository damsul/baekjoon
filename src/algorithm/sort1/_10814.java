package algorithm.sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10814 {
    public static int N;
    public static String[][] board = new String[100001][2];
    public static String[][] tmp = new String[100001][2];

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid;

        for (int i = st; i < en; i++) {
            if (right == en) tmp[i] = board[left++];
            else if (left == mid) tmp[i] = board[right++];
            else if (Integer.parseInt(board[left][0]) <= Integer.parseInt(board[right][0]))
                tmp[i] = board[left++];
            else tmp[i] = board[right++];
        }
        for (int i = st; i < en; i++) {
            board[i] = tmp[i];
        }
    }
    public static void mergeSort(int st, int en) {
        if (en - st == 1) return;

        int mid = (st + en) / 2;

        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            board[i][0] = age;
            board[i][1] = name;
        }

        mergeSort(0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(board[i][0]).append(' ').append(board[i][1]).append('\n');
        }
        System.out.println(sb);

    }
}
