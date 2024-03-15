package Data_Structure;

import java.util.*;
import java.io.*;

//한 쌍의 괄호로만 이루어진 ‘()’와 ‘[]’는 올바른 괄호열이다.
//만일 X가 올바른 괄호열이면 ‘(X)’이나 ‘[X]’도 모두 올바른 괄호열이 된다.
//X와 Y 모두 올바른 괄호열이라면 이들을 결합한 XY도 올바른 괄호열이 된다.

//‘()’ 인 괄호열의 값은 2이다.
//‘[]’ 인 괄호열의 값은 3이다.
//‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
//‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
//올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.

//괄호의 값
public class p2504 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        long answer = 0;
        int value = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '('){
                stack.push(c);
                value *= 2;
            }
            else if(c == '['){
                stack.push(c);
                value *= 3;
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    answer = 0;
                    break;
                }
                if(str.charAt(i-1) == '('){
                    //실제 열린괄호와 만나서 닫히는 부분만 더하기
                    answer += value;
                }
                stack.pop();
                value /= 2;
            }
            else {
                if(stack.isEmpty() || stack.peek() != '['){
                    answer = 0;
                    break;
                }
                if(str.charAt(i-1) == '['){
                    //실제 열린괄호와 만나서 닫히는 부분만 더하기
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if(!stack.isEmpty()) answer = 0;

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
