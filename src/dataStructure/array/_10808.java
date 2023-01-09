package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] alphabet = new char[26];
        char[] cArr = s.toCharArray();

        for (char c : cArr) {
            alphabet[c - 'a']++;
        }

        for (int n : alphabet) {
            System.out.print(n + " ");
        }
    }

}
