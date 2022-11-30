import java.util.ArrayList;
import java.util.List;

public class 삼총사 {
    static int answer = 0;
    public int solution(int[] number) {

        List<Integer> arr = new ArrayList<>();
        for (int num : number) {
            arr.add(num);
        }
        List<Integer> result = new ArrayList<>();

        combi(arr, result, 0, arr.size(), 3);

        return answer;
    }

    public static void combi(List<Integer> arr, List<Integer> result, int idx, int n, int r) {
        if (r == 0) {
            int temp = 0;
            for (int num : result) {
                temp += num;
            }
            if (temp == 0)
                answer++;

        }

        for (int i = idx; i < n; i++) {
            result.add(arr.get(i));
            combi(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        삼총사 s = new 삼총사();
        int[] number = {-2, 3, 0, 2, -5};
        s.solution(number);
    }
}
