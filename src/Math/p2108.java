package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//통계학
public class p2108 {
    static long Mean (int number[]){
        double sum =0;
        for(int i=0; i<number.length; i++){
            sum += number[i];
        }
        double mean = sum/number.length;
        return Math.round(mean);
    }
    static  int Median (int number[]){
        int mid = number.length/2;
        return number[mid];
    }
    static  int Mode (int number[]){
        int count=0;
        int max=-1;
        int mod = number[0];
        boolean check = false;

        for(int i=0; i<number.length-1; i++){
            if(number[i] == number[i+1]){
                count ++;
            }
            else{
                count = 0;
            }

            //mod값 확인
            if(max < count){
                max = count;
                mod = number[i];
                check = true;
            }
            //두번째로 작은 수인지 검사
            else if (max == count && check) {
                mod = number[i];
                check = false;
            }
        }
        return mod;
    }
    static int Scope(int number[]){
        return number[number.length-1] - number[0];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int number[] = new int[N];

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            number[i] = n;
        }
        Arrays.sort(number);

        sb.append(Mean(number)).append("\n").append(Median(number)).append("\n")
                .append(Mode(number)).append("\n").append(Scope(number));
        System.out.print(sb);

    }
}
