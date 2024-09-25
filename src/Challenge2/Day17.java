package Challenge2;

import java.util.*;
import java.io.*;
public class Day17 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] dp=new int[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[a]=0;
        for(int i=a;i<k;i++){
            if(i+1<=k){
                dp[i+1]=Math.min(dp[i+1],dp[i]+1);
            }
            if(2*i<=k){
                dp[2*i]=Math.min(dp[2*i],dp[i]+1);
            }
        }
        System.out.println(dp[k]);

    }
}
