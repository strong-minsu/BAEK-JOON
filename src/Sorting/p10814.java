package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//나이순 정렬
public class p10814 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        String [][] age_name = new String[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            age_name[i][0] = st.nextToken(); //나이
            age_name[i][1] = st.nextToken(); //이름
        }

        //나이만 정렬
        Arrays.sort(age_name, new Comparator<String[]>() {
            @Override
            public int compare(String[]o1, String[]o2) {
                //첫번째 스트링(나이) 기준으로 오름차순 정렬
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        }
        );

        for(int i = 0; i < N; i++) {
            sb.append(age_name[i][0]);
            sb.append(" ");
            sb.append(age_name[i][1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
