package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//학생 번호
public class p1235 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] number  = new String[N];
        String [] origin  = new String[N];

        int n = 0;

        for (int i = 0; i < N; i++) {
            StringBuffer s = new StringBuffer(br.readLine());
            number[i] = s.reverse().toString();
            origin[i] = number[i];
        }
        n = number[0].length();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count++;
            for (int j = 0; j < N; j++) {
                String s = number[j].substring(0, i);
                number[j] = s;
            }

            Set<String> set = new HashSet<>(Arrays.asList(number));
            if(set.size() == origin.length){
                //반복문 종료
                break;
            }

            for (int j = 0; j < N; j++) {
                number[j] = origin[j];
            }
        }
        System.out.print(count);
    }
}
