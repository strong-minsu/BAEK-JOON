package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

//회전하는 큐
public class p1021 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<N+1; i++) {
            deque.addLast(i);
        }

        int count=0;
        int l;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            l = Integer.parseInt(st.nextToken());

            while(true) {
                int index=0;
                Iterator it = deque.iterator();

                while(it.hasNext()) {
                    int inext = (int)it.next();
                    if(inext == l) {
                        //System.out.println(inext);
                        break;
                    }
                    index++;
                }
                //System.out.print(index);
                if(index == 0) {
                    deque.pollFirst();
                    break;
                }
                else if(deque.size()/2 >= index) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
                else {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }

        }
        System.out.print(count);
    }
}
