package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25501 {

    public static int n,cnt;
    public static String str;


    public static int recursion(String s, int l, int r) {
        cnt++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        return recursion(s, l + 1, r - 1);
    }
    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            cnt = 0;
            str = br.readLine();
            sb.append(isPalindrome(str)).append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}
