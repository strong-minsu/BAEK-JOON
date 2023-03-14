package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p17626 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 2;

        int number[] = new int[50001];

        number[1] = 1;
        number[2] = 2;
        number[3] = 3;
        for(int i=4; i<=n; i++){
            int p = (int)Math.pow(count, 2);
            int before_p = (int)Math.pow(count-1, 2);
            if(i == p){
                number[i] = 1;
                count++;
            }
            else{
                int min=Integer.MAX_VALUE;
                int j = 1;
                int pow = (int)Math.pow(j, 2);
                while (pow<=before_p){
                    int n_min = number[pow]+number[i-pow];
                    if(n_min < min){
                        min = n_min;
                    }
                    j++;
                    pow = (int)Math.pow(j, 2);
                }

                number[i] = min;
            }
        }
        System.out.print(number[n]);
    }
}
