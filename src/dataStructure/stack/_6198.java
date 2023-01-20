package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= height) {
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(height);
            cnt += stack.size() - 1;
        }

        System.out.println(cnt);



        /*for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int height = arr[i];

            for (int j = i + 1; j <= n; j++) {
                if (height > arr[j]) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);*/
    }
}
