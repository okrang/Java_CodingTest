package DP;

public class softeer70910 {
    import java.io.*;
import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int n=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            int []dp=new int[n];
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp,1);
            int answer=1;
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[i]>arr[j]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                        if(answer<dp[i]){
                            answer=dp[i];
                            //System.out.println(answer);
                        }
                    }
                }
            }
            // for(int i=0;i<n;i++){
            //     answer=Math.max(answer,dp[i]);
            //     System.out.println(":"+answer);
            // }

            System.out.println(answer);



        }
    }

}
