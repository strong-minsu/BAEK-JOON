package Greedy;

import java.io.*;
import java.util.*;

//센서
public class p2212 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if(k >= n){
            bw.write(0+"");
            bw.flush();
            bw.close();
            return;
        }

        int[] array = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }

        Arrays.sort(array);
        Integer[] sumArray = new Integer[n-1];

        for (int i = 0; i < n-1; i++) {
            sumArray[i] = array[i+1] - array[i];
        }

        //sumArray인 경우.........
        Arrays.sort(sumArray, Collections.reverseOrder());
        int result = 0;

        for (int i = k-1; i < n-1; i++) {
            result += sumArray[i];
        }

        bw.write(result +"");
        bw.flush();
        bw.close();

    }
}
