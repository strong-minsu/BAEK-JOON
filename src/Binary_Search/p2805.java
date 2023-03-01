package Binary_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나무 자르기
public class p2805 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long tree[] = new long[N];
        long max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            long number = Long.parseLong(st.nextToken());
            tree[i] = number;
            if (max < number) {
                max = number;
            }
        }
        //절단기 설정 길이 값을 최대길이 +1로 잡아야함
        max++;
        long min = 0;
        long mid = 0;
        //절단기에 설정하는 길이 자체를 가지고 binary search..

        while(min < max){
            mid = (max+min) / 2;

            long H=0;   //잘랐을 때 구해지는 길이
            for(int i=0; i<N; i++){
                if(tree[i]- mid > 0){
                    H += (tree[i]-mid);
                }
            }
            //구해진 길이가 원하는 길이보다 작을 경우 잘라지는 길이가 많아지도록 max를 줄인다
            if(H < M){
                max = mid;
            }
            //구해진 길이가 원하는 길이보다 클 경우 잘라지는 길이가 줄어들도록 min값을 늘린다.
            else{
                min  = mid + 1;
            }
        }
        System.out.print(min-1);
    }
}
