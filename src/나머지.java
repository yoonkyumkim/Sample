public class 나머지 {

    public int solution(int n) {
        int max = n;
        for (int i = 3; i < n; i++) {
            if (n % i == 1)
                max = Math.min(max,i);

        }

        return max;
    }
}
