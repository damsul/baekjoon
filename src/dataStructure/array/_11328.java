package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11328 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken().toLowerCase();
            String str2 = st.nextToken().toLowerCase();
            System.out.println(strfry(str1, str2));
        }

    }

    public static String strfry(String str1, String str2) {

        int[] alphabet = new int[26];
        for (char c : str2.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : str1.toCharArray()) {
            alphabet[c - 'a']--;
        }

        for (int a : alphabet) {
            if (a != 0) {
                return "Impossible";
            }
        }
        return "Possible";
    }

}
