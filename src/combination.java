import java.util.ArrayList;
import java.util.List;

public class combination {

    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");

        List<String> result = new ArrayList<>();
        reculsion(arr, result, 0, arr.size(), 2);

    }

    /**
     * 조합 구하기
     *
     * @param arr    : 기준 리스트
     * @param result : 결과를 담아줄 리스트
     * @param index  : 반복문 시작 인덱스
     * @param n      : 전체 갯수
     * @param r      : 뽑을 갯수
     */
    private static void reculsion(List<String> arr, List<String> result, int index, int n, int r) {

        if (r == 0) {

            System.out.println(result.toString());
            return;
        }

        for (int i = index; i < n; i++) {

            result.add(arr.get(i));
            reculsion(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }
}
