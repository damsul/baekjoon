package algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2490 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            int sum = 0;

            for (int j = 0; j < arr.length; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            String result = "";
            if (sum == 0) {
                result = "D";
            } else if (sum == 1) {
                result = "C";
            } else if (sum == 2) {
                result = "B";
            } else if (sum == 3) {
                result = "A";
            } else if (sum == 4) {
                result = "E";
            }
            System.out.println(result);
        }

    }

}
