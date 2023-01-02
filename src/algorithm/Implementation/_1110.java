package algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int num = input;
        int count = 0;

        do {
            int a = num % 10; // 6
            int b = num / 10 + a; // 8
            num = a * 10 + b % 10;
            count++;

        } while (input != num);
        System.out.println(count);

    }

}
