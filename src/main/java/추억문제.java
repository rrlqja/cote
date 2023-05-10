public class 추억문제 {

    public static void main(String[] args) {
//        String[] name = {"may", "kein", "kain", "radi"};
//        int[] yearning = {5, 10, 1, 3};
//        String[][] photo = {{"may", "kein", "kain", "radi"},
//                {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};

        int[] solution = solution(name, yearning, photo);
        for (int i = 0; i < solution.length; i++) {
            System.out.println("solution[i] = " + solution[i]);
        }
    }

    private static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;

            for (int j = 0; j < photo[i].length; j++) {
                for (int k = 0; k < name.length; k++) {
                    if (photo[i][j].equals(name[k])) {
                        sum += yearning[k];
                        break;
                    }
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
