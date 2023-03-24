package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889 {

    public static int n;
    public static int[][] board = new int[25][25];
    public static boolean[] visit = new boolean[25];
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 총 인원수 입력
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        // 능력치 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 두 팀으로 나누기
        func(1, 0);
        System.out.println(min); // 능력치 차이 최소값 출력
    }

    static void func(int idx, int k) {
        // 팀 A 체크가 완료되면
        if (k == n / 2) {
            // 각 팀 능력치 차 구하기
            diff();
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (visit[i]) continue; // 팀 A에 속해 있다면 다음 반복 시작
            visit[i] = true; // 팀 A 체크
            func(i + 1, k + 1); // 두 팀으로 나누기
            visit[i] = false; // 재귀 호출이 완료되면 팀 A 해제
        }
    }

    static void diff() {
        int teamA = 0; // 팀 A 능력치
        int teamB = 0; // 팀 B 능력치

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // 팀 A = true, 팀 B = false
                // 팀 A에 속해 있다면 팀 A 능력치 증가
                if (visit[i] && visit[j]) {
                    teamA += board[i][j];
                    teamA += board[j][i];
                }
                // 팀 B에 속해 있다면 팀 B 능력치 증가
                else if (!visit[i] && !visit[j]) {
                    teamB += board[i][j];
                    teamB += board[j][i];
                }
            }
        }

        // 각 팀 능력치 차이 구하기
        int abs = Math.abs(teamA - teamB);
        // 능력치 차이 최소값 구하기
        min = Math.min(min, abs);
    }
}
