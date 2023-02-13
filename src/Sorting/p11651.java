package Sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p11651 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        int [][] xy = new int[N][2];

        int x,y;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            xy[i][0] = x;
            xy[i][1] = y;
        }

        Arrays.sort(xy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 2차원 배열 정렬 1번 열 먼저 비교-> 0번 열 중심으로 배열 정렬
                if(o1[1] == o2[1]){ // 1번째 열이 같은 경우
                    return o1[0] - o2[0]; // 오름 차순 정렬 o1[0]과 o2[0]중 오름 차순 정렬 후 리턴
                }
                else{
                    return o1[1] - o2[1]; // 오름 차순 정렬 o1[1]과 o2[1]중 오름 차순 정렬 후 리턴
                }
            }
        });
        for(int i=0; i<N; i++){
            sb.append(xy[i][0]).append(" ").append(xy[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}
