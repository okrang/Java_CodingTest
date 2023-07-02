import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class sol1018 {
    public static void main(String[] args) throws IOException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n;
        int m;

//        int wcount=0;
  //      int bcount=0;

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        boolean [][] wgraph=new boolean [n][m];
        boolean [][] bgraph=new boolean [n][m];

        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<m;j++){
                if((i+j)%2==0){
                    if(str.charAt(j)=='W'){
                        wgraph[i][j]=false;
                        bgraph[i][j]=true;
                    }else{
                        wgraph[i][j]=true;
                        bgraph[i][j]=false;
                    }
                }else{
                    if(str.charAt(j)=='W'){
                        wgraph[i][j]=true;
                        bgraph[i][j]=false;
                    }else{
                        wgraph[i][j]=false;
                        bgraph[i][j]=true;
                    }

                }

            }

        }

        int mincount=n*m;
        int wcount=0;
        int bcount=0;
        //System.out.println(Arrays.deepToString(wgraph));
        //System.out.println(Arrays.deepToString(bgraph));

        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                bcount=0;
                wcount=0;
                for(int k=i;k<i+8;k++){
                    for(int l=j;l<j+8;l++){
                        if(wgraph[k][l]==true) wcount++;
                        if(bgraph[k][l]==true) bcount++;
                    }
                }
                if(wcount<mincount){
                    mincount=wcount;
                }
                if(bcount<mincount){
                    mincount=bcount;
                }

            }
        }
        System.out.println(mincount);


//        for(int i=0;i<n;i++){
//            String str=br.readLine();
//            wstart(str,i+1);
//            bstart(str,i+1);
//
//        }
//        System.out.println("Wcount: "+wcount);
//        System.out.println("Bcount: "+bcount);
//
//        if(wcount<bcount){
//            System.out.println(wcount);
//        }else{
//            System.out.println(bcount);
//        }

    }
//
//    public static void wstart(String str,int i){
//
//        for(int j=1;j<9;j++){
//            if((i+j)%2==0) {
//                if(str.charAt(j-1)=='W'){
//                    wcount++;
//                }
//            }else{
//                if(str.charAt(j-1)=='B'){
//                    wcount++;
//                }
//            }
//        }
//
//
//    }
//    public static void bstart(String str,int i){
//        for(int j=1;j<9;j++){
//            if((i+j)%2==0) {
//                if(str.charAt(j-1)=='B'){
//                    bcount++;
//                }
//            }else{
//                if(str.charAt(j-1)=='W'){
//                    bcount++;
//                }
//            }
//        }
//
//    }
}