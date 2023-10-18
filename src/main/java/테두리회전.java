public class 테두리회전 {

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}};

        int num = 1;
        int[][] mat = new int[rows + 1][columns + 1];
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                mat[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int min = num;
            int[] query = queries[i];
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            int first = mat[x1][y2];
            for (int j = y2; j > y1; j--) {
                mat[x1][j] = mat[x1][j - 1];
                if (min > mat[x1][j]) {
                    min = mat[x1][j];
                }
            }
            for (int j = x1; j < x2; j++) {
                mat[j][y1] = mat[j + 1][y1];
                if (min > mat[j][y1]) {
                    min = mat[j][y1];
                }
            }
            for (int j = y1; j < y2; j++) {
                mat[x2][j] = mat[x2][j + 1];
                if (min > mat[x2][j]) {
                    min = mat[x2][j];
                }
            }
            for (int j = x2; j > x1; j--) {
                mat[j][y2] = mat[j - 1][y2];
                if (min > mat[j][y2]) {
                    min = mat[j][y2];
                }
            }
            mat[x1+1][y2] = first;
            if (min > first) {
                min = first;
            }
            answer[i] = min;
        }

        for (int i = 1; i < columns + 1; i++) {
            for (int j = 1; j < rows + 1; j++) {
                System.out.printf(" %5d ", mat[i][j]);
            }
            System.out.println("\r\n");
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.printf(" %5d ", answer[i]);
        }

    }
}
