package dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;

public class _11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int L = Integer.parseInt(str1[1]);

        String[] data = br.readLine().split(" ");
        LinkedList<Integer> A = new LinkedList<>(); // data
        LinkedList<Integer> D = new LinkedList<>(); // i-L+1 ~ i 중의 최솟값

        /**
         * 0 = 0-3+1(-2) ~ 0    0
         * 1 = 1-3+1(-1) ~ 1    01
         * 2 = 2-3+1(+0) ~ 2    012
         * 3 = 3-3+1(+1) ~ 3    123
         * 4 = 4-3+1(+2) ~ 4    234
         * 5 = 5-3+1(+3) ~ 5    345
         * 6 = 6-3+1(+4) ~ 6    456
         * 7 = 7-3+1(+5) ~ 7    567
         * 8 = 8-3+1(+6) ~ 8    678
         * 9 = 9-3+1(+7) ~ 9    789
         * 10 = 10-3+1(+8) ~ 10
         * 11 = 11-3+1(+9) ~ 11
         * 12 = 12-3+1(+10) ~ 12
         */

        for (int i = 0; i < N; i++) {
            A.addLast(Integer.parseInt(data[i]));
            int min = Integer.MAX_VALUE;

            for (int j = i - L + 1; j <= i; j++) {
                if (j < 0) {
                    continue;
                }
                if (Integer.parseInt(data[j]) < min) {
                    min = Integer.parseInt(data[j]);
                }
            }

            D.addLast(min);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(D.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }

}
