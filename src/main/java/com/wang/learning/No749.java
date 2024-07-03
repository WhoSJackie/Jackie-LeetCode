package com.wang.learning;

import java.util.*;

public class No749 {
    int[][] g;
    int n, m, ans;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] vis;
    int search(int _x, int _y, Set<Integer> s1, Set<Integer> s2) {
        int ans = 0;
        Deque<int[]> d = new ArrayDeque<>();
        vis[_x][_y] = true;
        d.addLast(new int[]{_x, _y});
        s1.add(_x * m + _y);
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1];
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1], loc = nx * m + ny;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) continue;
                if (g[nx][ny] == 1) {
                    s1.add(loc);
                    vis[nx][ny] = true;
                    d.addLast(new int[]{nx, ny});
                } else if (g[nx][ny] == 0) {
                    s2.add(loc);
                    ans++;
                }
            }
        }
        return ans;
    }
    int getCnt() {
        vis = new boolean[n][m];
        int max = 0, ans = 0;
        // l1: 每个连通块的点集 s2: 每个连通块的候选感染点集
        List<Set<Integer>> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1 && !vis[i][j]) {
                    // s1: 当前连通块的点集 s2: 当前连通块的候选感染点集
                    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
                    int b = search(i, j, s1, s2), a = s2.size();
                    if (a > max) {
                        max = a; ans = b;
                    }
                    l1.add(s1); l2.add(s2);
                }
            }
        }
        for (int i = 0; i < l2.size(); i++) {
            for (int loc : l2.get(i).size() == max ? l1.get(i) : l2.get(i)) {
                int x = loc / m, y = loc % m;
                g[x][y] = l2.get(i).size() == max ? -1 : 1;
            }
        }
        return ans;
    }
    public int containVirus(int[][] _g) {
        g = _g;
        n = g.length; m = g[0].length;
        while (true) {
            int cnt = getCnt();
            if (cnt == 0) break;
            ans += cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No749().containVirus(new int[][]{{0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}}));
    }

}
