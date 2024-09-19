package Challenge2;

import java.io.*;
import java.util.*;

public class Day11 {
    static int[][] arr;
    static int[] dx={0,1,1,-1};
    static int[] dy={1,1,0,1};
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr=new int[19][19];
        for(int i=0;i<19;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<19;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(arr[i][j]!=0){
                    for(int k=0;k<4;k++){
                        boolean result=cal(i,j,arr[i][j],1,k);
                        if(result==true){
                            System.out.println(arr[i][j]);
                            int x=i+1;
                            int y=j+1;
                            System.out.println(x+" "+y);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);

    }
    public static boolean cal(int x,int y, int color, int count,int dir){
        int cx=x+dx[dir];
        int cy=y+dy[dir];
        boolean result=false;
        if(cx>=0&&cy>=0&&cx<19&&cy<19&&count<5){

            if(arr[cx][cy]==color){
                count++;
                //System.out.println(cx+" "+cy+" "+count);
                if(count==5){
                    int beforex=cx-dx[dir]*5;
                    int beforey=cy-dy[dir]*5;
                    int afterx=cx+dx[dir];
                    int aftery=cy+dy[dir];

                    if(beforex>=0&&beforey>=0&&beforex<19&&beforey<19){
                        if(arr[beforex][beforey]==color){
                            return false;
                        }
                    }
                    if(afterx>=0&&aftery>=0&&afterx<19&&aftery<19){
                        if(arr[afterx][aftery]==color){
                            return false;
                        }
                    }
                    return true;
                }else{
                    result=cal(cx,cy,color,count,dir);

                }

            }
        }

        return result;
    }
}
