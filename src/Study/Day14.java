package Study;
import java.util.*;
import java.io.*;

public class Day14 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int []dp=new int[n+1];
        int []arr=new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=1;
            for(int j=1;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

        }
        int MAXINT=0;
        for(int i=1;i<n+1;i++){
            MAXINT=Math.max(MAXINT,dp[i]);

//            System.out.println(dp[i]);
//            System.out.println(Math.max(MAXINT,dp[i]));
        }
        System.out.println(MAXINT);


    }
}
