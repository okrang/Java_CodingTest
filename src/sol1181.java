// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class sol1181 {
    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int count=Integer.parseInt(st.nextToken());
        int idx=0;
        ArrayList<String> arr1=new ArrayList<>();
        for(int i=0;i<count;i++){
            st=new StringTokenizer(br.readLine());
            String word=st.nextToken();
            if(arr1.contains(word)){
                continue;
            }else{
                arr1.add(word);

            }
            //System.out.println(arr1.get(i));
        }
        if(arr1.size()>1) {
            Collections.sort(arr1, new sorting());
        }
        for(int i=0;i<arr1.size();i++){
            System.out.println(arr1.get(i));

        }



    }

}
class sorting implements Comparator<String>{
    @Override
    public int compare(String word1, String word2) {
        if(word1.length()<word2.length()){
            return -1;
        }else if(word1.length()>word2.length()){
            return 1;
        }else{
            if(word1.compareToIgnoreCase(word2)<0){
                return -1;
            }else{
                return 1;
            }

        }
    }
}
