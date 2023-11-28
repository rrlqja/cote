import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        int[] soluction = solution(answers);

        for (int i : soluction) {
            System.out.println(i);
        }

    }

    private static int[] solution(int[] answers) {
        int[] answer = {};
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            int a = answers[i];
            if (a == p1[i % p1.length]) {
                score[0]++;
            }
            if (a == p2[i % p2.length]) {
                score[1]++;
            }
            if (a == p3[i % p3.length]) {
                score[2]++;
            }
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        List<Integer> list = new ArrayList<>();
        if (max == score[0]) {
            list.add(1);
        }
        if (max == score[1]) {
            list.add(2);
        }
        if (max == score[2]) {
            list.add(3);
        }

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
