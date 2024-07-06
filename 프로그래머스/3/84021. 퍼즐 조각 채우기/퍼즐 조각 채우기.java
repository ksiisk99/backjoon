import java.util.*;
import java.util.stream.*;

class Solution {
    static List<List<Pair>> empties = new ArrayList<>();
    static List<List<Pair>> puzzles = new ArrayList<>();
    static boolean[][] visit = new boolean[51][51];
    static int answer = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int N;

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static List<Pair> reposZero(List<Pair> pos) {
        int min_i = N;
        int min_j = N;
        for (Pair pair : pos) {
            min_i = Math.min(min_i, pair.first);
            min_j = Math.min(min_j, pair.second);
        }

        for (Pair pair : pos) {
            pair.first -= min_i;
            pair.second -= min_j;
        }
        return pos;
    }

    static List<Pair> bfs(int[][] map, int value, int i, int j) {
        visit[i][j] = true;
        List<Pair> v = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        v.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int y = pair.first;
            int x = pair.second;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (visit[ny][nx] || map[ny][nx] != value) continue;
                visit[ny][nx] = true;
                q.add(new Pair(ny, nx));
                v.add(new Pair(ny, nx));
            }
        }
        return v;
    }

    static void rot(List<Pair> pos) {
        int row = 0;
        for (Pair pair : pos) {
            row = Math.max(row, pair.first);
        }

        for (Pair pair : pos) {
            int y = pair.first;
            int x = pair.second;
            pair.first = x;
            pair.second = row - y;
        }
    }

    static void matching() {
        boolean[] puzzleVisit = new boolean[puzzles.size()];

        for (List<Pair> empty : empties) {
            for (int puzzleIdx = 0; puzzleIdx < puzzles.size(); puzzleIdx++) {
                if (puzzleVisit[puzzleIdx]) continue;

                List<Pair> puzzle = puzzles.get(puzzleIdx);
                if (empty.size() != puzzle.size()) continue;

                boolean flag = false;
                for (int r = 0; r < 4; r++) {
                    int k = 0;

                    for (Pair emptyPair : empty) {
                        for (Pair puzzlePair : puzzle) {
                            if (emptyPair.first == puzzlePair.first && emptyPair.second == puzzlePair.second) {
                                k++;
                                continue;
                            }
                        }
                    }
                    if (k != empty.size()) {
                        rot(puzzle);
                        continue;
                    }
                    answer += empty.size();
                    puzzleVisit[puzzleIdx] = true;
                    flag = true;
                    break;
                }
                if (flag) break;
            }
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0 && !visit[i][j]) {
                    empties.add(reposZero(bfs(game_board, 0, i, j)));
                }
            }
        }

        Arrays.stream(visit).forEach(arr -> Arrays.fill(arr, false));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1 && !visit[i][j]) {
                    puzzles.add(reposZero(bfs(table, 1, i, j)));
                }
            }
        }

        matching();
        return answer;
    }
}