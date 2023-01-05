package dataStructure.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        String[] sArr = s.split("");
        int sum = 0;

        for (String ss : sArr) {
            sum += getSec(ss) + 1;
        }
        System.out.println(sum);
    }

    public static int getSec(String s) {
        if ("ABC".contains(s)) {
            return 2;
        }
        if ("DEF".contains(s)) {
            return 3;
        }
        if ("GHI".contains(s)) {
            return 4;
        }
        if ("JKL".contains(s)) {
            return 5;
        }
        if ("MNO".contains(s)) {
            return 6;
        }
        if ("PQRS".contains(s)) {
            return 7;
        }
        if ("TUV".contains(s)) {
            return 8;
        }
        if ("WXYZ".contains(s)) {
            return 9;
        }
     return 1;
    }

}
