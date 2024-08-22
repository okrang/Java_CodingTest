package Study;
import java.util.*;
import java.io.*;
public class Day18 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int []trees=new int[n];
        Integer []grows=new Integer[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        Long result=0L;
        for(int i=0;i<n;i++){
            trees[i]=Integer.parseInt(st.nextToken());
            result+=trees[i];
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            grows[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grows,Collections.reverseOrder());
        for(int i=0;i<n;i++){
            result+=grows[i]*(n-1-i);
        }
        System.out.println(result);



    }
}
