package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4779 {

    public static int n, length;
    public static char[] ch;
    public static void func(int st, int size) {
        if (size == 1) return;

        int ns = size / 3;
        for (int i = st + ns; i < st + 2 * ns; i++) {
            ch[i] = ' ';
        }

        func(st, ns);
        func(st + 2 * ns, ns);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            n = Integer.parseInt(s);
//        1. -가 3^N개 있는 문자열에서 시작한다.
//        2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
//        3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.
            int size = (int) Math.pow(3, n);
            ch = new char[size];
            for (int i = 0; i < size; i++) {
                ch[i] = '-';
            }
            func(0, size);
            System.out.println(ch);
        }
    }

}
