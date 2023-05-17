package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//민겸 수
public class p21314 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String MK = br.readLine();

        int m=0;

        //제일 큰 값
        for (int i = 0; i < MK.length(); i++) {
            char c = MK.charAt(i);
            if(c == 'K'){
                sb.append(5);
                for (int j = 0; j < m; j++) {
                    sb.append(0);
                }
                m=0;
            }
            else{
                m++;
            }
        }
        if(m>0){
            while(m>0){
                sb.append(1);
                m--;
            }
        }
        sb.append("\n");

        //작은 값
        for (int i = 0; i < MK.length(); i++) {
            char c = MK.charAt(i);
            if(c == 'K'){
                if(m==0){
                    sb.append(5);
                }
                else{
                    sb.append(1);
                    for (int j = 0; j < m-1; j++) {
                        sb.append(0);
                    }
                    sb.append(5);
                }
                m=0;
            }
            else{
                m++;
            }
        }
        if(m>0){
            sb.append(1);
            for (int j = 0; j < m-1; j++) {
                sb.append(0);
            }
        }

        System.out.print(sb);
    }
}
