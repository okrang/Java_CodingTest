package Study;
import java.io.*;
import java.util.*;

public class Dya24 {
    static int [][] dices;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int sum=0;
        int maxSum=0;
//        int t1=0;
//        int t2=0;
//        int t3=0;
//        int t4=0;
//        int t5=0;
//        int t6=0;

        dices=new int[n][6];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<6;j++){
                dices[i][j]=Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0;i<6;i++){
            int bottom=dices[0][i];
            int top=dices[0][Top(0,i)];
            if(top==6||bottom==6){
                if(top==5||bottom==5){
                    sum=4;
                }else{
                    sum=5;
                }
            }else{
                sum=6;
            }
            for(int j=1;j<n;j++){;
                for(int k=0;k<6;k++){
                    if(dices[j][k]==top){
                        bottom=top;
                        top=dices[j][Top(j,k)];

                        if(top==6||bottom==6){
                            if(top==5||bottom==5){
                                sum+=4;
                            }else{
                                sum+=5;
                            }
                        }else{
                            sum+=6;
                        }
                        //System.out.println(sum);
                        break;
                    }
                }
            }

        maxSum=Math.max(maxSum,sum);

        }
        System.out.println(maxSum);



    }
    public static int Top(int i, int j){
        switch(j){
            case 0:
                return 5;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                return 0;
        }


    }
}
