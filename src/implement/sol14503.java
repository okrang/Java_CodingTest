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
        //0:북 1:동 2:남 3:서
        int [][] graph=new int [n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int cleancount=0;

        while(true){
            if(graph[r][c]==0){
                cleancount++;
            }

            graph[r][c]=2;
            int block=0;
            int []dr1={0,1,0,-1};
            int []dc1={-1,0,1,0};
            int []direct1={3,2,1,0};

            int [] dr2={-1,0,1,0};
            int [] dc2={0,-1,0,1};
            int []direct2={0,3,2,1};

            int [] dr3={0,-1,0,1};
            int [] dc3={1,0,-1,0};
            int []direct3={1,0,3,2};

            int [] dr4={1,0,-1,0};
            int [] dc4={0,1,0,-1};
            int []direct4={2,1,0,3};
            for(int i=0;i<4;i++){
                int cr=0;
                int cc=0;
                int newdirection=0;
                switch(direction) {
                    case 0:
                         cr = r + dr1[i];
                         cc = c + dc1[i];
                         newdirection=direct1[i];
                        break;
                    case 1:
                         cr = r + dr2[i];
                         cc = c + dc2[i];
                        newdirection=direct2[i];
                        break;
                    case 2:
                         cr = r + dr3[i];
                         cc = c + dc3[i];
                        newdirection=direct3[i];
                        break;
                    case 3:
                         cr = r + dr4[i];
                         cc = c + dc4[i];
                        newdirection=direct4[i];
                        break;
                }
                if(cr>=0&&cc>=0&&cr<n&&cc<m&&graph[cr][cc]==0){
                    direction=newdirection;
                    r=cr;
                    c=cc;

                    break;
                }else{
                    block++;
                }
            }
            if(block==4){

                int backr=0;
                int backc=0;
                switch(direction){
                    case(2):
                        backr=r-1;
                        backc=c;
                        break;
                    case(3):
                        backr=r;
                        backc=c+1;
                        break;
                    case(0):
                        backr=r+1;
                        backc=c;
                        break;
                    case(1):
                        backr=r;
                        backc=c-1;
                        break;
                }
                if(backr>=0&&backc>=0&&backr<n&&backc<m&&graph[backr][backc]!=1){
                    r=backr;
                    c=backc;
                }else{
                    break;
                }
            }


        }
        System.out.println(cleancount);





    }
}