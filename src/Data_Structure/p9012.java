package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//괄호
public class p9012 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            int count =0;
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c=='('){
                    stack.add(c);
                }else{
                    if(stack.isEmpty()){
                        sb.append("NO").append("\n");
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
                count ++;
            }

            //괄호 검사 반복문 종료시 문장의 모든 괄호가 검사됐는지, 스택이 비어있는지 확인
            if(count == str.length() && stack.isEmpty()){
                sb.append("YES").append("\n");
            }
            else if(count == str.length() && !stack.isEmpty()){
                sb.append("NO").append("\n");
            }
            stack.clear();
        }

        System.out.print(sb);
    }
}
