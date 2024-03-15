package Sorting;

import java.util.*;
import java.io.*;

//두 용액
//같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다.
//이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.
public class p2470 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }

        //정렬을 먼저 진행해 줍니다.
        Arrays.sort(array);

        //투포인터 방법으로 진행
        //i, j이렇게 두 개 포인터를 잡습니다.
        //i = 0부터
        //j = n-1부터?

        //i와 j를 옮기는 조건이 뭘까?
        //0에서.... 옮기자..!
        //array[i] + array[j]의 절대값이 result값보다 작을 경우 갱신

        int start = 0, end = n-1;
        int result = Integer.MAX_VALUE;

        int[] res = new int[2];
        while (start < end){
            int sum = array[start] + array[end];

            if(result > Math.abs(sum)){
                result = Math.abs(sum);
                res[0] = array[start];
                res[1] = array[end];

                if(result == 0) break;
            }

            if(sum < 0){
                start++;
            }
            else{
                end--;
            }
        }

        bw.write(res[0] +" "+res[1]);
        bw.flush();
        bw.close();
    }
}
