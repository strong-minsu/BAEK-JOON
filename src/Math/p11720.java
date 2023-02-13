package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p11720 {
    static public void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //공백없이 입력된 숫자 값을 String로 받고 char 리스트로 변환
        String sNumber = br.readLine();
        char[] cNumber = sNumber.toCharArray();

        int sum =0;
        for(int i=0; i<N; i++){
            //char배열에 있는 수를 integer로 변환한 후 sum에 더한다.
            sum += cNumber[i]-'0';
        }

        System.out.print(sum);
    }
}
