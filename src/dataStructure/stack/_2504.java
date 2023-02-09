package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int num = 1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                num *= 2;
                stack.push(c[i]);
            } else if (c[i] == '[') {
                num *= 3;
                stack.push(c[i]);
            } else if (c[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                }
                if (c[i - 1] == '(') {
                    sum += num;
                }
                num /= 2;
                stack.pop();
            } else if (c[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                }
                if (c[i - 1] == '[') {
                    sum += num;
                }
                num /= 3;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            sum = 0;
        }

        System.out.println(sum);
    }

}
