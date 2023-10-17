public class 플로이드와샬 {
    public static void main(String[] args) {
        int graph[][] = {{0, 10, 5, 9999, 9999}, {9999, 0, 2, 1, 9999},
                {9999, 3, 0, 9, 2}, {9999, 9999, 9999, 0, 4}, {7, 9999, 9999, 6, 0}};

        floydWarshall(graph);
    }

    static void floydWarshall(int g[][]) {
        int dist[][] = new int[5][5];
        int i, j, k;

        for (i = 0; i < 5; i++)
            for (j = 0; j < 5; j++)
                dist[i][j] = g[i][j];

        for (k = 0; k < 5; k++) {
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);
    }

    static void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (dist[i][j] == 9999)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

}
