package greddy;
import java.io.*;
import java.util.*;
public class softeer6291 {


    public class Main {

        public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int n=Integer.parseInt(br.readLine());
            int [][] course=new int[n][2];
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                course[i][0]=a;
                course[i][1]=b;
            }
            //시작시간 기준 오름차순 정렬
            int[] dp=new int[n];
            Arrays.fill(dp,1);
            //int[] end=new int[n];
            Arrays.sort(course,(o1,o2)->o1[1]-o2[1]);
            int answer=0;
            int end=0;
            for(int i=0;i<n;i++){
                if(end<=course[i][0]){
                    answer++;
                    end=course[i][1];
                }

            }
            // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //bw.write(answer);
            System.out.println(answer);


        }
    }

}
