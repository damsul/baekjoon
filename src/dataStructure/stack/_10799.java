package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] pipe = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < pipe.length; i++) {
            if (pipe[i] == '(') {
                stack.push(pipe[i]);
            }

            if (pipe[i] == ')') {
                stack.pop();

                if (pipe[i - 1] == '(') {
                    sum += stack.size();
                } else {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }

}
