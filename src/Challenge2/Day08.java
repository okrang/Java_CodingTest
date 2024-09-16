package Challenge2;

import java.io.*;
import java.util.*;

public class Day08 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int [][] mindp=new int[n][3];
        int[][] maxdp=new int[n][3];
        StringTokenizer st=new StringTokenizer(br.readLine());
        mindp[0][0]=Integer.parseInt(st.nextToken());
        mindp[0][1]=Integer.parseInt(st.nextToken());
        mindp[0][2]=Integer.parseInt(st.nextToken());
        maxdp[0][0]=mindp[0][0];
        maxdp[0][1]=mindp[0][1];
        maxdp[0][2]=mindp[0][2];

        for(int i=1;i<n;i++){
            st=new StringTokenizer(br.readLine());

            for(int j=0;j<3;j++){
                int stair=Integer.parseInt(st.nextToken());
                if(j==0){
                    mindp[i][j]=stair+Math.min(mindp[i-1][0],mindp[i-1][1]);
                    maxdp[i][j]=stair+Math.max(maxdp[i-1][0],maxdp[i-1][1]);
                }else if(j==1){
                    mindp[i][j]=stair+Math.min(mindp[i-1][0],Math.min(mindp[i-1][1],mindp[i-1][2]));
                    maxdp[i][j]=stair+Math.max(maxdp[i-1][0],Math.max(maxdp[i-1][1],maxdp[i-1][2]));
                }else{
                    mindp[i][j]=stair+Math.min(mindp[i-1][1],mindp[i-1][2]);
                    maxdp[i][j]=stair+Math.max(maxdp[i-1][1],maxdp[i-1][2]);
                }
            }
        }


        System.out.println(Math.max(maxdp[n-1][0],Math.max(maxdp[n-1][1],maxdp[n-1][2]))+" "+Math.min(mindp[n-1][0],Math.min(mindp[n-1][1],mindp[n-1][2])));
    }
}
