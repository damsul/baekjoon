package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine().toLowerCase();
        String str2 = br.readLine().toLowerCase();

        int[] alphabet = new int[26];
        for (char c : str1.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            alphabet[c - 'a']--;
        }

        int cnt = 0;
        for (int n : alphabet) {
            if (n != 0) {
                cnt += Math.abs(n);
            }
        }
        System.out.println(cnt);
    }
}
