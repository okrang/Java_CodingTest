package Study;
import java.io.*;
import java.util.*;
public class Day20 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        long[] height=new long[n];
        st=new StringTokenizer(br.readLine());
        int result=0;
        for(int i=0;i<n;i++){
            height[i]=Long.parseLong(st.nextToken());
        }
        Queue<Long> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n-1;i++){
            Long o1=height[i];
            Long o2=height[i+1];
            q.add(o2-o1);
            result+=o2-o1;
        }
        for(int i=0;i<k-1;i++){
            result-=q.poll();
        }
        System.out.println(result);

    }
}
