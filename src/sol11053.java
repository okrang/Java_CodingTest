import java.util.*;
import java.io.*;
public class sol11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int [] graph=new int[n];
        int [] count=new int[n];

        for(int i=0;i<n;i++){
            graph[i]=Integer.parseInt(st.nextToken());
            count[i]=1;

        }

        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(graph[i]>graph[j]&&count[i]<=count[j]){
                    count[i]=count[j]+1;
                }
            }
            max=Math.max(max,count[i]);
        }

        System.out.println(max);



    }
}