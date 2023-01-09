package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] num = new int[10];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - '0']++;
        }

        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (i == 6) {
                continue;
            }
            if (i == 9) {
                num[i] = (int)Math.ceil((double) (num[i] + num[6] )/ 2);
            }
            max = Math.max(max, num[i]);
        }
        System.out.println(max);
    }
}
