package String;

import java.util.*;
import java.io.*;

//Cubeditor
//두 번 이상 나오는 부분 문자열 중에서 가장 긴 것
// 그래서 이 문제는 문자열 탐색을 가장한 접두사와 접미사가 같은 문자열의 최대 길이를 구하자..1!
/*
*  1. ex) "tomato" 에서 왼쪽부터 시작해서 만들 수 있는 문자열
* (t, to, tom, toma, tomat, tomato) 각각에 대해 위 과정을 수행해서 얻은 값을 배열에 담는다. (보통 pi라고 정한다.)
*  2.  1)에서 얻은 pi 배열을 가지고 문자열 탐색 중간에 건너뛰기에 활용한다.
*/
public class p1701 {
    static String str;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        int length = str.length();
        int result = 0;

        //모든 부분 문자열 탐색
        for (int i = 0; i < length; i++) {
            //왼쪽부터 시작해서 만들 수 있는 문자열
            String substr = str.substring(i, length);
            result = Math.max(result, kmp(substr));
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    static int kmp (String str){
        int max = 0;
        int length = str.length();

        int j = 0; //j //왼쪽 (접두사) 비교 문자열 인덱스
        int pi[] = new int[length];

        for (int i = 1; i < length; i++) { //i //오른쪽 (접미사) 비교 문자열 인덱스
            while (j > 0 && str.charAt(i) != str.charAt(j)){
                j = pi[j-1];
            }

            if(str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }
        return max;
    }
}
