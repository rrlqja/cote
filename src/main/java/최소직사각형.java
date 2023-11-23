public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {5, 15}};

        int solution = solution(sizes);

        System.out.println(solution);
    }

    private static int solution(int[][] sizes) {
        int answer = 0;

        int max = 0;
        int min = 0;
        for (int[] size : sizes) {
            if (size[0] >= size[1]) {
                if (size[0] > max) {
                    max = size[0];
                }
                if (size[1] > min) {
                    min = size[1];
                }
            } else {
                if (size[1] > max) {
                    max = size[1];
                }
                if (size[0] > min) {
                    min = size[0];
                }
            }
        }
        answer = max * min;

        return answer;
    }
}
