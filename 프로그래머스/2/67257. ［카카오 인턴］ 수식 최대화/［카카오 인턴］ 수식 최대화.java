import java.util.*;
class Solution {
    static char[] selectOp=new char[3];
    static boolean[] visit=new boolean[3];
    static List<Long> operand=new ArrayList<Long>();
    static List<Character> operator=new ArrayList<Character>();
    static long MAX=0;
    static char[] op= {'+','-','*'};

    void permutation(int cnt) {
        if(cnt==3) {
            List<Long>operandList=new LinkedList<Long>(operand);
            List<Character>operatorList=new ArrayList<Character>(operator);

            operandList.add(operand.get(0));

            for(int i=0;i<3;i++) {
                for(int j=0;j<operatorList.size();j++) {
                    if(selectOp[i]==operatorList.get(j)) {
                        long result=calc(operandList.remove(j),operandList.remove(j),operatorList.remove(j));
                        operandList.add(j--,result);
                    }
                }
            }
            MAX=Math.max(MAX, Math.abs(operandList.get(0)));
            return;
        }
        for(int i=0;i<3;i++) {
            if(visit[i])continue;
            visit[i]=true;
            selectOp[cnt]=op[i];
            permutation(cnt+1);
            visit[i]=false;
        }
    }

    long calc(long n1,long n2,char c) {
        switch(c) {
        case '*':
            return n1*n2;
        case '+':
            return n1+n2;
        default:
            return n1-n2;
        }
    }

    public long solution(String expression) {
        int tmp=0;
        for(int i=0;i<expression.length();i++) {
            if(expression.charAt(i)=='*' || expression.charAt(i)=='+' || expression.charAt(i)=='-') {
                operator.add(expression.charAt(i));
                operand.add(Long.parseLong(expression.substring(tmp,i)));
                tmp=i+1;
            }
        }
        operand.add(Long.parseLong(expression.substring(tmp)));

        permutation(0); 
        return MAX;
    }
}