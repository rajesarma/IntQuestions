package interviews.dbs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MinDistance {
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static int findMinDistance(int w, int h, int n) {
        int[][] grid = new int[w][h];
        for (int i = 0; i < w; i++) {
            Arrays.fill(grid[i], -1);
        }
        return solution(n, w, h, 0, 0, grid);
    }

    static int bredthFirstSearch(int w, int h, int grid[][]) {
        int[][] dist = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                dist[i][j] = grid[i][j];
            }
        }
        int maxDistance = 0;
        Queue<Location> q = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (dist[i][j] == 0) {
                    q.add(new Location(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            maxDistance = Math.max(maxDistance, dist[x][y]);
            q.poll();
            for (int d = 0; d < 4; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];
                if (newX >= w || newY >= h || newX < 0 || newY < 0)
                    continue;
                if (dist[newX][newY] == -1) {
                    dist[newX][newY] = dist[x][y] + 1;
                    q.add(new Location(newX, newY));
                }
            }
        }
        return maxDistance;
    }

    static int solution(int left, int w, int h, int row, int col, int[][] grid) {
        if (left == 0)
            return bredthFirstSearch(w, h, grid);
        int r = row, c = col;
        if (col >= h) {
            r += col / h;
            c = col % h;
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = r; i < w; i++) {
            for (int j = c; j < h; j++) {
                grid[i][j] = 0;
                int val = solution(left - 1, w, h, i, j + 1, grid);
                minDistance = Math.min(minDistance, val);
                grid[i][j] = -1;
            }
        }
        return minDistance;
    }

    static class Location {
        int first, second;

        public Location(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }

    public static void main(String[] args) {
//        int result = findMinDistance(5,1,1);
        int result = findMinDistance(2,3,2);

        System.out.println(result);
    }
}