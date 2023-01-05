package algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int cnt = 0;
        while (n-- > 0) {
            String[] sArr = br.readLine().split("");
            Set<String> set = new HashSet<>();
            boolean flag = true;

            for (int i = 0; i < sArr.length; i++) {
                if (set.contains(sArr[i])) {
                    if (!sArr[i - 1].equals(sArr[i])) {
                        flag = false;
                        break;
                    }
                    continue;
                }
                set.add(sArr[i]);
            }

            if (flag) {
                cnt++;
            }

        }
        System.out.println(cnt);
    }

}
