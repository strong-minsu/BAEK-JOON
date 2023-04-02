package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//IOIOI
public class p5525 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String S = br.readLine();

        //"OI" count
        int count = 0;

        // Pn count
        int result = 0;

        for(int i=1; i<M-1; ){
            if(S.charAt(i) == 'O'&& S.charAt(i+1) == 'I'){
                count++;
                if(count == N){
                    //가장 앞이 I인지 확인
                    if(S.charAt(i-(count*2-1)) == 'I'){
                        result++;
                    }
                    count--;
                }
                i += 2;
            }
            else{
                count = 0;
                i++;
            }
        }
        System.out.print(result);
    }
}
