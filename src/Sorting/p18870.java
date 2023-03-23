package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

//좌표 압축
public class p18870 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int array[] = new int[N];
        int sorted_array[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
            sorted_array[i] = num;
        }

        Arrays.sort(sorted_array);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = sorted_array[i];
            if(!hashMap.containsKey(num)){
                hashMap.put(num, count);
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            int num = array[i];
            sb.append(hashMap.get(num)).append(" ");
        }
        System.out.print(sb);
    }
}
