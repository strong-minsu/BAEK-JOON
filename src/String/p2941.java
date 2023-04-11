package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//크로아티아 알파벳
public class p2941 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        ArrayList<String> croatia_alpha  = new ArrayList<>();
        croatia_alpha.add("c=");
        croatia_alpha.add("c-");
        croatia_alpha.add("dz=");
        croatia_alpha.add("d-");
        croatia_alpha.add("lj");
        croatia_alpha.add("nj");
        croatia_alpha.add("s=");
        croatia_alpha.add("z=");

        int count = 0;
        for (int i = 0; i < croatia_alpha.size(); i++) {
            if(word.contains(croatia_alpha.get(i))) {
                word= word.replace(croatia_alpha.get(i), "#");
            }
        }
        count = word.length();
        System.out.print(count);
    }
}
