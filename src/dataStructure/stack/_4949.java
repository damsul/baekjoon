package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            char[] c = s.toCharArray();

            if (c[0] == '.') {
                break;
            }

            boolean isValid = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '(' || c[i] == '[') {
                    stack.push(c[i]);
                }

                if (c[i] == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
                if (c[i] == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }

}
