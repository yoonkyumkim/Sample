import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        List<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();

        for(int num : reserve) {
            reserveList.add(num);
        }
        for(int num : lost) {
            lostList.add(num);
        }
        Collections.sort(reserveList);
        Collections.sort(lostList);

        int num;
        int l;

        for (int r : reserve) {
            if (lostList.contains(r)) {
                lostList.remove(lostList.indexOf(r));
                reserveList.remove(reserveList.indexOf(r));
                answer++;
            }
        }

        for (int i = 0; i < reserveList.size(); i++) {
            num = reserveList.get(i);
            for (int j = 0; j < lostList.size(); j++) {
                l = lostList.get(j);
                if ((l - 1) == num) {
                    lostList.remove(lostList.indexOf(l));
                    answer++;
                    break;
                } else if ((l + 1) == num) {
                    lostList.remove(lostList.indexOf(l));
                    answer++;
                    break;
                }
            }
        }

        System.out.println(n - lost.length + answer);
        return n - lost.length + answer;
    }

    public static void main(String[] args) {
        체육복 C = new 체육복();
        int[] lost = {1, 2, 5, 6, 10, 12, 13};
        int[] reserve = {2, 3, 4, 5, 7, 8, 9, 10, 11, 12};
        C.solution(13, lost, reserve);
    }
}
