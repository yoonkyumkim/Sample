public class 멀리뛰기 {

    public long solution(int n) {
        final long[] arr = new long[2000];

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] % 1234567;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        멀리뛰기 m = new 멀리뛰기();
        m.solution(4);
    }
}
