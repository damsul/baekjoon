package algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = midNum(a, b, c);
        System.out.println(result);
    }

    public static int midNum(int a, int b, int c) {
        if (a > b) {
            if (b >= c) {
                return b;
            } else {
                if (a > c) {
                    return c;
                } else {
                    return a;
                }
            }
        } else {
            if (a > c) {
                return a;
            } else {
                if (b > c) {
                    return c;
                } else {
                    return b;
                }
            }
        }
    }

}
