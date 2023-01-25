package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298 {

    public static void main(String[] args) throws IOException {
        // 3,5,2,7, -> 5,7,7,-1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && data[stack.peek()] < data[i]) {
                data[stack.pop()] = data[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            data[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(data[i]).append(" ");
        }
        System.out.println(sb);
    }

}
