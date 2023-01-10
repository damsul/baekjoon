package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] student = new int[2][6];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            student[s][y - 1]++;
        }

        int cnt = 0;
        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student[0].length; j++) {
                // 각 성별 각 학년의 수 마다 방최대수용인원 k를 나눈다.
                cnt += student[i][j] / k;
                if (student[i][j] % k != 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}
