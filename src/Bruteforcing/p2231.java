package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//분해합
public class p2231 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int createNumber=0;
        int sum =0;

        //생성자는 N보다 무조건 작다.
        while (N>createNumber){
            sum = 0;
            createNumber++;
            String cn = Integer.toString(createNumber);
            int len = cn.length();
            char c[] = cn.toCharArray();

            //생성자길이 만큼 반복 e.g.) 129 = 123 + 1 + 2 + 3 여기서 + 1 + 2 + 3
            for(int i=0; i<len; i++){
                sum += c[i]-'0';
            }
            //생성자 자체 숫자 더하기 e.g.) 129 = 123 + 1 + 2 + 3 여기서  + 123
            sum += createNumber;
            // 입력값과 같은지 확인
            if(sum == N){
                break;
            }
        }
        if(sum==N){
            // 생성자가 있는 경우
            System.out.println(createNumber);
        }
        else{
            // 생성자가 없는 경우
            System.out.println(0);
        }
    }
}
