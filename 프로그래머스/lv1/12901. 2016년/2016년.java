class Solution {
    public String solution(int a, int b) {
        String[] week={"","FRI","SAT","SUN","MON","TUE","WED","THU"};
        int days[]={0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        int sum=b;
        for(int day=1; day<a; day++){
            sum+=days[day];
        }
        //System.out.println(sum);
        return week[(sum%7)==0?7:sum%7];
    }
}