public class 숫자표현 {

    public int solution(int n) {
        int answer = 0;

        int start = 1;
        int sum = 0;
        while (start <= n) {
            sum = start;
            for (int i = start + 1; sum <= n; i++) {
                if (sum == n)
                    answer++;
                sum += i;
            }
            start++;
        }
        return answer;
    }

    public static void main(String[] args) {
        숫자표현 s = new 숫자표현();
        System.out.println(s.solution(15));
    }


    // 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있다.
    public int expressions(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2) {
            if (num % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}
