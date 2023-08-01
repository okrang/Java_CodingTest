// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class sol5212 {
    static char [][] graph;
    static char [][] newgraph;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        graph=new char[r][c];
        newgraph=new char[r][c];
        String str;
        for(int i=0;i<r;i++){
            str=br.readLine();
            for(int j=0;j<c;j++){
                graph[i][j]=str.charAt(j);
                newgraph[i][j]=str.charAt(j);
            }

        }
        int startr=r;
        int endr=0;
        int startc=c;
        int endc=0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(graph[i][j]=='X'){
                    sea(i,j);
                }
                if(newgraph[i][j]=='X'){
                    if(i<startr){
                        startr=i;
                    }
                    if(i>endr){
                        endr=i;
                    }
                    if(j<startc){
                        startc=j;
                    }
                    if(j>endc){
                        endc=j;
                    }

                }

            }
        }

        //System.out.println("위"+startr+"아래"+endr+"왼쪽"+startc+"오른쪽"+endc);
        for(int i=startr;i<=endr;i++){
            for(int j=startc;j<=endc;j++){
                System.out.print(newgraph[i][j]);
            }
            System.out.println();
        }


    }
    public static void sea(int i,int j){
        int [] di={-1,0,1,0};
        int [] dj={0,1,0,-1};
        int count=0;

        for(int k=0;k<4;k++){
            int ci=i+di[k];
            int cj=j+dj[k];
            if(ci>=0&&cj>=0&&ci<r&&cj<c){
                if(graph[ci][cj]=='.'){
                    count++;
                }
            }else{
                count++;
            }
        }
        if(count>=3){
            newgraph[i][j]='.';
        }

    }
}