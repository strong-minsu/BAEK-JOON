package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//A와 B 2
public class p12919 {
    static String S,T;
    static int result;

    //A와 B를 직접 더하면서 체크하는 방법n^2
    //최악의 경우 시간초과가ㅏㅏ 예상됩미다..! 2의 50제곱(1조) > 2억 이니까..

    //타겟 문자열에서 A와 B를 빼면서 확인하는 방법이 가장 빠름
    static void stringCheck(String str){
        if(str.length() == S.length()){
            if(str.equals(S)){
                result = 1;
            }
            return;
        }

        //마지막이 A인 경우 A를 제거한 문자열 검사
        if(str.charAt(str.length()-1) == 'A'){

            stringCheck(str.substring(0, str.length()-1));
        }

        //맨 앞이 B인 경우 B를 제거 후 reverse한 문자열 검사
        if(str.charAt(0) == 'B'){

            StringBuffer stringBuffer = new StringBuffer(str.substring(1, str.length()));
            String reverse = stringBuffer.reverse().toString();

            stringCheck(reverse);
        }
        return;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        result = 0;
        stringCheck(T);
        System.out.print(result);
    }
}
