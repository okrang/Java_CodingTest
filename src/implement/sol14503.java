package implement;

import java.io.*;
import java.util.*;

public class sol14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int direction=Integer.parseInt(st.nextToken());
        int [][] graph=new int [n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int count=1;
        graph[r][c]=2;
        while(true){
            int [] dr={1,0,-1,0};
            int [] dc={0,-1,0,1};
            int block=0;
            for(int i=0;i<4;i++){
                int newdirection=direction+i+1;
                if(newdirection>3){
                    newdirection-=4;
                }
                if(graph[r+dr[newdirection]][c+dc[newdirection]]==0){
                    direction=newdirection;
                    r=r+dr[newdirection];
                    c=c+dc[newdirection];
                    graph[r][c]=2;
                    count++;
                    break;
                }else{
                    block++;
                }

            }
            if(block==4){
                int backdirection=direction+2;
                if(backdirection>3){
                    backdirection-=4;
                }
                if(graph[r+dr[backdirection]][c+dc[backdirection]]!=1){
                    r=r+dr[backdirection];
                    c=c+dc[backdirection];

                }else{
                    break;
                }
            }





        }


        System.out.println(count);


    }
}