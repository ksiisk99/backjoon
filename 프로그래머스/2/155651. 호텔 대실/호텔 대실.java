import java.util.*;

class Solution {
    static class Pair {
        int start, end;

        public Pair(String start, String end) {
            this.start = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
            this.end = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]) + 10;
        }
    }
    public int solution(String[][] book_time) {
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        for (String[] s : book_time) {
            pq1.add(new Pair(s[0], s[1]));
        }

        PriorityQueue<Pair> pq2 = new PriorityQueue<>((o1, o2)->{
            return o1.end-o2.end;
        });

        pq2.add(pq1.poll());

        while (!pq1.isEmpty()) {
            Pair p1 = pq1.poll();
            Pair p2 = pq2.peek();
            if (p2.end <= p1.start) {
                pq2.poll();
            }
            pq2.add(p1);
        }

        return pq2.size();
    }

}

