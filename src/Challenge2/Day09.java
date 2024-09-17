package Challenge2;

import java.io.*;
import java.util.*;

public class Day09 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int x=0;
        int y=0;
        //동남서북
        int[] dx={1,0,-1,0};
        int[] dy={0,-1,0,1};
        int dir=0;
        int result=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String direction=st.nextToken();
            int num=Integer.parseInt(st.nextToken());
            if(direction.equals("TURN")){
                //0일땐 왼쪽 90, 1일땐 오른쪽 90
                if(num==0){
                    if(dir==0){
                        dir=3;
                    }else{
                        dir--;
                    }
                }else{
                    if(dir==3){
                        dir=0;
                    }else{
                        dir++;
                    }
                }
            }else{
                x=x+dx[dir]*num;
                y=y+dy[dir]*num;
                if(x<0||y<0||x>m||y>m){
                    result=-1;
                    break;
                }

            }
        }
        if(result==-1){
            System.out.println(-1);
        }else{
            System.out.println(x+" "+y);
        }

    }
}
