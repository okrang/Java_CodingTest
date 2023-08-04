// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
public class sol5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        int n;
        String str;
        String result;
        for(int i=0;i<T;i++){
            result="[";
            String p=br.readLine();


            n=Integer.parseInt(br.readLine());
            str=br.readLine();
            str=str.substring(1,str.length()-1);
            st=new StringTokenizer(str,",");

            ArrayList<Integer> graph=new ArrayList<>();
            for(int k=0;k<n;k++){
                graph.add(Integer.parseInt(st.nextToken()));
            }

            boolean countr=true;
            for(int k=0;k<p.length();k++){
                char ac=p.charAt(k);
                if(ac=='D'){
                    if(countr){
                        if(n!=0){
                            graph.remove(0);
                        }else{
                            n=-1;
                            System.out.println("error");
                            break;
                        }
                        n--;
                    }else{
                        if(n!=0){
                            graph.remove(n-1);
                        }else{
                            n=-1;
                            System.out.println("error");
                            break;
                        }
                        n--;

                    }

                }else{
                    countr=(countr?false:true);

                }

            }

            StringBuilder sb=new StringBuilder("[");

        if(n>=0){
            if(countr==true){
                for(int k=0;k<n;k++){
                    sb.append(graph.get(k)+",");
                }


            }else{
                Collections.reverse(graph);
                for(int k=0;k<n;k++){
                    sb.append(graph.get(k)+",");
                }

            }
            if(n!=0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]");
            System.out.println(sb);

        }




        }

    }
}