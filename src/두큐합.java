import java.util.LinkedList;
import java.util.Queue;

public class 두큐합 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        long totalSum;
        int count = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        totalSum = sum1 + sum2;

        int tmp;
        while (true) {
            if (count > 600000)
                return -1;
            if (sum1 == totalSum/2) {
                System.out.println(count);
                return count;
            }

            if (sum1 > totalSum/2) {
                tmp = q1.remove();
                q2.add(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            }
            else if (sum1 < totalSum/2) {
                tmp = q2.remove();
                q1.add(tmp);
                sum2 -= tmp;
                sum1 += tmp;
            }
            count++;
        }

    }




    public static void main(String[] args) {
        두큐합 q = new 두큐합();
        int[] q1 = {1, 2, 1, 2};
        int[] q2 = {1, 10, 1, 2};
        q.solution(q1, q2);
    }
}
