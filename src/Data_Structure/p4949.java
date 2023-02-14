package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//균형잡힌 세상
public class p4949 {
    static Stack<Character> stack;
    static String balanced_world (String s) {
        String result;
        stack = new Stack<>();

        for (int i=0; i<s.length(); i++){
            char a = s.charAt(i); //char형으로 하나씩 검사!

            if(a=='['|| a=='('){ //여는 괄호일 경우 스택에 추가
                stack.add(a);
            }

            else if(a==']'){ //닫는 대괄호인 경우
                if(stack.isEmpty() || stack.peek() !='['){
                    //스택이 비어있거나 짝이 맞지 않는 경우 no 리턴
                    result = "no";
                    return result;
                }
                else {
                    stack.pop();
                }
            }
            else if (a==')'){//닫는 소괄호 경우
                if(stack.isEmpty() || stack.peek() !='('){
                    //스택이 비어있거나 짝이 맞지 않는 경우 no 리턴
                    result = "no";
                    return result;
                }
                else {
                    stack.pop();
                }
            }
            else{ //괄호가 아닌 것들은 전부 패스!
                continue;
            }
        }
        //for문 종료 후 스택에 아무것도 남지 않았다면 균형잡힌 문장!
        if(stack.isEmpty()){
            result = "yes";
        }
        else {
            result = "no";
        }

        //결과 리턴!
        return result;
    }
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while(true){
            s = br.readLine();
            //종료 조건 "." 하나 입력
            if(s.equals(".")){
                break;
            }

            //문장 검사
            String result = balanced_world(s);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
