import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        int solution = solution(nums);
        System.out.println(solution);
    }

    private static int solution(int[] nums) {
        int answer = 0;

        int max = nums.length / 2;

        Set<Integer> ponketmon = new HashSet<>();
        for (int num : nums) {
            ponketmon.add(num);
        }

        if (ponketmon.size() > max) {
            answer = max;
        } else {
            answer = ponketmon.size();
        }

        return answer;
    }
}
