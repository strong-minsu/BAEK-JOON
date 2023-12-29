package Data_Structure;

import java.util.*;
import java.io.*;

//에디터
public class p1406 {
    static Stack<Character> stack1;
    static Stack<Character> stack2;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        //커서 기준 왼쪽 스택
        stack1 = new Stack<>();
        //커서 기준 오른쪽 스택
        stack2 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack1.push(str.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            if(commend.equals("L")){
                if(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            else if(commend.equals("D")){
                if(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }
            else if(commend.equals("B")){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else{
                char c = st.nextToken().charAt(0);
                stack1.push(c);
            }
        }
        for (char character : stack1){
            sb.append(character);
        }
        int stack2Size = stack2.size();
        for (int i=0; i< stack2Size; i++){
            sb.append(stack2.pop());
        }

        System.out.print(sb);
    }
}
