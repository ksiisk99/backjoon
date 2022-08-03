class Solution {
    public int solution(String name) {
        int answer=0;
		int move=name.length()-1;
		for(int i=0;i<name.length();i++) {
			answer+=Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
			if(i<name.length() - 1 && name.charAt(i+1)=='A') {
				int end=i+1;
				while(end<name.length() && name.charAt(end)=='A')end++;
				move=Math.min(move, i*2+(name.length()-end));
				move=Math.min(move, i+(name.length()-end)*2);
			}
		}
		return answer+move;
    }
}