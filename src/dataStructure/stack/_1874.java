package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int start = 0;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            for (int i = start + 1; i <= num; i++) {
                stack.push(i);
                sb.append("+").append("\n");
            }
            if (start < num) {
                start = num;
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }

}
