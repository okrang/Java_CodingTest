package Study;
import java.io.*;
import java.util.*;
public class Day22 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int R=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        char[][] map=new char[R][C];
        char[][] orimap=new char[R][C];
        for(int i=0;i<R;i++){
            String str=br.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=str.charAt(j);
                orimap[i][j]=map[i][j];
            }
        }

        int minR=R;
        int maxR=0;
        int minC=C;
        int maxC=0;
        int [] cr={-1,0,1,0};
        int [] cc={0,1,0,-1};
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]=='X'){
                    int sea=0;
                    for(int k=0;k<4;k++){
                        int dr=i+cr[k];
                        int dc=j+cc[k];

                        if(dr==-1||dc==-1||dr==R||dc==C){
                            sea++;
                        }else{
                            if(orimap[dr][dc]=='.'){
                                sea++;
                            }
                        }

                    }
                    if(sea<3){
                        minR=Math.min(minR,i);
                        maxR=Math.max(maxR,i);
                        minC=Math.min(minC,j);
                        maxC=Math.max(maxC,j);

                    }else{
                        map[i][j]='.';
                    }



                }
            }
        }

        for(int i=minR;i<=maxR;i++){
            for(int j=minC;j<=maxC;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }



    }
}
