package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());

        long result = a * b * c;
        String s = Long.toString(result);
        char[] chars = s.toCharArray();
        int[] numCnt = new int[10];

        for (char ch : chars) {
            int n = ch - '0';
            numCnt[n]++;
        }

        for (int n : numCnt) {
            System.out.println(n);
        }

    }

}
