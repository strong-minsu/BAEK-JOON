package Data_Structure;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

//세 수의 합
public class p2295 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        //x+y+z  = k
        // x+y = k-z

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
        }
        Arrays.sort(numbers);

        // 두개의 합 배열 만들기
//        int[] sum = new int[n * (n+1) / 2];
//        int index = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = i; j < n; j++){
//                sum[index++] = numbers[i] + numbers[j];
//            }
//        }
//
//        Arrays.sort(sum,0,index-1);
//
//        Loop1:
//        for (int i = n - 1; 0 <= i; i--) {
//            Loop2:
//            for (int j = i; 0 <= j; j--) {
//                int findNum = numbers[i]-numbers[j];
//                if (Arrays.binarySearch(sum,0, index-1, numbers[i] - numbers[j]) < 0) continue;
//                answer = numbers[i];
//                break Loop1;
//
//            }
//        }
//
//        bw.write(answer+"");
//        bw.flush();
//        bw.close();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

        answer = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int target = numbers[i] - numbers[j];// k는 u[i]이다.
                if(set.contains(target)){
                    answer = Math.max(answer, numbers[i]);
                }
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();

    }
}
