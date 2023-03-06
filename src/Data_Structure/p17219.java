package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//비민번호 찾기
public class p17219 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();

        String website;
        String password;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());;
            website = st.nextToken();
            password = st.nextToken();

            hashMap.put(website, password);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            website = st.nextToken();
            password = hashMap.get(website);
            sb.append(password).append("\n");
        }
        System.out.print(sb);
    }
}
