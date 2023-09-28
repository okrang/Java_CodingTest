package Stack_Queue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class sol1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();



       for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch == '(') {
                stack.add('(');

            }else if(ch==')'){

                while(stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();

            }else if (ch == '*'||ch=='/'||ch=='+'||ch=='-') {
                while(!stack.isEmpty()&&priority(stack.peek())>=priority(ch)){
                    sb.append(stack.pop());
                }
                stack.add(ch);

            }else{
                sb.append(ch);


            }

        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }


        System.out.println(sb);

    }
    public static int priority(char ch){
        if(ch=='*'||ch=='/'){
            return 2;
        } else if (ch=='+'||ch=='-') {
            return 1;
        }else{
            return 0;
        }

    }
}