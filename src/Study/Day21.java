package Study;
import java.io.*;
import java.util.*;
public class Day21 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        Long k=Long.parseLong(br.readLine());
        String result="0";
        if(k<=x*y){
            int start=0;
            int count=1;
            int cx=x;
            int cy=y;
            int end=0;
            while(true){
                end=start+2*cx+2*cy-4;
                if(end>=k){
                    break;
                }else{
                    cx-=2;
                    cy-=2;
                    count++;
                    start=end;
                }
            }
            int startx=start+cy;
           // int starty=startx+cy+cx-1;
            if(k-start<=cy){
                String stx=""+count;
                String sty=" "+(k-start+count-1);
                result=stx+sty;

            }else if(k-start<=cy+cx-1){

                String stx=""+(count+k-startx);
                String sty=" "+(y-count+1);
                result=stx+sty;
            }else if(k-start<=cy+cx+cy-2){

                String stx=""+(x-count+1);
                String sty=" "+(y-count+1-(k-(start+cx+cy-1)));

                result=stx+sty;

            }else{
                String stx=""+(x-count+1-(k-(start+2*cy+cx-2)));;
                String sty=" "+count;
                result=stx+sty;

            }

        }
        System.out.println(result);
    }
}
