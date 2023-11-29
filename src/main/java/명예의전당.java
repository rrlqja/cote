import java.util.*;

public class 명예의전당 {
    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        int[] solution = answer(k, score);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    private static int[] soluction(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> hallOfFame = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            hallOfFame.add(score[i]);

            Collections.sort(hallOfFame, Collections.reverseOrder());
            answer[i] = hallOfFame.get(hallOfFame.size() < k ? hallOfFame.size() - 1 : k - 1);
        }

        return answer;
    }

    private static int[] answer(int k, int[] score) {
        int[] answer = new int[score.length];

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);

            if (queue.size() > k) {
                queue.poll();
            }
            answer[i] = queue.peek();
        }
        return answer;
    }
}
