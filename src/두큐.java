public class 두큐 {

    static int totalStep = -1;

    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
        }
        solve(queue1, queue2, sum1, sum2);
        solve(queue2, queue1, sum2, sum1);

        return answer;
    }

    public static void solve(int[] q1, int[] q2, long sum1, long sum2) {
        boolean first = true;
        int step = 0;
        for (int i = 0; i < q1.length; i++) {
            long tmp1 = sum1;
            long tmp2 = sum2;
            for (int j = 0; j < q2.length; j++) {
                tmp1 += q2[j];
                tmp2 -= q2[j];
                step += 1;
                if (tmp1 == tmp2) {
                    step = i + step;
                    if (first) {
                        totalStep = step;
                        first = false;
                    }
                    totalStep = Math.min(totalStep, step);
                    System.out.println(totalStep);
                    return;
                }
            }
            sum2 += q1[i];
            sum1 -= q1[i];
            step = 0;
        }
    }

    public static void main(String[] args) {
        두큐 q = new 두큐();
        int[] q1 = {1, 2, 1, 2};
        int[] q2 = {1, 10, 1, 2};
        q.solution(q1, q2);
    }
}
