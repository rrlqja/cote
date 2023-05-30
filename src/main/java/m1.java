public class m1 {
    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries={{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int[] solution = solution(rows, columns, queries);

        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }

    }

    private static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] matrix = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = cnt++;
            }
        }

        for (int i = 0; i < queries.length; i++) {

            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int start = matrix[x1][y1];
            int min = start;

            for (int j = x2; j > x1; j--) {
                matrix[j][y1] = matrix[j - 1][y1];
                if (min > matrix[j][y1]) {
                    min = matrix[j][y1];
                }
            }

            for (int j = y1; j < y2; j++) {
                matrix[x1][j] = matrix[x1][j + 1];
                if (min > matrix[j][y2]) {
                    min = matrix[j][y2];
                }
            }

            for (int j = y2; j > y1; j--) {
                matrix[x2][y2] = matrix[x2][y2 - 1];
                if (min > matrix[x2][j]) {
                    min = matrix[x2][j];
                }
            }

            for (int j = x1; j < x2; j++) {
                matrix[j][y2] = matrix[j + 1][y2];
                if (min > matrix[j][y2]) {
                    min = matrix[j][y2];
                }
            }

            matrix[x1][y1] = start;
            if (min > matrix[x1][y1]) {
                min = matrix[x1][y1];
            }

            answer[i] = min;

            System.out.println("*************************************************");

            for (int k = 0; k < matrix.length; k++) {
                for (int l = 0; l < matrix[k].length; l++) {
                    System.out.print(String.format("%5d", matrix[k][l]));
                }
                System.out.println("\r");
            }

            System.out.println("*************************************************");

        }

        return answer;
    }
}
