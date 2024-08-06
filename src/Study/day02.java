package Study;

import java.io.*;
import java.util.*;

public class day02 {
    static int[] arr;
    static boolean [] visited;
    static int n,s,cnt;
    public static void main(String[]args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int[n];
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        cnt=0;
        for(int i=1;i<n+1;i++){
            combination(n,i);
            Arrays.fill(visited,false);
        }
        System.out.println(cnt);

    }
    public static void combination(int n, int c){
        int count;
        int sum;

        for(int i=0;i<n;i++){
            visited[i]=true;
            count=1;
            sum=arr[i];
            visit(i, count,c,sum);
            //System.out.println(count+" "+c+" "+sum);
        }
    }
    public static void visit(int k, int count, int c, int sum){
        if(count==c){
            //System.out.println("visit: "+count+" "+c+" "+sum);
            //System.out.println(count+" "+c+" "+sum+" "+s);
            if(sum==s){
                cnt++;
            }
            return;
        }
        for(int i=k;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                count++;
                sum+=arr[i];

                visit(i,count, c, sum);
                count--;
                sum-=arr[i];
                visited[i]=false;
            }
        }

    }
}
