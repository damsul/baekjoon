package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] c = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            for (char ch : c) {
                if (ch == '(') {
                    stack.push(ch);
                }

                if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isVPS = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                isVPS = false;
            }

            if (isVPS) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

}
