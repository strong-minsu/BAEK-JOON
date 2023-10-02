package Data_Structure;
import java.util.*;
import java.io.*;

//회사에 있는 사람

public class p7785 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String recode = st.nextToken();

            hashMap.put(name, recode);
        }

        for(Map.Entry<String, String> entry : hashMap.entrySet()){
            if(entry.getValue().equals("enter")){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        Collections.reverse(list);

        for(String s: list){
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
