package Challenge2;

import java.io.*;
import java.util.*;

public class Day07 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        //int[][] rgb=new int[n][3];
        int[][] dp=new int[n][3];
        st=new StringTokenizer(br.readLine());
        dp[0][0]=Integer.parseInt(st.nextToken());
        dp[0][1]=Integer.parseInt(st.nextToken());
        dp[0][2]=Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                int color=Integer.parseInt(st.nextToken());
                switch(j){
                    case 0: dp[i][j]=Math.min(color+dp[i-1][1],color+dp[i-1][2]);
                        break;
                    case 1: dp[i][j]=Math.min(color+dp[i-1][0],color+dp[i-1][2]);
                        break;
                    default: dp[i][j]=Math.min(color+dp[i-1][1],color+dp[i-1][0]);
                        break;

                }
            }
        }

        System.out.println(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));

    }
}
