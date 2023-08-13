import java.util.*;

class Solution {
    private Map<String, Integer> pageNumber = new HashMap<>();
    
    class Page {
        int idx;
        int basicPoint;
        List<String> outLinks;
        double linkPoint;
        double matchPoint;
        
        Page(int idx, int basicPoint, List<String> outLinks, double linkPoint, double matchPoint) {
            this.idx=idx;
            this.basicPoint=basicPoint;
            this.outLinks = outLinks;
            this.linkPoint = linkPoint;
            this.matchPoint = matchPoint;
        }
    }
    
    String findUrl(String page) {
        String target = "<META PROPERTY=\"OG:URL\" CONTENT=\"HTTPS://";
        int idx = page.indexOf(target) + target.length();
        StringBuilder url = new StringBuilder();
         while(page.charAt(idx) != '\"') {
               url.append(page.charAt(idx++));
         }
        return url.toString();
    }
    
    private boolean isAlphabet(char c) {
        if(c>='A' && c<='Z') {
            return true;
        }
        return false;
    }
    
    private int findWord(String word, String page) {
        String startTarget = "<BODY>";
        String endTarget = "</BODY>";
        int startIdx = page.indexOf(startTarget) + startTarget.length();
        int endIdx = page.indexOf(endTarget);
        
        String body = page.substring(startIdx, endIdx);
        StringBuilder cur = new StringBuilder();
        int cnt = 0;
        
        for(int i=0;i<body.length();i++){
            if(!isAlphabet(body.charAt(i))) {
                if(cur.toString().equals(word)) {
                    cnt++;
                }
                cur=new StringBuilder();
            } else{
                cur.append(body.charAt(i));
            }
        }
        return cnt;
        
    }
    
    private List<String> findOutLinks(String page) {
        List<String> result = new ArrayList<>();
        String target = "<A HREF=\"HTTPS://";
        int idx = page.indexOf(target);
        
        StringBuilder sb = new StringBuilder();
        while(idx!=-1){
            idx+=target.length();
            while(page.charAt(idx) != '\"') {
                sb.append(page.charAt(idx++));
            }
            result.add(sb.toString());
            page = page.substring(idx);
            idx = page.indexOf(target);
            sb = new StringBuilder();
        }
        return result;
    }
    
    private void calculateLinkPoint(List<Page> answer) {
        for(int i=0;i<answer.size();i++){
            List<String> links = answer.get(i).outLinks;
            
            for(String link:links) {
                if(pageNumber.containsKey(link)) {
                    int targetIdx = pageNumber.get(link);
                    answer.get(targetIdx).linkPoint += (double)answer.get(i).basicPoint / links.size();
                }
            }
        }
        
        for(int i=0;i<answer.size();i++){
            answer.get(i).matchPoint = (double)answer.get(i).basicPoint + (double)answer.get(i).linkPoint;
        }
    }
    
    public int solution(String word, String[] pages) {
        List<Page> answer = new ArrayList<>();
        
        word = word.toUpperCase();
        for(int i=0;i<pages.length;i++) {
            String page = pages[i].toUpperCase();
            
            String url = findUrl(page);
            pageNumber.put(url, i);
            
            int basicPoint = findWord(word, page);
            
            List<String> outLinks = findOutLinks(page);
            answer.add(new Page(i,basicPoint,outLinks,0.0, 0.0));            
        }
        calculateLinkPoint(answer);
        Collections.sort(answer, (a, b) ->{
           if(a.matchPoint == b.matchPoint) {
               return a.idx-b.idx;
           } 
            if(b.matchPoint > a.matchPoint) {
                return 1;
            }
            return -1;
        });
                       
        return answer.get(0).idx;
    }
}