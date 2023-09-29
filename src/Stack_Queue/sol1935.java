package Stack_Queue;
import java.util.*;
import java.io.*;
public class sol1935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String str=br.readLine();
        double [] arr=new double[26];

        for(int i=0;i<n;i++){
            arr[i]=Double.parseDouble(br.readLine());
        }
        Stack<Double> stack=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='*'){
                double a=stack.pop();
                double b=stack.pop();
                double result=a*b;
                stack.add(result);

            }else if(ch=='/'){
                double a=stack.pop();
                double b=stack.pop();
                double result=b/a;
                stack.add(result);

            }else if(ch=='+'){
                double a=stack.pop();
                double b=stack.pop();
                double result=a+b;
                stack.add(result);

            }else if(ch=='-'){
                double a=stack.pop();
                double b=stack.pop();
                double result=b-a;
                stack.add(result);

            }else{
                int chnum=ch-'A';
                stack.add(arr[chnum]);

            }

        }
        System.out.printf("%.2f",stack.pop());




    }
}