public class 합승택시 {
    public static void main(String[] args) {
        int inf = 20000001;
        int n = 6;
        int[][] dis = new int[n + 1][n + 1];
        int[][] graph = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24},
                {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dis[i][j] = inf;
            }
            dis[i][i] = 0;
        }

        for (int i = 0; i < graph.length; i++) {
            dis[graph[i][0]][graph[i][1]] = graph[i][2];
            dis[graph[i][1]][graph[i][0]] = graph[i][2];
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < dis.length; i++) {
            for (int j = 1; j < dis.length; j++) {
                System.out.printf(" %8d ", dis[i][j]);
            }
            System.out.println("\r\n");
        }

        int s = 4, a = 6, b = 2;
        int min = 20000001;
        for (int i = 1; i < n + 1; i++) {
            if ((dis[s][a] + dis[s][b]) < (dis[s][i] + dis[i][a] + dis[i][b])) {
                if (min > dis[s][a] + dis[s][b]) {
                    min = dis[s][a] + dis[s][b];
                }
            } else {
                if (min > dis[s][i] + dis[i][a] + dis[i][b]) {
                    min = dis[s][i] + dis[i][a] + dis[i][b];
                }
            }
        }
        System.out.println("min = " + min);

    }
}
