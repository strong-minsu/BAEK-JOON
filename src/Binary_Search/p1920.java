package Binary_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수 찾기
public class p1920 {
    static int binarySearch(int array[], int number){
        int max_index = array.length-1;
        int min_index = 0;
        int mid = (max_index+min_index) / 2;
        while (min_index <= max_index){
            if(array[mid] == number){
                return 1;
            }
            else if(array[mid]>number){
                max_index = mid-1;
            }
            else if (array[mid]<number) {
                min_index = mid+1;
            }
            mid = (max_index+min_index) / 2;
        }
        return 0;
    }
    public static void main(String[] args)throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Array[]= new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            Array[i] = number;
        }
        Arrays.sort(Array);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int number = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(Array, number)).append("\n");
        }
        System.out.print(sb);
    }
}
