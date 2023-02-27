package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//덩치
public class p7568 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int people[][] = new int[N][2];
//        int result[] = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }
        int count;
        for(int i=0; i<N; i++){
            count = 1;
            for(int j=0; j<N; j++){
                if (j!=i){
                    if((people[i][0] < people[j][0])&&(people[i][1] < people[j][1])){
                        count ++;
                    }
                }
            }
            sb.append(count).append(" ");
        }
        System.out.print(sb);
    }
}
