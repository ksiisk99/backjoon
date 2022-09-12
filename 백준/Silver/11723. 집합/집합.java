import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int visit=0;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        StringTokenizer st;

        int M=Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            calculation(br.readLine());
        }

        System.out.print(sb.toString());
    }

    static void calculation(String query){
        String[] oper=query.split(" ");

        if(oper[0].equals("add")){
            visit|=(1<<Integer.parseInt(oper[1]));
        }else if(oper[0].equals("check")){
            sb.append(String.valueOf((visit&(1<<Integer.parseInt(oper[1])))>0?1:0)+"\n");
        }else if(oper[0].equals("remove")){
            visit&=~(1<<Integer.parseInt(oper[1]));
        }else if(oper[0].equals("toggle")){
            visit=visit^(1<<Integer.parseInt(oper[1]));
        }else if(oper[0].equals("all")){
            visit=(1<<(21))-1;
        }else{
            visit=0;
        }
    }
}