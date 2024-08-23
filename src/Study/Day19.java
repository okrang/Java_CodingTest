package Study;
import java.io.*;
import java.util.*;
public class Day19 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        ArrayList<Integer> tilea=new ArrayList<>();
        Queue<Integer> tileb=new PriorityQueue<>(Collections.reverseOrder());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++){
            tilea.add(Integer.parseInt(st.nextToken()));
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<b;i++){
            tileb.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(tilea,Collections.reverseOrder());

        int result=0;

        if(n%2==1){
            result+=tilea.get(0);
            tilea.remove(0);
            n=n-1;
        }

        for(int i=0;i<n/2;i++){

            int tb;
            int ta;
            if(tileb.size()==0){
                tb=0;
            }else{
                tb=tileb.peek();
            }

            if(tilea.size()<=1){
                ta=0;
            }else{
                ta=tilea.get(0)+tilea.get(1);
            }
            if(tb>ta){
                result+=tb;
                tileb.poll();
            }else{
                result+=ta;
                tilea.remove(0);
                tilea.remove(0);
            }

        }

        System.out.println(result);





    }
}
