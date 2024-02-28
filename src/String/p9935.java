package String;

import java.util.*;
import java.io.*;

//문자열 폭발
public class p9935 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String boom = br.readLine();

        int strLen = str.length();
        int boomLen = boom.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < strLen; i++) {
            stack.add(str.charAt(i));

            //스택 사이즈가 폭탄 사이즈 이상일 때 검사
            if(stack.size() >= boomLen){
                boolean flag = true;
                for (int j = 0; j < boomLen; j++) {
                    if(stack.get(stack.size()-boomLen+j) != boom.charAt(j)){
                        //폭탄과 다르다..!
                        flag =false;
                        break;
                    }
                }

                if(flag){
                    for (int j = 0; j < boomLen; j++) {
                        stack.pop();
                    }
                }
            }

        }
        int stackSize = stack.size();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stackSize; i++) {
            sb.append(stack.get(i));
        }

        if(sb.length() == 0){
            bw.write("FRULA");
        }
        else{
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}
