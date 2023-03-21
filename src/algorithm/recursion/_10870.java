package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10870 {

    static int n;

    static int func(int k) {
        if (k == 0) return 0;
        else if (k == 1) return 1;

        return func(k - 1) + func(k - 2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(func(n));
    }

}
