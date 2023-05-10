public class 로또최고최저 {
    public static void main(String[] args) {
        Integer[] lottos = {44, 1, 0, 0, 31, 25};
        Integer[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] solution = solution(lottos, win_nums);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(Integer[] lottos, Integer[] win_nums) {
        int[] answer = new int[2];

        int min = 0;
        int max = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i].equals(win_nums[j])) {
                    min++;
                    max++;
                    break;
                }
                if (lottos[i].equals(0)) {
                    max++;
                    break;
                }
            }
        }

        switch (max) {
            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;
            case 4:
                answer[0] = 3;
                break;
            case 3:
                answer[0] = 4;
                break;
            case 2:
                answer[0] = 5;
                break;
            default:
                answer[0] = 6;
                break;
        }

        switch (min) {
            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3:
                answer[1] = 4;
                break;
            case 2:
                answer[1] = 5;
                break;
            default:
                answer[1] = 6;
                break;
        }


        return answer;
    }
}
