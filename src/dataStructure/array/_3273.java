package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n 입력
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // x 입력
        int x = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int find = x - arr[i];
            int left = i + 1;
            int right = n - 1;

            while (left <= right) {
                int mid = (right + left) / 2;
                if (arr[mid] == find) {
                    cnt++;
                }

                if (arr[mid] <= find) {
                    left = mid + 1;
                    continue;
                }
                if (arr[mid] > find) {
                    right = mid - 1;
                }

            }

        }

        System.out.println(cnt);
    }


    /*public static void search2() {
        while (front < rear){

            if(arr[front] + arr[rear] == X){
                cnt++;
                front++;
                rear--;
            }else if(arr[front] + arr[rear] > X){
                rear--;
            }else{
                front++;
            }
        }
    }*/
}
